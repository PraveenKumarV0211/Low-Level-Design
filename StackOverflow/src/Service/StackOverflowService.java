package Service;

import Entities.*;
import Enums.VoteType;
import Observer.PostObserver;
import Observer.ReputationManager;
import Strategy.SearchStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflowService {
    private final Map<UUID, User> users = new ConcurrentHashMap<>();
    private final Map<UUID, Question> questions = new ConcurrentHashMap<>();
    private final Map<UUID, Answer> answers = new ConcurrentHashMap<>();
    private final PostObserver reputationManager = new ReputationManager();

    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Question postQuestion(UUID userId, String title, String body, Set<Tag> tags) {
        User author = users.get(userId);
        Question question = new Question(UUID.randomUUID(), body, author);
        question.setTitle(title);
        question.setTags(tags);
        question.addObserver(reputationManager);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer postAnswer(UUID userId, UUID questionId, String body) {
        User author = users.get(userId);
        Question question = questions.get(questionId);
        Answer answer = new Answer(body, author);
        answer.addObserver(reputationManager);
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public void voteOnPost(UUID userId, UUID postId, VoteType voteType) {
        User user = users.get(userId);
        Post post = findPostById(postId);
        post.vote(voteType, user);
    }

    public void acceptAnswer(UUID questionId, UUID answerId) {
        Question question = questions.get(questionId);
        Answer answer = answers.get(answerId);
        question.acceptAnswer(answer);
    }

    public List<Question> searchQuestions(List<SearchStrategy> strategies) {
        List<Question> results = new ArrayList<>(questions.values());
        for (SearchStrategy strategy : strategies) {
            results = strategy.filter(results);
        }
        return results;
    }

    public User getUser(UUID userId) {
        return users.get(userId);
    }

    private Post findPostById(UUID postId) {
        if (questions.containsKey(postId)) {
            return questions.get(postId);
        } else if (answers.containsKey(postId)) {
            return answers.get(postId);
        }
        throw new NoSuchElementException("Post not found");
    }
}
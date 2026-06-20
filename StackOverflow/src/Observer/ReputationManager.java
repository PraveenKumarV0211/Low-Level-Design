package Observer;

import Entities.Event;
import Entities.User;

public class ReputationManager implements PostObserver {
    private static final int QUESTION_UPVOTE_REP = 5;
    private static final int ANSWER_UPVOTE_REP = 10;
    private static final int ACCEPTED_ANSWER_REP = 15;
    private static final int DOWNVOTE_REP_PENALTY = -1; // Penalty for the voter
    private static final int POST_DOWNVOTED_REP_PENALTY = -2; // Penalty for the post author

    @Override
    public void onPostEvent(Event event) {
        User postAuthor = event.getTargetPost().getAuthor();
        User voter = event.getActor();
        int authorScore = postAuthor.getReputation();
        switch (event.getType()) {
            case UPVOTE_QUESTION:
                postAuthor.setReputation(authorScore + QUESTION_UPVOTE_REP);
                break;
            case DOWNVOTE_QUESTION:
                postAuthor.setReputation(authorScore + POST_DOWNVOTED_REP_PENALTY);
                voter.setReputation(voter.getReputation() + DOWNVOTE_REP_PENALTY);
                break;
            case UPVOTE_ANSWER:
                postAuthor.setReputation(authorScore + ANSWER_UPVOTE_REP);
                break;
            case DOWNVOTE_ANSWER:
                postAuthor.setReputation(authorScore + POST_DOWNVOTED_REP_PENALTY);
                voter.setReputation(voter.getReputation() + DOWNVOTE_REP_PENALTY);
                break;
            case ACCEPT_ANSWER:
                postAuthor.setReputation(authorScore + ACCEPTED_ANSWER_REP);
                break;
        }
    }
}

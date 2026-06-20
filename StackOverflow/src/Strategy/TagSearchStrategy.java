package Strategy;

import Entities.Question;
import Entities.Tag;
import java.util.List;
import java.util.stream.Collectors;

public class TagSearchStrategy implements SearchStrategy {
    private final Tag tag;

    public TagSearchStrategy(Tag tag) {
        this.tag = tag;
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
                .filter(q -> q.getTags().stream().anyMatch(t -> t.getName().equals(tag.getName())))
                .collect(Collectors.toList());
    }
}
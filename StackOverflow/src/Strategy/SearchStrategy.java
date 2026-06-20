package Strategy;

import Entities.Question;
import java.util.List;

public interface SearchStrategy {
    List<Question> filter(List<Question> questions);
}
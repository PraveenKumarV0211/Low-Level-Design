package FilterStrategy;

import Entities.Directory;
import Entities.Unit;

import java.util.List;

public interface Strategy {

    boolean dofilter(Unit unit);
}

package FilterStrategy;

import Entities.Directory;
import Entities.Unit;

import java.util.List;

public interface Strategy {

    public List<Unit> dofilter(Directory dir);
    boolean dofilter(Unit unit);
}

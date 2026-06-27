package Service;

import Entities.Directory;
import Entities.Unit;
import FilterStrategy.Strategy;

import java.util.List;


public class FileSystem {
    Directory homeDirectory;
    Strategy filterStrategy;

    public FileSystem(Directory homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    public void add(Directory parent, Unit unit) {
        parent.add(unit);
    }

    public void add(Unit unit) {
        homeDirectory.add(unit);
    }

    public void setFilterStrategy(Strategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public List<Unit> search() {
        return filterStrategy.dofilter(homeDirectory);
    }

}

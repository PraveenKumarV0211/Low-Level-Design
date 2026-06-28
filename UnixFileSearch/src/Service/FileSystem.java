package Service;

import Entities.Directory;
import Entities.Unit;
import FilterStrategy.Strategy;

import java.util.ArrayList;
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
        List<Unit> result = new ArrayList<>();
        collectAll(homeDirectory, result);
        List<Unit> filtered = new ArrayList<>();
        for (Unit unit:result){
            if(filterStrategy.dofilter(unit)){
                filtered.add(unit);
            }
        }
        return filtered;
    }

    public void collectAll(Directory dir, List<Unit> result) {
        for (Unit unit : dir.getSubDirectories()) {
            result.add(unit);
            if (unit instanceof Directory directory) {
                collectAll(directory, result);
            }
        }
    }

    public List<Unit> combinedFilters(List<Strategy> filters) {
        List<Unit> result = new ArrayList<>();
        collectAll(homeDirectory, result);
        for (Strategy filter : filters) {
            List<Unit> filtered = new ArrayList<>();
            for (Unit unit : result) {
                if (filter.dofilter(unit)) {
                    filtered.add(unit);
                }
            }
            result = filtered;
        }
        return result;
    }

}

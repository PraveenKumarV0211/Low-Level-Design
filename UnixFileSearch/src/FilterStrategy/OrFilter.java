package FilterStrategy;

import Entities.Unit;

import java.util.List;

public class OrFilter implements Strategy {
    List<Strategy> filters;

    public OrFilter(List<Strategy> filters) {
        this.filters = filters;
    }

    @Override
    public boolean dofilter(Unit unit) {
        for (Strategy filter : filters) {
            if (filter.dofilter(unit)) return true;
        }
        return false;
    }


}
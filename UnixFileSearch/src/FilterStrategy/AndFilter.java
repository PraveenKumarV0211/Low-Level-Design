package FilterStrategy;

import Entities.Unit;

import java.util.List;

public class AndFilter implements Strategy {
    List<Strategy> filters;

    public AndFilter(List<Strategy> filters) {
        this.filters = filters;
    }

    @Override
    public boolean dofilter(Unit unit) {
        for (Strategy filter : filters) {
            if (!filter.dofilter(unit)) return false;
        }
        return true;
    }
}
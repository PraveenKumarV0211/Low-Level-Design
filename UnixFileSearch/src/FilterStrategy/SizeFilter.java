package FilterStrategy;

import Entities.Directory;
import Entities.Unit;

import java.util.ArrayList;
import java.util.List;

public class SizeFilter implements Strategy {
    int size;


    public SizeFilter(int size) {
        this.size = size;
    }

//    @Override
//    public List<Unit> dofilter(Directory dir) {
//        List<Unit> result = new ArrayList<>();
//        for(Unit unit : dir.getSubDirectories()){
//            if(unit.getSize() > this.size){
//                result.add(unit);
//            }
//            if(unit instanceof Directory subdirectory){
//                result.addAll(dofilter(subdirectory));
//            }
//        }
//        return result;
//    }

    @Override
    public boolean dofilter(Unit unit) {
        return unit.getSize() > this.size;
    }
}

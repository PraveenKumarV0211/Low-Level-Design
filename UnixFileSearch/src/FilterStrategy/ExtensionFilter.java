package FilterStrategy;

import Entities.Directory;
import Entities.File;
import Entities.Unit;

import java.util.ArrayList;
import java.util.List;

public class ExtensionFilter implements Strategy {
    String extension;

    public ExtensionFilter(String extension) {
        this.extension = extension;
    }

//    @Override
//    public List<Unit> dofilter(Directory dir) {
//        List<Unit> result = new ArrayList<>();
//        for(Unit unit : dir.getSubDirectories()){
//            if(unit instanceof File && ((File) unit).getExtension().equals(this.extension)){
//                result.add(unit);
//            }
//            if(unit instanceof Directory){
//                result.addAll(dofilter((Directory) unit));
//            }
//        }
//        return result;
//    }

    @Override
    public boolean dofilter(Unit unit) {
        return unit instanceof File && ((File) unit).getExtension().equals(this.extension);
    }
}

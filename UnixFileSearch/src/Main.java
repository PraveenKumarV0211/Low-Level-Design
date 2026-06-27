import Entities.Directory;
import Entities.File;
import Entities.Unit;
import FilterStrategy.ExtensionFilter;
import FilterStrategy.SizeFilter;
import Service.FileSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root", 0);
        FileSystem fs = new FileSystem(root);

        Directory docs = new Directory("docs", 0);
        Directory images = new Directory("images", 0);

        fs.add(docs);
        fs.add(images);

        fs.add(docs, new File("notes", 5, "txt"));
        fs.add(docs, new File("report", 15, "pdf"));
        fs.add(images, new File("photo", 20, "png"));
        fs.add(root, new File("readme", 10, "txt"));

        fs.setFilterStrategy(new SizeFilter(10));
        List<Unit> bigFiles = fs.search();
        System.out.println("Files with size > 10:");
        bigFiles.forEach(u -> System.out.println("  " + u.getName()));

        fs.setFilterStrategy(new ExtensionFilter("txt"));
        List<Unit> txtFiles = fs.search();
        System.out.println("TXT files:");
        txtFiles.forEach(u -> System.out.println("  " + u.getName()));
    }
}
import Entities.Directory;
import Entities.File;
import Entities.Unit;
import FilterStrategy.AndFilter;
import FilterStrategy.ExtensionFilter;
import FilterStrategy.OrFilter;
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
        fs.add(docs, new File("report", 15, "txt"));
        fs.add(docs, new File("summary", 20, "pdf"));
        fs.add(images, new File("photo", 20, "png"));
        fs.add(root, new File("readme", 10, "txt"));

        // Combined: size > 10 AND .txt
        List<Unit> result = fs.combinedFilters(List.of(
                new SizeFilter(10),
                new ExtensionFilter("txt")
        ));

        System.out.println("Files with size > 10 AND .txt:");
        result.forEach(u -> System.out.println("  " + u.getName()));

        fs.setFilterStrategy(new AndFilter(List.of(
                new SizeFilter(10),
                new ExtensionFilter("txt")
        )));
        List<Unit> result1 = fs.search();

// size > 10 OR .txt
        fs.setFilterStrategy(new OrFilter(List.of(
                new SizeFilter(10),
                new ExtensionFilter("txt")
        )));
        List<Unit> result2 = fs.search();

        System.out.println("\nAND Filter (size > 10 AND .txt):");
        result1.forEach(u -> System.out.println("  " + u.getName()));

        System.out.println("\nOR Filter (size > 10 OR .txt):");
        result2.forEach(u -> System.out.println("  " + u.getName()));
    }
}
package FileSystem;

import java.util.List;

public class Directory implements FileSystem {
    String name;
    List<FileSystem> files;

    public Directory(String name, List<FileSystem> files) {
        this.name = name;
        this.files = files;
    }

    @Override
    public void ls() {
        System.out.println("Directory is: " + name);
        for (FileSystem file : files) {
            file.ls();
        }
    }
}

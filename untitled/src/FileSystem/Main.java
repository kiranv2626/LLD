package FileSystem;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File file = new File("Kiran.txt");
        Directory directory = new Directory("Kiranv",new ArrayList<>());
        directory.files.add(file);
        Directory directory1 = new Directory("KiranV1",new ArrayList<>());
        File file1 = new File("Kiran1.txt");
        directory1.files.add(file1);
        directory.files.add(directory1);
        directory.ls();


    }
}

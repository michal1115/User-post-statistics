package utils;

import java.util.*;

import java.io.File;

public class FileSearch {
    //class used for searching for specified file
    public static Optional<String> fileRecursiveSearch(String searchingStartDir, String fileName) {
        //search for given file recursively starting from given directory

        List<File> files = new LinkedList<File>();
        Collections.addAll(files, Objects.requireNonNull(new File(searchingStartDir).listFiles()));

        for(File file : files){
            if(file.isDirectory()){
                Optional<String> location = fileRecursiveSearch(file.getPath(), fileName);
                if (location.isPresent()){
                    return location;
                }
            }
            if (file.getName().equals(fileName)){
                return Optional.of(file.getPath());
            }
        }

        return Optional.empty();
    }
}

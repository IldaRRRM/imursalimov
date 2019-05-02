package ru.job4j.scanfilesystem;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.regex.Pattern;

public class ExcludeFileVisitor extends SimpleFileVisitor<Path> {

    private final List<String> pathToFile;
    private final List<String> excludeExt;

    public ExcludeFileVisitor(List<String> pathWithFiles, List<String> excludeExt) {
        this.pathToFile = pathWithFiles;
        this.excludeExt = excludeExt;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (excludeExt.isEmpty()) {
            pathToFile.add(file.toAbsolutePath().toString());
        } else {
            boolean addToPath = false;
            String fileName = file.toAbsolutePath().toString();
            int i = 0;
            while (i < excludeExt.size()) {
                Pattern pattern = Pattern.compile(changeRegex(excludeExt.get(i)));
                boolean excludeContains = pattern.matcher(fileName).find();
                if (excludeContains) {
                    addToPath = false;
                    break;
                } else {
                    addToPath = true;
                }
                i++;
            }
            if (addToPath) {
                pathToFile.add(fileName);
            }
        }
        return FileVisitResult.CONTINUE;
    }

    private String changeRegex(String currentExtension) {
        return currentExtension.contains("*") ? "." + currentExtension : ".*" + currentExtension;
    }

}

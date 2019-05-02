package ru.job4j.archive;

import ru.job4j.scanfilesystem.Search;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ZipArchive {

    private final Args args;

    private final Zip zip;

    private final Search search;

    public ZipArchive(Args args, Zip zip, Search search) {
        this.args = args;
        this.zip = zip;
        this.search = search;
    }

    public void zipFiles() throws IOException {

        List<File> filesExclude = search.getFilesExclude(args.directory().getPath(), args.excludeFiles());

        zip.pack(filesExclude, args.output());

    }

    public static void main(String[] args) throws IOException {
        new ZipArchive(new Args(args), new Zip(), new Search()).zipFiles();
    }

}

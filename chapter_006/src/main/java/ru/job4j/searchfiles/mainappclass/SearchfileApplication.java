package ru.job4j.searchfiles.mainappclass;

import ru.job4j.searchfiles.args.Args;
import ru.job4j.searchfiles.mainmenu.MainMenu;
import ru.job4j.searchfiles.search.finder.FileFinder;
import ru.job4j.searchfiles.search.visitor.FullMatchVisitor;
import ru.job4j.searchfiles.search.visitor.MaskVisitor;
import ru.job4j.searchfiles.search.visitor.RegularVisitor;
import ru.job4j.searchfiles.search.visitor.SearchVisitor;
import ru.job4j.searchfiles.writer.ResultsWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SearchfileApplication {

    private final Args args;

    public SearchfileApplication(String... args) {
        this.args = new Args(args);
    }

    public void startApp() throws IOException {
        new MainMenu().initMenu();
        SearchVisitor visitor = choseVisitor(args.getWordFindWay(), args.getFileName());
        FileFinder fileFinder = new FileFinder(visitor);
        List<File> findestFiles = fileFinder.findFiles(args.directory().getPath());
        ResultsWriter resultsWriter = new ResultsWriter(findestFiles);
        resultsWriter.writeToFile(args.getWriteFileName());
    }

    private SearchVisitor choseVisitor(String wordFindWay, String fileName) {
        switch (wordFindWay) {
            case "-m":
                return new MaskVisitor(fileName);
            case "-r":
                return new RegularVisitor(fileName);
            case "-f":
                return new FullMatchVisitor(fileName);
            default:
                throw new IllegalArgumentException("Ключ: " + wordFindWay + " не найден");
        }
    }
}

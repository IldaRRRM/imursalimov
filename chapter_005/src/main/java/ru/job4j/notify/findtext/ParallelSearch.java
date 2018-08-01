package ru.job4j.notify.findtext;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.notify.findtext.findersimplementations.ExtensionsFinder;
import ru.job4j.notify.findtext.findersimplementations.TextFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
public class ParallelSearch {

    private final String root;
    private final String text;
    private final List<String> exts;

    private volatile boolean isFinish;

    @GuardedBy("this")
    private final BlockingQueue<String> extensionsPaths = new LinkedBlockingQueue<>();

    @GuardedBy("this")
    private final BlockingQueue<String> findestPath = new LinkedBlockingQueue<>();

    private final ExtensionsFinder extensionsFinder;


    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
        this.extensionsFinder = new ExtensionsFinder(exts, extensionsPaths);
    }

    synchronized Queue<String> getFindestPath() {
        return this.findestPath;
    }

    synchronized BlockingQueue<String> getExtensionsPaths() {
        return extensionsPaths;
    }

    public void init() throws InterruptedException {

        Thread search = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                try {
                    Files.walkFileTree(Paths.get(root), extensionsFinder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finish");

                isFinish = true;
            }
        };

        Thread read = new Thread() {
            @Override
            public void run() {
                while (!isFinish) {
                    if (!extensionsPaths.isEmpty()) {
                        while (!extensionsPaths.isEmpty()) {
                            String currentPathToFile = extensionsPaths.poll();
                            try {
                                new TextFinder(currentPathToFile, text, findestPath).read();
                            } catch (IOException e) {
                                e.printStackTrace();

                            }
                        }
                    }
                }
            }

        };

        search.start();
        read.start();

        search.join();
        read.join();

    }
}

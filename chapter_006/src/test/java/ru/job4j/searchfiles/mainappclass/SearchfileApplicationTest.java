package ru.job4j.searchfiles.mainappclass;

import java.io.IOException;

public class SearchfileApplicationTest {
    //-d /home/dar/Desktop/projects/imursalimov/chapter_006/src/test/resources/finaltask" -n *.txt, -m -o test.txt
    //-d /home/dar/Desktop/projects/imursalimov/chapter_006/src/test/resources/finaltask" -n ^part*, -r -o test.txt
    //-d /home/dar/Desktop/projects/imursalimov/chapter_006/src/test/resources/finaltask" -n partfordot.dot -f -o test.txt
    public static void main(String[] args) throws IOException {
        new SearchfileApplication(args).startApp();
    }

}
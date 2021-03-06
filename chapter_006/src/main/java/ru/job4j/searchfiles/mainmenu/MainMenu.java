package ru.job4j.searchfiles.mainmenu;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainMenu {
    public void initMenu() {
        log.info("Подсказка по ключам:" + System.lineSeparator()
                + "-d - директория, в которой начинать поиск." + System.lineSeparator()
                + "-n - имя файла, маска, либо регулярное выражение." + System.lineSeparator()
                + "-m - искать по маске, либо -f - полное совпадение имени. -r регулярное выражение." + System.lineSeparator()
                + "-o - результат записать в файл." + System.lineSeparator());
    }
}


/**
 * 1. Создать программу для поиска файла.
 * 2. Программа должна искать данные в заданном каталоге и подкаталогах.
 * 3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
 * 4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
 * Ключи
 * -d - директория в которая начинать поиск.
 * -n - имя файл, маска, либо регулярное выражение.
 * -m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.
 * -o - результат записать в файл.
 * 5. Программа должна записывать результат в файл.
 * 6. В программе должна быть валидация ключей и подсказка.
 */


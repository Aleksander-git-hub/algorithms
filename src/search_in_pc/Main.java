package search_in_pc;

/*
 Поиск файлов в папках на диске
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        searchFiles(new File("A:\\"), fileList);
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    // 1 параметр папка с которой начинаем поиск (корневая папка для поиска)
    // 2 параметр это список куда добавляем найденные файлы
    private static void searchFiles(File rootFile, List<File> fileList) {
        // является ли корневая папка папкой
        if (rootFile.isDirectory()) {
            System.out.println("searching at: " + rootFile.getAbsolutePath());
            // получим все файлы которые лежат внутри папки
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                // если что то есть в папке то для каждого файла проверим
                // если этот файл является папкой, то функция вызывает саму себя
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".jpg")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}

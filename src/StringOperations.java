import java.io.*;
import java.util.*;

public class StringOperations {
    private ArrayList<String> stringList;

    public StringOperations() {
        this.stringList = new ArrayList<>();
    }

    // Добавление и удаление объектов
    public void addObject(String str) {
        stringList.add(str);
    }

    public void removeObject(String str) {
        stringList.remove(str);
    }

    // Поиск одинаковых элементов с подсчетом совпадений
    public Map<String, Integer> findDuplicates() { //возвращает отображение (Map), где ключи - это строки, а значения - целые числа (число повторений).
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : stringList) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        return frequencyMap;
    }
    // Выгрузка в xml-файл
    public void exportToXml(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("<strings>");
            for (String str : stringList) {
                writer.println("  <string>" + str + "</string>");
            }
            writer.println("</strings>");
        }
    }
    // Реверс всех строк, входящих в коллекцию
    public void reverseStrings() {
        for (int i = 0; i < stringList.size(); i++) {
            String reversed = new StringBuilder(stringList.get(i)).reverse().toString();
            stringList.set(i, reversed);
        }
    }

    // Статистика по всем символам, содержащимся в строках коллекции
    public Map<Character, Integer> characterStatistics() {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (String str : stringList) {
            for (char c : str.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }
        return charCountMap;
    }
    // Поиск подстроки в строках коллекции
    public List<String> findSubstrings(String substring) {
        List<String> matchingStrings = new ArrayList<>();
        for (String str : stringList) {
            if (str.contains(substring)) {
                matchingStrings.add(str);
            }
        }
        return matchingStrings;
    }
    // Инициализация листа по текстовому файлу и вывод содержимого коллекции на экран
    public void initializeFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);
            }
        }
    }

    public void displayCollection() {
        for (String str : stringList) {
            System.out.println(str);
        }
    }

    // Расширить функциональность класса ArrayList методом compareInnerObjects(int firstIndex, int secondIndex)
    public boolean compareInnerObjects(int firstIndex, int secondIndex) {
        if (firstIndex >= 0 && firstIndex < stringList.size() &&
                secondIndex >= 0 && secondIndex < stringList.size()) {
            return stringList.get(firstIndex).equals(stringList.get(secondIndex));
        } else {
            return false;
        }
    }

    // Посчитать длины строк входящих в коллекцию, и вывести результат в упорядоченном виде
    public List<Integer> calculateAndSortLengths() {
        List<Integer> lengths = new ArrayList<>();
        for (String str : stringList) {
            lengths.add(str.length());
        }
        Collections.sort(lengths);
        return lengths;
    }

    // Реализовать возможность добавления в динамическую коллекцию
    public void addDynamic(String str, int maxSize) {
        if (stringList.size() < maxSize) {
            stringList.add(str);
        } else {
            stringList.remove(0);
            stringList.add(str);
        }
    }
    public static void main(String[] args) {
        StringOperations stringOps = new StringOperations();

        // Пример использования
        stringOps.addObject("Hello");
        stringOps.addObject("World");
        stringOps.addObject("Hello");
        stringOps.addObject("Java");
        stringOps.addObject("Programming");

        // Вывести коллекцию
        System.out.println("Original Collection:");
        stringOps.displayCollection();

        // Поиск одинаковых элементов с подсчетом совпадений
        System.out.println("\nDuplicate Frequencies:");
        System.out.println(stringOps.findDuplicates());

        // Реверс всех строк
        stringOps.reverseStrings();
        System.out.println("\nReversed Collection:");
        stringOps.displayCollection();

        // Статистика по символам
        System.out.println("\nCharacter Statistics:");
        System.out.println(stringOps.characterStatistics());

        // Поиск подстроки
        System.out.println("\nStrings containing 'll':");
        System.out.println(stringOps.findSubstrings("ll"));

        // Инициализация из файла
        try {
            stringOps.initializeFromFile("input.txt");
            System.out.println("\nCollection after file initialization:");
            stringOps.displayCollection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Сравнение объектов по индексам
        System.out.println("\nCompare objects at index 0 and 1: " + stringOps.compareInnerObjects(0, 1));

        // Длины строк в упорядоченном виде
        System.out.println("\nSorted lengths of strings:");
        System.out.println(stringOps.calculateAndSortLengths());

        // Добавление в динамическую коллекцию
        stringOps.addDynamic("NewString", 3);
        System.out.println("\nCollection after dynamic addition:");
        stringOps.displayCollection();

        // Экспорт в XML
        try {
            stringOps.exportToXml("output.xml");
            System.out.println("\nCollection exported to XML file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




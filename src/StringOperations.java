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

}

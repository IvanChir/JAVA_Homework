//Задание №4
//Каталог товаров книжного магазина сохранен в виде двумерного
//списка List<ArrayList<String>> так, что на 0й позиции каждого
//внутреннего списка содержится название жанра, а на остальных
//позициях - названия книг. Напишите метод для заполнения данной структуры


import java.util.ArrayList;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {
        List<ArrayList<String>> catalog = new ArrayList<>();
        catalog.add(new ArrayList<>(List.of("Проза", "Война и мир", "Буратино")));
        catalog.add(new ArrayList<>(List.of("Поэзия", "Бородино", "Евгений Онегин")));
        System.out.println(catalog);

    }
}

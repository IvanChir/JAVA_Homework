//Задание 1. Поиск ноутбуков
//        Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
//        методы.
//        -Создать множество ноутбуков.
//        -Написать метод, который будет запрашивать у пользователя критерий (или
//        критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии
//        фильтрации можно хранить в Map.
//        Например:
//        Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//        -Далее нужно запросить минимальные значения для указанных критериев -
//        сохранить параметры фильтрации можно также в Map.
//        -Отфильтровать ноутбуки их первоначального множества и вывести проходящие
//        по условиям.


import java.util.*;

public class Laptop {
    private int ram; // ОЗУ в ГБ
    private int hdd; // Объем ЖД в ГБ
    private String os; // Операционная система
    private String color; // Цвет
    public Laptop(int ram, int hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }
    public int getRam() {
        return ram;
    }
    public int getHdd() {
        return hdd;
    }
    public String getOs() {
        return os;
    }
    public String getColor() {
        return color;
    }

    public String toString() {
        return "Ноутбук {" + "RAM=" + ram + " GB" + ", HDD=" + hdd + " GB" + ", OS='" + os + '\'' + ", Color='" + color + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram && hdd == laptop.hdd &&
                os.equals(laptop.os) && color.equals(laptop.color);
    }

    public int hashCode() {
        return Objects.hash(ram, hdd, os, color);
    }
}

class LaptopStoreNew {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(8, 512, "Windows 10", "Black"));
        laptops.add(new Laptop(16, 1024, "Windows 11", "Silver"));
        laptops.add(new Laptop(8, 256, "Ubuntu", "Black"));
        laptops.add(new Laptop(32, 1024, "macOS", "Gray"));
        laptops.add(new Laptop(16, 512, "Windows 10", "White"));
        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "ОЗУ");
        criteria.put(2, "Объем HDD");
        criteria.put(3, "Операционная система (Windows 10, Windows 11, Ubuntu, macOS)");
        criteria.put(4, "Цвет");
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        boolean continueFiltering = true;
        while (continueFiltering) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            for (Map.Entry<Integer, String> entry :
                    criteria.entrySet()) {
                System.out.println(entry.getKey() + " - " +
                        entry.getValue());
            }
            int criterion = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера от символа новойстроки
            switch (criterion) {
                case 1:
                    System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
                    filters.put("ram", scanner.nextInt());
                    scanner.nextLine(); // Очистка буфера от символа новой строки
                    break;
                case 2:
                    System.out.print("Введите минимальное значение  объема HDD (в ГБ): ");
                    filters.put("hdd", scanner.nextInt());
                    scanner.nextLine(); // Очистка буфера от символа новой строки
                    break;
                case 3:
                    System.out.print("Введите операционную систему: ");
                            filters.put("os", scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Введите цвет: ");
                    filters.put("color", scanner.nextLine());
                    break;
                default:
                    System.out.println("Некорректный критерий.");
            }
            System.out.print("Хотите добавить еще один критерий? (да/нет): ");
            String response = scanner.nextLine();
            continueFiltering = response.equalsIgnoreCase("да");
        }
        filterLaptops(laptops, filters);
    }
    public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = true;
            if (filters.containsKey("ram") && laptop.getRam() <
                    (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("hdd") && laptop.getHdd() <
                    (int) filters.get("hdd")) {
                matches = false;
            }
            if (filters.containsKey("os") &&
                    !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") &&
                    !laptop.getColor().equalsIgnoreCase((String)
                            filters.get("color"))) {
                matches = false;
            }
            if (matches) {
                System.out.println(laptop);
            }
            else System.out.println("Нет ноутбуков, подходящих под указанные критерии.");

        }
    }
}
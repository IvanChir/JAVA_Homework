//Задача 3. Подсчет продуктов в корзине
//Создайте программу для учета продуктов в корзине. Программа должна
//позволять добавлять, удалять, обновлять количество продуктов, а также
//проверять наличие продуктов в корзине. Используйте HashMap для хранения
//продуктов и их количества.
//Методы:
//  ● addProduct(String product, Integer quantity): Добавляет
//продукт с указанным количеством в корзину. Если продукт уже есть,
//увеличивает его количество.
//  ● removeProduct(String product): Удаляет продукт из корзины. Если
//        продукт отсутствует, ничего не делает.
//  ● updateQuantity(String product, Integer quantity): Обновляет
//количество продукта в корзине. Если продукта нет, ничего не делает.
//  ● checkProduct(String product): Проверяет, есть ли продукт в
//корзине и возвращает его количество. Если продукта нет, возвращает 0.
//  ● showBasket(): Выводит все продукты и их количество в корзине.


import java.util.HashMap;

class ShoppingBasket {
    private HashMap<String, Integer> basket = new HashMap<>();
    // Метод для добавления продукта в корзину
    public void addProduct(String product, Integer quantity) {
        if (basket.containsKey(product)) {
            basket.put(product, basket.get(product) + quantity);
        } else {
            basket.put(product, quantity);
        }
    }
    // Метод для удаления продукта из корзины
    public void removeProduct(String product) {
        if (basket.containsKey(product)) {
            basket.remove(product);
        }
    }
    // Метод для обновления количества продукта в корзине
    public void updateQuantity(String product, Integer quantity) {
        if (basket.containsKey(product)) {
            basket.put(product, quantity);
        }
    }
    // Метод для проверки количества продукта в корзине
    public int checkProduct(String product) {
        return basket.getOrDefault(product, 0);
    }
    // Метод для вывода всех продуктов и их количества
    public void showBasket() {
        if (basket.isEmpty()) {
            System.out.println("Basket is empty.");
        } else {
            for (HashMap.Entry<String, Integer> entry :
                    basket.entrySet()) {
                System.out.println(entry.getKey() + " - " +
                        entry.getValue());
            }
        }
    }
}
// Не удаляйте и не меняйте метод Main!
public class Task3 {
    public static void main(String[] args) {
        String product1, product2, product3;
        Integer quantity1, quantity2, quantity3;
        if (args.length == 0) {
            product1 = "apple";
            quantity1 = 3;
            product2 = "banana";
            quantity2 = 2;
            product3 = "apple";
            quantity3 = 5;
        } else {
            product1 = args[0];
            quantity1 = Integer.parseInt(args[1]);
            product2 = args[2];
            quantity2 = Integer.parseInt(args[3]);
            product3 = args[4];
            quantity3 = Integer.parseInt(args[5]);
        }
        ShoppingBasket basket = new ShoppingBasket();
        basket.addProduct(product1, quantity1);
        basket.addProduct(product2, quantity2);
        basket.addProduct(product3, quantity3);
        System.out.println("Basket after adding products:");
        basket.showBasket();
        basket.removeProduct("banana");
        System.out.println("Basket after removing 'banana':");
        basket.showBasket();
        basket.updateQuantity("apple", 10);
        System.out.println("Basket after updating quantity of 'apple':");
        basket.showBasket();
        System.out.println("Quantity of 'apple': " +
                basket.checkProduct("apple"));
        System.out.println("Quantity of 'banana': " +
                basket.checkProduct("banana"));
    }
}

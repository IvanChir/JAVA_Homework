//Задача 2. Вывод всех четных чисел от 1 до 100
//Напишите метод printEvenNums, который выведет на экран все четные числа
//в промежутке от 1 до 100, каждое на новой строке.




public class Task2 {

    public static void  printEvenNums(){

        for (int i = 2; i <= 100; i++){
           System.out.println(i);
        }
    }

    public static void main(String[] args){
        Task2 ans = new Task2();
        ans.printEvenNums();
    }
}



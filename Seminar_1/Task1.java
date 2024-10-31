//Задание 1. Нахождение факториала числа
//Напишите метод factorial, который принимает число n и возвращает его
//факториал. Если число n < 0, метод должен вернуть -1.
//


import java.util.Scanner;




public class Task1 {

    public static long factorial(int n) {
        if (n < 0) {
            return -1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = console.nextInt();
        long fact = factorial(num);
        System.out.print(fact);
    }
}







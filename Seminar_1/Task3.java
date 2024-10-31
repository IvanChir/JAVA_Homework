//Задача 3. Подсчет суммы цифр числа
//Напишите метод sumDigits, который принимает целое число n и возвращает
//сумму его цифр.


import java.util.Scanner;

public class Task3 {

    public static int sumDigits(int n){

        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = console.nextInt();
        long fact = sumDigits(num);
        System.out.print(fact);
    }

}



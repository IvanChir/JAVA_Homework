//Нахождение максимального из трех чисел
//Реализуйте две функции:
//        1. Функция findMaxOfTwo должна принимать два числа и возвращать
//максимальное из них, используя только знак сравнения.
//        2. Функция findMaxOfThree должна принимать три числа и находить
//максимальное из них, используя первую функцию.


import java.util.Scanner;

public class Task4 {

    public static int finMaxOfTwo(int a, int b){
        return (a > b) ? a : b;
    }
    public static int finMaxOfThree(int a, int b, int c){
        return finMaxOfTwo(finMaxOfTwo(a, b), c);
    }

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int numOne = console.nextInt();
        System.out.print("Введите второе число: ");
        int numTwo = console.nextInt();
        System.out.print("Введите третье число: ");
        int numThree = console.nextInt();
        long finMax = finMaxOfThree(numOne, numTwo, numThree);
        System.out.print(finMax);
    }



}

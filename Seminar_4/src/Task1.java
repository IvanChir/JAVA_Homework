//Задание 1. Удаление нечетных строк
//Дан LinkedList с несколькими элементами. В методе
//removeOddLengthStrings класса LLTasks реализуйте удаление строк, длина
//которых нечетная. Используйте LinkedList и стандартные методы.


import java.util.LinkedList;

class LLTasks{
    public static void removeOddLengthStrings (LinkedList<String> linkedList){
        LinkedList<String> toRemive = new LinkedList<>();
        for (String string : linkedList){
            if (string.length() % 2 != 0){
                toRemive.add(string);
            }
        }
        linkedList.removeAll(toRemive);
    }
}

public class Task1 {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();
        if (args.length == 0) {

            ll.add("apple");
            ll.add("banana");
            ll.add("pear");
            ll.add("grape");
        } else {
            for (String arg : args) {
                ll.add(arg);
            }
        }
        LLTasks answer = new LLTasks();
        System.out.println(ll);
        answer.removeOddLengthStrings(ll);
        System.out.println(ll);
    }

}
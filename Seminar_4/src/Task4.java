//Задача 4. Сдвиг очереди
//Реализуйте метод rotateDeque в классе DequeTasks, который принимает
//Deque<Integer> и число n. Метод должен повернуть очередь вправо на n
//позиций. Если n отрицательное, повернуть влево.


import java.util.Deque;
import java.util.LinkedList;

class DequeTasks{
    public static void rotateDeque(Deque<Integer> deque, int n){
        if (deque.isEmpty()) return;
        int size = deque.size();
        n = n % size;
        if (n < 0) {
            n += size;
        }
        for (int i = 0; i < n; i++) {
            deque.addLast(deque.removeFirst());
        }
        System.out.println(deque);
    }
}

public class Task4 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        int n;
        if (args.length < 1) {

            deque.add(1);
            deque.add(2);
            deque.add(3);
            deque.add(4);
            n = 2;
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                deque.add(Integer.parseInt(args[i]));
            }
            n = Integer.parseInt(args[args.length - 1]);
        }
        DequeTasks.rotateDeque(deque, n);
    }

}

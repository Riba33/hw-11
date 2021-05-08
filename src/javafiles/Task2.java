package javafiles;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    private static Map<Integer,String> map = new TreeMap<>();
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число для указвния кол-ва элементов строки.");
        int value = sc.nextInt();
        for (int i = 1; i <= value; i++){ map.put(i,"");}
        synchronized (map) {
            new ThreadA().start();
            new ThreadB().start();
            new ThreadC().start();
            new ThreadD().start();
        }
        List<String> list = new ArrayList<>(map.values());
        System.out.println(list.stream().collect(Collectors.joining(", ")));

    }
    public static void fizz(){
        for (Map.Entry<Integer,String> entry: map.entrySet())
        {
            if (entry.getKey() % 3 == 0 && entry.getKey() % 5 != 0) map.put(entry.getKey(),"fizz");
        }
    }
    public static void buzz(){
        for (Map.Entry<Integer,String> entry: map.entrySet())
        {
            if (entry.getKey() % 5 == 0 && entry.getKey() % 3 != 0) map.put(entry.getKey(),"buzz");
        }
    }
    public static void fizzbuzz(){
        for (Map.Entry<Integer,String> entry: map.entrySet())
        {
            if (entry.getKey() % 15 == 0) map.put(entry.getKey(),"fizzbuzz");
        }
    }
    public static void number(){
        for (Map.Entry<Integer,String> entry: map.entrySet())
        {
            if (entry.getKey() % 3 != 0 && entry.getKey() % 5 != 0) map.put(entry.getKey(),String.valueOf(entry.getKey()));
        }
    }
}
class ThreadA extends Thread{
    @Override
    public void run() {
        Task2.fizz();
    }
}
class ThreadB extends Thread{
    @Override
    public void run() {
        Task2.buzz();
    }
}
class ThreadC extends Thread{
    @Override
    public void run() {
        Task2.fizzbuzz();
    }
}
class ThreadD extends Thread{
    @Override
    public void run() {
        Task2.number();
    }
}
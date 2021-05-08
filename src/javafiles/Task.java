package javafiles;

import java.text.SimpleDateFormat;
import java.util.Date;

class Task1 {
    public static void main(String[] args) throws InterruptedException {
        FiveMinutes thread2 = new FiveMinutes();
        thread2.start();
        for (int i = 1; i < 41; i++) {
            Thread.sleep(1000);
            if (i % 5 != 0) {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
                /*
                if (i % 10 == 1 & i != 11) System.out.println("Прошла " + i +" секунда.");
                else if (i % 10 == 2 || i % 10 == 3 || i % 10 == 4) System.out.println("Прошли " + i +" секунды.");
                else if (i % 10 >= 6 || i % 10 <= 9 || i == 11) System.out.println("Прошло " + i +" секунд.");
                */

        }
    }
}
class FiveMinutes extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <8; i++ ){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Прошло 5 секунд.");
        }
    }
}

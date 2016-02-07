package Threads;

import com.sun.istack.internal.NotNull;

import javax.swing.*;

/**
 * Created by Art
 */
public class ThreadOne extends Thread {

    int number;
    int sleepTime;
    String threadName;
    JTextArea textArea;

    /**
     * Класс обращается к текстовому полю и передает значение своего счетчика
     * @param number
     * @param sleepTime
     * @param nameThread
     * @param textArea
     */

    public ThreadOne(@NotNull int number, int sleepTime, String nameThread, JTextArea textArea) {
        this.threadName = nameThread;
        this.number = number;
        this.sleepTime = sleepTime;
        this.textArea = textArea;
        this.start();
    }

    @Override
    public void run() {

        currentThread().setName(threadName);

        for (int i = 1; i <= number; i++) {

            try {
                textArea.append(Integer.toString(i) + " : " + currentThread().getName()+ "\n");
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Меня отвлекли! " + this.getName());
                e.printStackTrace();
            }

        }

        super.run();
    }
}

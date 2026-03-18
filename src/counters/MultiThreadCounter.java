package counters;

import java.io.File;

public class MultiThreadCounter extends Thread {

    private File dir;
    private int count = 0;

    public MultiThreadCounter(File dir) {
        this.dir = dir;
    }

    @Override
    public void run() {

        File[] files = dir.listFiles();
        if (files == null) return;

        Thread[] threads = new Thread[files.length];
        CounterTask[] tasks = new CounterTask[files.length];

     
        for (int i = 0; i < files.length; i++) {
            tasks[i] = new CounterTask(files[i]);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

       
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
                count += tasks[i].getCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count;
    }
}
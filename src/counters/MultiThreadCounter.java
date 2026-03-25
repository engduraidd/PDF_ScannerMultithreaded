package counters;

import java.io.File;
import scanner.FileScanner;

public class MultiThreadCounter extends Thread {

    private File dir;
    private int count = 0;

    public MultiThreadCounter(File dir) {
        this.dir = dir;
    }

    @Override
    public void run() 
    {

        File[] files = dir.listFiles();
        if (files == null) return;

        int length = files.length;

        int partSize = length / 4;

        CounterTask t1Task = new CounterTask(files, 0, partSize);
        CounterTask t2Task = new CounterTask(files, partSize, partSize * 2);
        CounterTask t3Task = new CounterTask(files, partSize * 2, partSize * 3);
        CounterTask t4Task = new CounterTask(files, partSize * 3, length);

        Thread t1 = new Thread(t1Task);
        Thread t2 = new Thread(t2Task);
        Thread t3 = new Thread(t3Task);
        Thread t4 = new Thread(t4Task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      
        count = t1Task.getCount() +
                t2Task.getCount() +
                t3Task.getCount() +
                t4Task.getCount();
    }

    public int getCount() {
        return count;
    }
}
package counters;

import java.io.File;
import java.util.concurrent.*;

import scanner.FileScanner;

public class ThreadPoolCounter extends Thread {

    private File dir;
    private int count = 0;

    public ThreadPoolCounter(File dir) {
        this.dir = dir;
    }

    @Override
    public void run() {

        File[] files = dir.listFiles();
        if (files == null) return;

        
        int cores = Runtime.getRuntime().availableProcessors();

     
        int poolSize = cores / 2; 

        if (poolSize == 0) poolSize = 1; 

        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        Future<Integer>[] futures = new Future[files.length];

        
        for (int i = 0; i < files.length; i++) {

            File file = files[i];

            futures[i] = executor.submit(() -> {

                if (file.isDirectory()) {
                    return FileScanner.countPDF(file);
                } 
                else if (file.getName().toLowerCase().endsWith(".pdf")) {
                    return 1;
                }

                return 0;
            });
        }

        for (Future<Integer> future : futures) {
            try {
                count += future.get(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

    public int getCount() {
        return count;
    }
}
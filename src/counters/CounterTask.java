package counters;

import java.io.File;
import scanner.FileScanner;

public class CounterTask implements Runnable {

    private File[] files;
    private int start;
    private int end;
    private int count = 0;

    public CounterTask(File[] files, int start, int end) {
        this.files = files;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {

        for (int i = start; i < end; i++) {

            File file = files[i];

            if (file.isDirectory()) {
                count += FileScanner.countPDF(file);
            } 
            else if (file.getName().toLowerCase().endsWith(".pdf")) {
                count++;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
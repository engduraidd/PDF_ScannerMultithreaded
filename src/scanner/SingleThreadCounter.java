package scanner;
import java.io.File;
import scanner.FileScanner;


public class SingleThreadCounter extends Thread {

    private File dir;
    private int count;

    public SingleThreadCounter(File dir) {
        this.dir = dir;
    }

    @Override
    public void run() {
        count = FileScanner.countPDF(dir);
    }

    public int getCount() {
        return count;
    }

}

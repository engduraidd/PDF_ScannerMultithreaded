package scanner;
import java.io.File;


public class FileScanner {

	
	public static int countPDF(File dir) {
        int count = 0;

        File[] files = dir.listFiles();

        if (files == null) return 0;

        for (File file : files) {

            if (file.isDirectory()) {
            	
            	
                count += countPDF(file);
            }
            else if (file.getName().toLowerCase().endsWith(".pdf")) {
                count++;
            }
        }

        return count;
    }
}

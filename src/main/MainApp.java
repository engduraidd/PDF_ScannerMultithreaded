
package main;
import java.io.File;
import java.util.Scanner;

import counters.SingleThreadCounter;
public class MainApp 
{

	public static void main(String[] args) 
	
	
	{
		/**********************************StudentInfos**********************************
		Group Name: ThreadX2
		Prepared By: -> Duraid Haytham Shaba		ID: dh21290
		 			 -> Basoz Mohammed Ali			ID: bm22142
		 Course: SE422-S2
		 University: American University of Iraq (AUIS)
		 *******************************************************************************/
	Scanner scanner = new Scanner (System.in);

	
	System.out.println("Please Enter dircatory path: ");
    String path = scanner.nextLine();
	
	
	File dir = new File(path);

	if (!dir.exists() || !dir.isDirectory()) 
	{
        System.out.println("Invalid directory. Please try again.");
        return;
    }

    System.out.println("Directory accepted: " + dir.getAbsolutePath());
    
 // Step 2: Single Thread Counting
 	SingleThreadCounter singleThread = new SingleThreadCounter(dir);

 	singleThread.start();

 	try {
 	    singleThread.join(); // wait until finished
 	} catch (InterruptedException e) {
 	    e.printStackTrace();
 	}

 	System.out.println("📄 PDF Count (Single Thread): " + singleThread.getCount());
	}

	
	
}

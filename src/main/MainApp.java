
package main;
import utils.ResultPrinter;

import java.io.File;
import java.util.Scanner;
import counters.MultiThreadCounter;
import counters.SingleThreadCounter;
import counters.ThreadPoolCounter;




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
    
 	//*******************************Using only 1 thread(single)*******************************

 	SingleThreadCounter t1 = new SingleThreadCounter(dir);

 	t1.start();

 	try {
 	    t1.join();
 	} catch (InterruptedException e) {
 	    e.printStackTrace();
 	}

 	System.out.println("PDF Count (Single Thread): " + t1.getCount());
 	
 	//*******************************Using 4 threads(multi)*******************************


 	MultiThreadCounter multiThread = new MultiThreadCounter(dir);

 	multiThread.start();

 	try {
 	    multiThread.join();
 	} catch (InterruptedException e) {
 	    e.printStackTrace();
 	}

 	System.out.println(" PDF Count (Multi Thread): " + multiThread.getCount());
 	
 	//*******************************Using thread pool*******************************
 
 	ThreadPoolCounter poolCounter = new ThreadPoolCounter(dir);

 	poolCounter.start();

 	try {
 	    poolCounter.join();
 	} catch (InterruptedException e) {
 	    e.printStackTrace();
 	}

 	System.out.println("PDF Count (Thread Pool): " + poolCounter.getCount());
 	
 	//***************************Printh Results**************************************************
 	ResultPrinter printer = new ResultPrinter(
 	        t1.getCount(),
 	        multiThread.getCount(),
 	        poolCounter.getCount()
 	);

 	printer.start();
	}

	
	
}

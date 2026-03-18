
package main;
import java.io.File;
import java.util.Scanner;


public class MainApp 
{

	;public static void main(String[] args) 
	
	
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
	}

}

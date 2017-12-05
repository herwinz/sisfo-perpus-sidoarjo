/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoperpus;

/**
 *
 * @author Herwin
 */

//import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Databases
{        
	public static void eksekusi(String perintah)
	{
		// Dapatkan runtime program yang sedang berjalan
		Runtime run = Runtime.getRuntime();
		Process pr = null;
		try {
			pr = run.exec(perintah);
			pr.waitFor();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}		
	}
      
	public Databases() {
         Databases.eksekusi("gnome-www-browser");       
	}	
}

package org.thread;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DirWatcherTest {
	  public static void main(String args[]) 
	  {
		 
	    TimerTask task = new DirWatcher("C://Users//pramodyadav//Desktop//TraineesJAVA//Week2//CSV FilesAssignment 1", "csv") 
	    {
	    	 
	      protected void onChange( File file, String action ) 
	      {
	    	
	        // here we code the action on a change
	        System.out.println
	           ( "File "+ file.getName() +" action: " + action );
	      }
	    };
	    Timer timer = new Timer();
	    timer.schedule( task , new Date(), 1000 );
	    System.out.println("4");
	  }
	}


package com.nagarro.thread;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.dao.CRUDOpOnDatabase;
import com.nagarro.util.exception;


/**
 * @author pramodyadav
 *class use for taking action after CSV file modification ,addition and deletion of file.
 */
public class DirWatcherTest {
	public static  void thread()
	{

		TimerTask task = new DirWatcher("D:/CSVFile/", "csv") 
		{


			protected void onChange( File file, String action ) throws exception 
			{
				/**
				 * here we code the action on a change
				 */
				if(action.equalsIgnoreCase("add"))
				{
					/**
					 * after new file addition we read csv file then add to map
					 */
					System.out.println( "File "+ file.getName() +" action: " + action );
					CRUDOpOnDatabase ob = new CRUDOpOnDatabase();
					try {
						ob.insertData(file);
					} catch (exception e) {
						
						throw new exception(e.getMessage()); 
					}
				}

				else if(action.equalsIgnoreCase("modify"))
				{
					/**
					 * after file modification we delete previous stored csv file and then add changed file  to database
					 */
					System.out.println( "File "+ file.getName() +" action: " + action );
					CRUDOpOnDatabase ob = new CRUDOpOnDatabase();
					ob.DeleteFromDatabase(file);
					ob.insertData(file);
				}

				else if(action.equalsIgnoreCase("delete"))
				{
					/**
					 * after file deletion we delete previous stored csv file.
					 */
					System.out.println( "File "+ file.getName() +" action: " + action );
					CRUDOpOnDatabase ob = new CRUDOpOnDatabase();
					ob.DeleteFromDatabase(file);
				}
			}

		};
		Timer timer = new Timer();
		timer.schedule( task , new Date(), 1000 );

	}
}


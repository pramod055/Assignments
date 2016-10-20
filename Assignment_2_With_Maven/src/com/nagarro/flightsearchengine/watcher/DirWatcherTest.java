package com.nagarro.flightsearchengine.watcher;

import java.io.File;
import java.util.Date;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import com.nagarro.flightsearchengine.domain.FlightDetails;
import com.nagarro.flightsearchengine.service.ReadCSVAndMakeSet;
/**
 * @author pramodyadav
 *class use for taking action after CSV file modification ,addition and deletion of file.
 */
public class DirWatcherTest {
	public void pollCSVFile(final FlightDetails obj)
	{

		TimerTask task = new DirWatcher("CSVFile", "csv") 
		{


			protected void onChange( File file, String action ) 
			{
				Set<FlightDetails> resultantFlightSet = null;
				TreeMap<String,Set<FlightDetails>> filesMap =null;
				filesMap = obj.getFilesMap();
				System.out.println(filesMap.keySet());
				/**
				 * here we code the action on a change
				 */
				if(action.equalsIgnoreCase("add"))
				{
					/**
					 * after new file addition we read csv file then add to map
					 */
					System.out.println( "File "+ file.getName() +" action: " + action );
					ReadCSVAndMakeSet ob = new ReadCSVAndMakeSet();
					resultantFlightSet = ob.readCSV(file);
					filesMap.put(file.getName(), resultantFlightSet);
					obj.setFilesMap(filesMap);

				}

				else if(action.equalsIgnoreCase("modify"))
				{
					/**
					 * after file modification we delete previous stored csv file and then add changed file  to map
					 */
					System.out.println( "File "+ file.getName() +" action: " + action );

					filesMap.remove(file.getName());
					ReadCSVAndMakeSet ob = new ReadCSVAndMakeSet();
					resultantFlightSet = ob.readCSV(file);
					filesMap.put(file.getName(), resultantFlightSet);
					obj.setFilesMap(filesMap);
				}

				else if(action.equalsIgnoreCase("delete"))
				{
					/**
					 * after file deletion we delete previous stored csv file.
					 */
					System.out.println( "File "+ file.getName() +" action: " + action );
					filesMap.remove(file.getName());
					obj.setFilesMap(filesMap);
				}
			}

		};
		Timer timer = new Timer();
		timer.schedule( task , new Date(), 1000 );

	}
}


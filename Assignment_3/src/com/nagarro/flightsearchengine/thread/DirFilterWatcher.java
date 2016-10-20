package com.nagarro.flightsearchengine.thread;

import java.io.File;
import java.io.FileFilter;
/**
 * @author pramodyadav
 *class check the extension of the file
 */
public class DirFilterWatcher implements FileFilter {
	  private String filter;

	  public DirFilterWatcher() {
	    this.filter = "";
	  }

	  public DirFilterWatcher(String filter) {
	    this.filter = filter;
	  }

	  public boolean accept(File file) {
	    if ("".equals(filter)) {
	      return true;
	    }
	    return (file.getName().endsWith(filter));
	  }
	}
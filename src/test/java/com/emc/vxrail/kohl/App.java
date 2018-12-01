package com.emc.vxrail.kohl;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class App {
	public static List<String> getNumbersWithintheRange(String stringWithHyphen) {
	    List<String> numbersList = new ArrayList<>();
	    int startIndex = Integer.valueOf(stringWithHyphen.substring(0, stringWithHyphen.indexOf('-')));
	    int endIndex =
	        Integer.valueOf(
	            stringWithHyphen.substring(
	                stringWithHyphen.indexOf('-') + 1, stringWithHyphen.length()));
	    for (int i = startIndex; i <= endIndex; i++) {
	      numbersList.add(String.valueOf(i));
	    }

	    return numbersList;
	  }
	
	public static void main(String[] args) {
		String currentDir = System.getProperty("user.dir");
		String configFile = currentDir + File.separator + "cluster-config.txt";
		Path configFilePath = Paths.get(configFile);
		System.out.println(currentDir);

		Reader configReader = null;;
		try {
			configReader = Files.newBufferedReader(configFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		try {
			prop.load(configReader);
			System.out.println(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String hypen = "100-150";
		System.out.println( getNumbersWithintheRange(hypen));
		
	}
}

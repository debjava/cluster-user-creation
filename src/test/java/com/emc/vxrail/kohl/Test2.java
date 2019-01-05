package com.emc.vxrail.kohl;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Properties;

public class Test2 {

  public static void main(String[] args) throws Exception {
    String s = "The disk \"{1}\" contains {0} file(s).";
    MessageFormat form = new MessageFormat(s);
    int fileCount = 1273;
    String diskName = "MyDisk";
    Object[] testArgs = {new Long(fileCount), diskName};
    System.out.println(form.format(testArgs));
    
    
    String currentDir = System.getProperty("user.dir");
	String configFile = currentDir + File.separator + "cluster-config.txt";
	Path configFilePath = Paths.get(configFile);
	
	Reader configReader = Files.newBufferedReader(configFilePath);
	Properties configProp = new Properties();
	configProp.load(configReader);
	String userNames = configProp.getProperty("test");
	form = new MessageFormat(userNames);
	System.out.println(form.format(testArgs));
    
    
  }
}

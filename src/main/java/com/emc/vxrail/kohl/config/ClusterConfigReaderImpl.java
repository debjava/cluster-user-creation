//package com.emc.vxrail.kohl.config;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Properties;
//
//@Deprecated
//public class ClusterConfigReaderImpl implements IConfigReader {
//
//	public IClusterConfig readConfiguration(Path configFilePath) throws IOException {
//		Reader configReader = Files.newBufferedReader(configFilePath);
//		Properties configProp = new Properties();
//		configProp.load(configReader);
//		String userNames = configProp.getProperty("userNames");
//		return new ClusterConfigImpl(userNames);
//	}
//
//}

//package com.emc.vxrail.kohl;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//import com.emc.vxrail.kohl.config.ClusterConfigReaderImpl;
//import com.emc.vxrail.kohl.config.IClusterConfig;
//
//public class Test1 {
//
//	public static List<String> getClusterusers(String configFileName) throws IOException {
//		String currentDir = System.getProperty("user.dir");
//		String configFile = currentDir + File.separator + configFileName;
//		Path configFilePath = Paths.get(configFile);
//		IClusterConfig clusterConfig = new ClusterConfigReaderImpl().readConfiguration(configFilePath);
//		return clusterConfig.getClusterUsers();
//	}
//
//	public static void main(String[] args) {
//		String configFileName = "cluster-config.txt";
//		List<String> clusterUserNames;
//		try {
//			clusterUserNames = getClusterusers(configFileName);
//			System.out.println(clusterUserNames);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}

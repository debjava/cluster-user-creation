package com.emc.vxrail.kohl;

import com.emc.vxrail.kohl.config.ConfigReaderImpl;
import com.emc.vxrail.kohl.config.IClusterConfig;
import com.emc.vxrail.kohl.config.IConfigReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestAllUsers {

  private static final String CONFIG_FILE_NAME = "cluster-config.txt";

  public static IConfigReader getConfigReader(String configFileName) throws IOException {
    String currentDir = System.getProperty("user.dir");
    String configFile = currentDir + File.separator + configFileName;
    Path configFilePath = Paths.get(configFile);
    IConfigReader config = new ConfigReaderImpl(configFilePath);
    return config;
  }

  public static void main(String[] args) throws Exception {
    IConfigReader configReader = getConfigReader(CONFIG_FILE_NAME);
    IClusterConfig clusterConfig = configReader.getClusterConfiguration();
    List<String> commandsToExecute = clusterConfig.getCommandsToExecute();
    for (String s : commandsToExecute) System.out.println(s);
  }
}

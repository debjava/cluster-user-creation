package com.emc.vxrail.kohl;

import com.emc.vxrail.kohl.command.CommandExecutorImpl;
import com.emc.vxrail.kohl.command.ICommandExecutor;
import com.emc.vxrail.kohl.config.ConfigReaderImpl;
import com.emc.vxrail.kohl.config.IClusterConfig;
import com.emc.vxrail.kohl.config.IConfigReader;
import com.emc.vxrail.kohl.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.emc.vxrail.kohl.util.CommonUtil.displayInfo;
import static com.emc.vxrail.kohl.util.CommonUtil.printBanner;

public class AppRunner {
  private static final String CONFIG_FILE_NAME = "cluster-config.txt";
  protected static Logger logger = LoggerFactory.getLogger(AppRunner.class);

  private static void runApp() {
    printBanner();
    displayInfo();
    executeCommands();
  }

  private static void executeCommands() {
    IClusterConfig clusterConfig = null;
    ICommandExecutor cmdExecutor = null;
    try {
      IConfigReader config = getConfigReader(CONFIG_FILE_NAME);
      clusterConfig = config.getClusterConfiguration();

      cmdExecutor = new CommandExecutorImpl(config.getvCenterHost());
      cmdExecutor.executeCommand(clusterConfig);
      CommonUtil.printSuccessfullMessage("All users have been created successfully...");
    } catch (IOException e) {
    	e.printStackTrace();
      logger.error("{}", "Fatal error: Config file is not located in current directory.\n" + e);
      CommonUtil.printError(
          "Error - Unable to read the cluster configuration detail from the config file,"
              + "\n make sure that config file with cluster user names is available in the current directory. ");
    } catch (Exception e) {
      logger.error("{}", "Fatal error: Unable to create cluster users.\n" + e);
      CommonUtil.printError(
          "Error - Unable to create cluster users,"
              + "\n check the commands and configuration file.\nReport issuses to the development team. ");
    }
  }

  public static IConfigReader getConfigReader(String configFileName) throws IOException {
    String currentDir = System.getProperty("user.dir");
    String configFile = currentDir + File.separator + configFileName;
    Path configFilePath = Paths.get(configFile);
    IConfigReader config = new ConfigReaderImpl(configFilePath);
    return config;
  }

  public static void main(String[] args) {
    runApp();
  }
}

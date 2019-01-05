package com.emc.vxrail.kohl.config;

import com.emc.vxrail.kohl.bean.ClusterUserCreateObject;
import com.emc.vxrail.kohl.bean.VCenterHost;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfigReaderImpl implements IConfigReader {

  private VCenterHost vCenterHost;
  private IClusterConfig clusterConfig;
  private ClusterUserCreateObject clUserObj;
  private Path configFilePath;

  public ConfigReaderImpl(Path configFilePath) throws IOException {
    this.configFilePath = configFilePath;
    readConfiguration(configFilePath);
  }

  @Override
  public IClusterConfig getClusterConfiguration() {
    return new ClusterConfigImpl(clUserObj);
  }

  @Override
  public VCenterHost getvCenterHost() {
    return vCenterHost;
  }

  public void readConfiguration(Path configFilePath) throws IOException {
    Reader configReader = Files.newBufferedReader(configFilePath);
    Properties configProp = new Properties();
    configProp.load(configReader);
    // Jump host details
    String jumpHostUserName = configProp.getProperty("vcenterUserName");
    String jumpHostPassword = configProp.getProperty("vcenterPassword");
    String jumpHostIpOrHostName = configProp.getProperty("vcenteIpOrHostName");
    vCenterHost = new VCenterHost(jumpHostUserName, jumpHostPassword, jumpHostIpOrHostName);

    // Cluster user details
    String userNames = configProp.getProperty("userNames");
    String prefix = configProp.getProperty("prefix");
    String firstName = configProp.getProperty("firstName");
    String lastName = configProp.getProperty("lastName");

    String vmUserPassword = configProp.getProperty("vmUserPassword");
    String vmAdminUser = configProp.getProperty("vmAdminUser");
    String vmAdminPassword = configProp.getProperty("vmAdminPassword");
    String commandToExecute = configProp.getProperty("commandToExecute");

    clUserObj = new ClusterUserCreateObject();
    clUserObj.setUserNames(userNames);
    clUserObj.setPrefix(prefix);
    clUserObj.setFirstName(firstName);
    clUserObj.setLastName(lastName);
    clUserObj.setVmUserPassword(vmUserPassword);
    clUserObj.setVmAdminUser(vmAdminUser);
    clUserObj.setVmAdminPassword(vmAdminPassword);
    clUserObj.setCommandToExecute(commandToExecute);
  }
}

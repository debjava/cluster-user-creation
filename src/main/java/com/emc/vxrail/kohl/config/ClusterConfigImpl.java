package com.emc.vxrail.kohl.config;

import com.emc.vxrail.kohl.bean.ClusterUserCreateObject;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class ClusterConfigImpl implements IClusterConfig {
  private ClusterUserCreateObject clUserObj;

  public ClusterConfigImpl(ClusterUserCreateObject clUserObj) {
    this.clUserObj = clUserObj;
  }

  @Override
  public String getPrefix() {
    return clUserObj.getPrefix();
  }

  @Override
  public String getFirstName() {
    return clUserObj.getFirstName();
  }

  @Override
  public String getLastName() {
    return clUserObj.getLastName();
  }

  @Override
  public String getVmUserPassword() {
    return clUserObj.getVmUserPassword();
  }

  @Override
  public String getVmAdminUser() {
    return clUserObj.getVmAdminUser();
  }

  @Override
  public String getVmAdminPassword() {
    return clUserObj.getVmAdminPassword();
  }

  @Override
  public List<String> getCommandsToExecute() {
    // Provide the implementation to form the command
    List<String> commands = new ArrayList<>();
    String cmdToExecute = clUserObj.getCommandToExecute();
    MessageFormat format = new MessageFormat(cmdToExecute);
    List<String> clusterUsers = getClusterUsers();
    for (String user : clusterUsers) {
      Object[] cmdArgs = {
        getPrefix() + user,
        getFirstName(),
        getLastName(),
        getVmUserPassword(),
        getVmAdminUser(),
        getVmAdminPassword()
      };
      String formattedUser = format.format(cmdArgs);
      commands.add(formattedUser);
    }
    return commands;
  }

  @Override
  public List<String> getClusterUsers() {
    List<String> users = new ArrayList<>();
    String[] uNames = clUserObj.getUserNames().split("[,]");
    for (String user : uNames) {
      users.addAll(getNumbersWithinRange(user.trim()));
    }
    return users;
  }

  public static List<String> getNumbersWithinRange(String stringWithHyphen) {
    List<String> numbersList = new ArrayList<>();
    if (stringWithHyphen.contains("-")) {
      int startIndex =
          Integer.parseInt(stringWithHyphen.substring(0, stringWithHyphen.indexOf('-')));
      int endIndex =
          Integer.parseInt(
              stringWithHyphen.substring(
                  stringWithHyphen.indexOf('-') + 1, stringWithHyphen.length()));
      for (int i = startIndex; i <= endIndex; i++) numbersList.add(String.valueOf(i));
    } else numbersList.add(stringWithHyphen);

    return numbersList;
  }
}

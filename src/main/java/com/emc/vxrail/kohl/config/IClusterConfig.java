package com.emc.vxrail.kohl.config;

import java.util.List;

public interface IClusterConfig {
  String getPrefix();

  String getFirstName();

  String getLastName();

  String getVmUserPassword();

  String getVmAdminUser();

  String getVmAdminPassword();

  List<String> getCommandsToExecute();

  List<String> getClusterUsers();
}

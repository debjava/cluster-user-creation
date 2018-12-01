package com.emc.vxrail.kohl.command;

import com.emc.vxrail.kohl.bean.JumpHost;
import com.emc.vxrail.kohl.config.IClusterConfig;

import java.util.List;

public class CommandExecutorImpl implements ICommandExecutor {

  private JumpHost jumpHost;

  public CommandExecutorImpl(JumpHost jumpHost) {
    this.jumpHost = jumpHost;
  }

  @Override
  public void executeCommand(IClusterConfig config) {
    // Provide the implementation
    List<String> userNames = config.getClusterUsers();
//    for (String userName : userNames) {
//      System.out.println("User Name : " + userName);
//    }
    List<String> commandsToExecute = config.getCommandsToExecute();
    System.out.println("---------- Command to execute -------");
    for (String cmd : commandsToExecute) {
      System.out.println(cmd);
    }
  }
}

package com.emc.vxrail.kohl.command;

import com.emc.vxrail.kohl.bean.VCenterHost;
import com.emc.vxrail.kohl.config.IClusterConfig;
import com.emc.vxrail.kohl.ssh.SSHConnector;
import com.emc.vxrail.kohl.ssh.SSHResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CommandExecutorImpl implements ICommandExecutor {

  private VCenterHost vCenterHost;
  protected static Logger logger = LoggerFactory.getLogger(CommandExecutorImpl.class);

  public CommandExecutorImpl(VCenterHost jumpHost) {
    this.vCenterHost = jumpHost;
  }

  @Override
  public void executeCommand(IClusterConfig config) throws Exception {
    List<String> commandsToExecute = config.getCommandsToExecute();
    SSHConnector sshConnector = getSSHConnector();
    logger.debug("{}", "-------------- All Commands To be executed ------------\n");
    for (String cmd : commandsToExecute) {
      execute(cmd);
    }
  }

  private void execute(String cmd) throws Exception {
    SSHConnector sshConnector = getSSHConnector();
    String connectResponse = sshConnector.connect();
    logger.debug("Connect Response : {}", connectResponse);
    SSHResponse response = null;
    try {
      response = sshConnector.executeCommand(cmd);
      logger.debug("Command Execution Response ::: {}", response.getResponse());
      System.out.println("Command Execution Response ::: " + response.getResponse());
    } catch (Exception e) {
      logger.error("Fatal Error while executing SSH ...{}\n", e);
      throw e;
    } finally {
      sshConnector.close();
    }
  }

  private SSHConnector getSSHConnector() {
    String userName = vCenterHost.getUserName();
    String password = vCenterHost.getPassword();
    String connectionIP = vCenterHost.getIpOrHostName();
    SSHConnector sshConnector = new SSHConnector(userName, password, connectionIP);
    return sshConnector;
  }
}

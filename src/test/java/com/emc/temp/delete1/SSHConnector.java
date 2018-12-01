package com.emc.temp.delete1;

import com.jcraft.jsch.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SSHConnector {
  private JSch jschSSHChannel;
  private String userName;
  private String ipOrHostName;
  private String password;
  private Session sesConnection;
  private static final int PORT = 22;
  private static final int TIMEOUT = 60000;

  public SSHConnector(String userName, String password, String ipOrHostName) {
    this.userName = userName;
    this.password = password;
    this.ipOrHostName = ipOrHostName;
    jschSSHChannel = new JSch();
  }

  public String connect() {
    String errorMessage = null;
    try {
      sesConnection = jschSSHChannel.getSession(userName, ipOrHostName, PORT);
      sesConnection.setPassword(password);
      sesConnection.setConfig("StrictHostKeyChecking", "no");
      sesConnection.connect(TIMEOUT);
    } catch (JSchException jschX) {
      errorMessage = jschX.getMessage();
    }
    return errorMessage;
  }

  public SSHResponse executeCommand(String command) {
    SSHResponse sshResponse = null;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Channel channel = null;
    try {
      channel = sesConnection.openChannel("exec");
      ((ChannelExec) channel).setCommand(command);
      channel.setInputStream(null);
      // For Error
      ((ChannelExec) channel).setErrStream(out);
      // For Success
      InputStream in = channel.getInputStream();
      channel.connect();
      sshResponse = getShellResponse(in, out);

    } catch (IOException ie) {
      ie.printStackTrace();
    } catch (JSchException jschX) {
      jschX.printStackTrace();
    } finally {
      if (channel != null) channel.disconnect();
    }

    return sshResponse;
  }

  private SSHResponse getShellResponse(InputStream in, ByteArrayOutputStream out)
      throws IOException {
    SSHResponse sshResponse = null;
    StringBuilder outputBuffer = new StringBuilder();
    int readByte = in.read();
    while (readByte != 0xffffffff) {
      outputBuffer.append((char) readByte);
      readByte = in.read();
    }
    String errorBuffer = new String(out.toByteArray());

    return outputBuffer.toString().isEmpty()
        ? new SSHResponse(errorBuffer, SSHResponseType.FAILURE)
        : new SSHResponse(outputBuffer.toString(), SSHResponseType.SUCCESS);
  }

  public void close() {
    sesConnection.disconnect();
  }
}

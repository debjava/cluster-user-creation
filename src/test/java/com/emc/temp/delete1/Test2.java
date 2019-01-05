package com.emc.temp.delete1;

import com.jcraft.jsch.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test2 {

  private String userName = "deb";
  private String password = "abcd@1234";
  private String hostName = "192.168.176.131";
  private int port = 22;
  private String sdstestCommand = "javap java.util.Set";

  public void testconnect() throws JSchException, IOException, Exception  {

    JSch jsch = new JSch();
    Session session = jsch.getSession(userName, hostName, port);
    session.setConfig("StrictHostKeyChecking", "no");
    session.setPassword(password);
    session.connect();
//    ChannelExec channel = (ChannelExec) session.openChannel("shell");
    
    
    ChannelShell channel = (ChannelShell) session.openChannel("shell");
    
//    ((ChannelExec)channel).setPty(true);
    
    channel.sendSignal(sdstestCommand);
    
//    channel.setCommand(sdstestCommand);
    
    
    
    
    channel.setInputStream(null);
    
    
    
//    ((ChannelExec) channel).setErrStream(System.err);
    
    ((ChannelShell) channel).setExtOutputStream(System.out);
    
    
    
    InputStream in = channel.getInputStream();
    channel.connect();
    System.out.println("Unix system connected...");
    byte[] tmp = new byte[1024];
    while (true) {
      while (in.available() > 0) {
        int i = in.read(tmp, 0, 1024);
        if (i < 0) {
          break;
        }
        String line = new String(tmp, 0, i);
        System.out.println("Unix system console output: " + line);
      }
      if (channel.isClosed()) {
        break;
      }
      try {
        Thread.sleep(1000);
      } catch (Exception ee) {
        // ignore
      }
    }
    channel.disconnect();
    session.disconnect();
  }

  public static void main(String[] args) throws Exception {
    new Test2().testconnect();
  }
}

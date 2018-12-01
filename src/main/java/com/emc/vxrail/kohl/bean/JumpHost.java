package com.emc.vxrail.kohl.bean;

public class JumpHost {
  private String userName;
  private String password;
  private String ipOrHostName;

  public JumpHost(String userName, String password, String ipOrHostName) {
    this.userName = userName;
    this.password = password;
    this.ipOrHostName = ipOrHostName;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getIpOrHostName() {
    return ipOrHostName;
  }
}

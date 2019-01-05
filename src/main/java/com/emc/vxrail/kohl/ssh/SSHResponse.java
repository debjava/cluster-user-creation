package com.emc.vxrail.kohl.ssh;

public class SSHResponse {
  private String response;
  private SSHResponseType type;

  public SSHResponse(String response, SSHResponseType type) {
    this.response = response;
    this.type = type;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public SSHResponseType getType() {
    return type;
  }

  public void setType(SSHResponseType type) {
    this.type = type;
  }
}

package com.emc.vxrail.kohl.bean;

import lombok.Data;

@Data
public class ClusterUserCreateObject {
  private String userNames;
  private String prefix;
  private String firstName;
  private String lastName;

  private String vmUserPassword;
  private String vmAdminUser;
  private String vmAdminPassword;
  private String commandToExecute;

//  public String getUserNames() {
//    return userNames;
//  }
//
//  public void setUserNames(String userNames) {
//    this.userNames = userNames;
//  }
//
//  public String getPrefix() {
//    return prefix;
//  }
//
//  public void setPrefix(String prefix) {
//    this.prefix = prefix;
//  }
//
//  public String getFirstName() {
//    return firstName;
//  }
//
//  public void setFirstName(String firstName) {
//    this.firstName = firstName;
//  }
//
//  public String getLastName() {
//    return lastName;
//  }
//
//  public void setLastName(String lastName) {
//    this.lastName = lastName;
//  }
//
//  public String getVmUserPassword() {
//    return vmUserPassword;
//  }
//
//  public void setVmUserPassword(String vmUserPassword) {
//    this.vmUserPassword = vmUserPassword;
//  }
//
//  public String getVmAdminUser() {
//    return vmAdminUser;
//  }
//
//  public void setVmAdminUser(String vmAdminUser) {
//    this.vmAdminUser = vmAdminUser;
//  }
//
//  public String getVmAdminPassword() {
//    return vmAdminPassword;
//  }
//
//  public void setVmAdminPassword(String vmAdminPassword) {
//    this.vmAdminPassword = vmAdminPassword;
//  }
//
//  public String getCommandToExecute() {
//    return commandToExecute;
//  }
//
//  public void setCommandToExecute(String commandToExecute) {
//    this.commandToExecute = commandToExecute;
//  }
//
//  @Override
//  public String toString() {
//    return "ClusterUserCreateObject{"
//        + "userNames='"
//        + userNames
//        + '\''
//        + ", prefix='"
//        + prefix
//        + '\''
//        + ", firstName='"
//        + firstName
//        + '\''
//        + ", lastName='"
//        + lastName
//        + '\''
//        + ", vmUserPassword='"
//        + vmUserPassword
//        + '\''
//        + ", vmAdminUser='"
//        + vmAdminUser
//        + '\''
//        + ", vmAdminPassword='"
//        + vmAdminPassword
//        + '\''
//        + ", commandToExecute='"
//        + commandToExecute
//        + '\''
//        + '}';
//  }
}

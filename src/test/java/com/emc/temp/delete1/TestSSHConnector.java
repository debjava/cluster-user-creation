package com.emc.temp.delete1;

public class TestSSHConnector {
  public static void main(String[] args) {
      String command = "ls -l";
      String userName = "deb";
      String password = "abcd@1234";
      String connectionIP = "192.168.176.131";
      SSHConnector instance = new SSHConnector(userName, password, connectionIP);
      String errorMessage = instance.connect();

      String expResult = "FILE_NAME\n";
      // call executeCommand for each command and the output
      //(without prompts) is returned
//      String result = instance.executeCommand(command);
//      System.out.println( "Result ::: "+result );
//      result = instance.executeCommand("pwd");
//      System.out.println( "Result ::: "+result );
//
//      result = instance.executeCommand("java -version");
//      System.out.println( "Result ::: "+result );
//
//      result = instance.executeCommand("ruby -v");
//      System.out.println( "Result ::: "+result );


      SSHResponse response = instance.executeCommand("ruby -v");
      System.out.println( "Ruby Result ::: "+response.getResponse() );

      response = instance.executeCommand("abra ka dabra");
      System.out.println( "Java Result Abra ka dabra ::: "+response.getResponse() );


      // close only after all commands are sent
      instance.close();
  }
}

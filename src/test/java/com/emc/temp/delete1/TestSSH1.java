package com.emc.temp.delete1;

public class TestSSH1 {

  public static void main(String[] args) {
	  
	  		String command = "ls -l";
	     String userName = "deb";
	     String password = "abcd@1234";
	     String connectionIP = "192.168.176.131";
	     SSHManager instance = new SSHManager(userName, password, connectionIP, "");
	     String errorMessage = instance.connect();

	     if(errorMessage != null)
	     {
	        System.out.println(errorMessage);
//	        fail();
	     }

	     String expResult = "FILE_NAME\n";
	     // call executeCommand for each command and the output
	     //(without prompts) is returned
	     String result = instance.sendCommand(command);
	     System.out.println( "Result ::: "+result ); 
	     result = instance.sendCommand("pwd");
	     System.out.println( "Result ::: "+result ); 
	     
	     result = instance.sendCommand("java -version");
	     System.out.println( "Result ::: "+result ); 
	     
	     result = instance.sendCommand("ruby -v");
	     System.out.println( "Result ::: "+result ); 
	     
	     
	     String result1 = instance.sendCommand("java -version");
	     System.out.println( "Java Result ::: "+result1 ); 
	     
	     
	     // close only after all commands are sent
	     instance.close();

  }
}

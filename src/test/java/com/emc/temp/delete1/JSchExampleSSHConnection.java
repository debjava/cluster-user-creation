package com.emc.temp.delete1;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;


public class JSchExampleSSHConnection {

	/**
	 * JSch Example Tutorial
	 * Java SSH Connection Program
	 */
	public static void main(String[] args) {
	    String host="192.168.176.131";
	    String user="deb";
	    String password="abcd@1234";
//	    String command1="/home/deb/JDK8/jdk1.8.0_144/bin/java -version";
	    String command1="ruby -v";
	    try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 22);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");

			Channel channel1=(ChannelExec)session.openChannel("exec"); //$NON-NLS-1$

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			channel1.setOutputStream(baos);
			System.out.println("-------->"+new String(baos.toByteArray()));
			InputStream in=channel1.getInputStream();
			channel1.connect();

			byte[] tmp1=new byte[1024];
			while(true){
				while(in.available()>0){
					int i=in.read(tmp1, 0, 1024);
					if(i<0)break;
					System.out.print("----"+new String(tmp1, 0, i));
				}
				if(channel1.isClosed()){
					System.out.println("exit-status: "+channel1.getExitStatus());
					break;
				}
				try{Thread.sleep(1000);}catch(Exception ee){}
			}







	    	Channel channel=session.openChannel("exec");
	        ((ChannelExec)channel).setCommand(command1);

			((ChannelExec) channel).setPty(true);

	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        in=channel.getInputStream();
	        channel.connect();
	        
//	        InputStream o=channel.getExtInputStream();
//	        String text = IOUtils.toString(o, StandardCharsets.UTF_8.name());
//	        System.out.println("Test ====>["+text+"]" ); 
	        
	        
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print("----"+new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}catch(Exception ee){}
	        }
	        
	        System.out.println("InputStream : "+in.available() ); 
	        
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }

	}

}

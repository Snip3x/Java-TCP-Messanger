package Server;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.Instant;

public class MultiServer implements Runnable{
	Socket socket;
	Listener listener;
	//This Server Handles all the request from assigned Client
	public MultiServer(Socket s, Listener listener) {
		this.socket = s;
		this.listener = listener;
	}
    public void run(){
       while(true) { 
    	   try {
    		   //Setting up IO-Streams
    		   DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
    		   DataInputStream dataIn = new DataInputStream(socket.getInputStream());
    		   //Getting Request name from Clients and going to specific section to handle that request
    		   String choice = dataIn.readUTF();
    		   if(choice.equals("Message")) {//Message Section
    			   if(Database.store(dataIn.readUTF())) {//Storing Message in DB
    				   //confirming message received
    				  dataOut.writeInt(1);
    				  dataOut.flush();
    			   }else {
    			   dataOut.writeInt(0);
    			   dataOut.flush();
    			   }
    		   }else if(choice.equals("List")) {//List Section
    			   String result=Database.getData(dataIn.readUTF());
    			   dataOut.writeUTF(result);
    			   dataOut.flush();
    			   
    		   }else if(choice.equals("Get")) {//Get Section
    			   dataOut.writeUTF(Database.getMessage(dataIn.readUTF()));
    			   dataOut.flush();
    		   }else if(choice.equals("Time")) {//Time Section
    			   dataOut.writeUTF("Server Time: "+String.valueOf(Instant.now().getEpochSecond()));
    		   }else if(choice.equals("Bye")) {//Close the thread
    			   dataIn.close();
    			   dataOut.close();
    			   socket.close();
    			   break;
    		   }
    		   
			
        
        
    	   } catch (IOException e) {
    		   e.printStackTrace();
    	   }
       }
       listener.clients = listener.clients-1;
       listener.server.lClient.setText("Clients: "+listener.clients);
       listener.server.lClient.setForeground(Color.white);
       System.out.println("Thread closed");
    }
    
}

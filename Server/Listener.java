package Server;

import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;
//This Handles and all the Connect request and assign new thread to each connection
public class Listener implements Runnable {
    
    int clients ;
    boolean loop ;
    StartServer server;
    
    public Listener(StartServer server) {
    	this.server = server;
    	this.clients = 0;
    	this.loop = true;
    }

    public void run() {
        try {
        	//setting up Listener Server on Giver Port
            ServerSocket ss = new ServerSocket(server.port);
            System.out.println("Server is running on port: "+server.port);
            while (loop) {
            	//Wait for Connection
                Socket s = ss.accept();// establishes connection
                clients= clients+1;
                server.lClient.setText("Clients: "+clients);
                server.lClient.setForeground(Color.white);// counting Connected Clients
                Thread t = new Thread(new MultiServer(s,this)); // assigning new Threads to client
                t.start();

            }
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

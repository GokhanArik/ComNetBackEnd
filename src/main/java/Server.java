package main.java;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Gokhan Arik on 10/7/15.
 */
public class Server {
    public static void main(String[] args){

        int portNumber = 4444;
        boolean listening = true;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started at " + portNumber);
            while (listening) {
                new MultiServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}

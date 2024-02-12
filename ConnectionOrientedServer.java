//package ch3Processes.connectionOrientedSocket;
import java.net.*;
import java.io.*;

public class ConnectionOrientedServer {
  public static void main(String args[]) {
    try {
      int serverPort = 7896; // the server port
      try (ServerSocket listenSocket = new ServerSocket(serverPort)) {
        while (true) {
          System.out.println("I am working");
          Socket clientSocket = listenSocket.accept();
          Connection c = new Connection(clientSocket); // Handle request
        }
      }
      } 
    catch (IOException e) {
      System.out.println("Listen socket:" + e.getMessage());
    }
  }
}


import java.net.*;

import Fibonacci.FibonacciMath;
import Fibonacci.FibonacciMultithreaded;

import java.io.*;
class Connection extends Thread {
  DataInputStream in;
  DataOutputStream out;
  Socket clientSocket;
  public Connection (Socket aClientSocket) {
    try {
      clientSocket = aClientSocket;
      in = new DataInputStream(clientSocket.getInputStream());
      out = new DataOutputStream(clientSocket.getOutputStream());
      start();
    } catch (IOException e) { System.out.println("Connection:" + e.getMessage()); }
  }
  public void run() {
    try { // an echo server
      String data = in.readUTF(); // read a line of data from the stream
      //int num = Integer.parseInt(data);
      //long reply = FibonacciMath.fibo(num);
      //data = Long.toString(reply);
      String[] array = {"1","2","3","4","5","6","7"};
      FibonacciMultithreaded.main(array);
      out.writeUTF(data);
    } catch (EOFException e) { System.out.println("EOF:" + e.getMessage());
    } catch (IOException e) { System.out.println("readline:" + e.getMessage());
    } finally {
      try {
        clientSocket.close();
      } catch (IOException e) {/* close failed */
      }
    }
  }
}

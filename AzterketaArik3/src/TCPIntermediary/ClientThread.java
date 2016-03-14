package TCPIntermediary;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by gorkaolalde on 1/3/16.
 */
public class ClientThread implements Runnable {

    final String SERVER_ADDRESS = "127.0.0.1";
    final int SERVER_PORT = 6000;

    public static int clientToServerTotal = 0;
    public static int serverToClientTotal = 0;

    Socket clientSocket;
    Socket serverConnectionSocket;

    InputStreamReader clientIn;
    OutputStreamWriter clientOut;

    InputStreamReader serverIn;
    OutputStreamWriter serverOut;

    Thread serverThread, clientThread;

    boolean interceptorActive = false;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            serverConnectionSocket = new Socket(SERVER_ADDRESS, SERVER_PORT);

            clientIn = new InputStreamReader(clientSocket.getInputStream());
            clientOut = new OutputStreamWriter(clientSocket.getOutputStream());

            serverIn = new InputStreamReader(serverConnectionSocket.getInputStream());
            serverOut = new OutputStreamWriter(serverConnectionSocket.getOutputStream());

            serverThread = new Thread(() -> serverListener());
            clientThread = new Thread(() -> clientListener());

            interceptorActive = true;

            serverThread.start();
            clientThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void serverListener() {
        char[] buffer = new char[256];
        int recvLength = 0;
        do {
            try {
               recvLength = serverIn.read(buffer, 0, 255);
                if (recvLength > -1 && interceptorActive) {
                    System.out.println("Message received from server to " + clientSocket.getInetAddress() + " = " + String.copyValueOf(buffer, 0, recvLength));
                    addToServerCount();
                    System.out.println("Total messages received from server: "+getServerCount());
                    clientOut.write(buffer, 0, recvLength);
                    clientOut.flush();
                }
            } catch (IOException e) {
                interceptorActive = false;
                e.printStackTrace();
            }
        } while (interceptorActive && recvLength > -1);
    }

    public void clientListener() {
        char[] buffer = new char[256];
        int recvLength = 0;
        do {
            try {
                recvLength = clientIn.read(buffer, 0, 255);
                if (recvLength > -1 && interceptorActive) {
                    System.out.println("Message receiver from client" + clientSocket.getInetAddress() + " to server = " + String.copyValueOf(buffer, 0, recvLength));
                    addToClientCount();
                    System.out.println("Total messages received from clients: "+getClientCount());
                    serverOut.write(buffer, 0, recvLength);
                    serverOut.flush();
                }
            } catch (IOException e) {
                interceptorActive = false;
                e.printStackTrace();
            }
        } while (interceptorActive && recvLength > -1);

    }

    public synchronized void addToClientCount() {
        clientToServerTotal++;
    }

    public synchronized void addToServerCount() {
        serverToClientTotal++;
    }

    public synchronized int getClientCount() {
        return clientToServerTotal;
    }

    public synchronized int getServerCount() {
        return serverToClientTotal;
    }

    public void endTask() {
        interceptorActive = false;
        try {
            clientSocket.shutdownInput();
            clientSocket.shutdownOutput();

            serverConnectionSocket.shutdownInput();
            serverConnectionSocket.shutdownOutput();

            clientSocket.close();
            serverConnectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
package FTPServer;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gorkaolalde on 29/2/16.
 */
public class FTPServerManager {
    boolean isInitialized = false;
    boolean serverActive = true;
    final int SERVER_PORT = 6000;
    ServerSocket serverSocket;
    ExecutorService workers = Executors.newFixedThreadPool(10);

    public void initServer() {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            isInitialized = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenConnections() {
        Socket client;
        while(serverActive) {
            try {
                client = serverSocket.accept();
                System.out.println("Client connected: "+client.getInetAddress()+" "+client.getPort());
                workers.submit(new FTPServerConnThread(client));
            } catch (IOException e) {
                serverActive = false;
                e.printStackTrace();
            }
        }
    }

    public void terminateServer() {
        serverActive = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        workers.shutdown();
    }

}

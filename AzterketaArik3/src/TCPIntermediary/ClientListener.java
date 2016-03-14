package TCPIntermediary;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by gorkaolalde on 1/3/16.
 */
public class ClientListener {
    final int LISTENER_PORT = 5000;
    boolean listenerStatus = false;

    ServerSocket listener;
    ExecutorService workers = Executors.newFixedThreadPool(10);

    public void initServer() throws IOException {
        listener = new ServerSocket(LISTENER_PORT);
        listenerStatus = true;
    }


    public void listenConnections() {
        Socket client;
        while(listenerStatus) {
            try {
                client = listener.accept();
                workers.submit(new ClientThread(client));
            } catch (IOException e) {
                listenerStatus = false;
                e.printStackTrace();
            }
        }

    }

    public void stopListener() {
        listenerStatus = false;
        try {

            workers.awaitTermination(10, TimeUnit.SECONDS);
            workers.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                listener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

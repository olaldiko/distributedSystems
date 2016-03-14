package socketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gorkaolalde on 10/2/16.
 */
class SocketServer {
    private ServerSocket serverSocket;
    private final ExecutorService pool = Executors.newFixedThreadPool(100);
    private boolean exit = false;

    public void initServer(int port) throws IOException {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Error opening socket");
            throw e;
        }
    }

    public void handleConnections() throws IOException {
        Socket socket;
        ConnectionThread thread;
        while (!exit) {
            try {
                socket = serverSocket.accept();
                thread = new ConnectionThread(socket, this);
                pool.execute(thread);
            } catch (IOException e) {
                System.out.println("Error accepting connexions");
                throw e;
            }
        }
    }

    public boolean isInExitCondition() {
        return exit;
    }

    public void stopServer() throws IOException {
        exit = true;
        serverSocket.close();
        pool.shutdown();
    }
}

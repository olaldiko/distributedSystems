package socketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by gorkaolalde on 10/2/16.
 */
class ConnectionThread implements Runnable {
    private final SocketServer socketServer;
    private final Socket socket;

    public ConnectionThread(Socket socket, SocketServer socketServer) {
        this.socket = socket;
        this.socketServer = socketServer;
    }

    @Override
    public void run() {
        String msg = " ";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Client " + socket.getInetAddress() + " connected");
            while (socket.isConnected() && !socketServer.isInExitCondition() && msg != null) {
                msg = reader.readLine();
                System.out.println("Message received from " + socket.getInetAddress() + " \"" + msg + "\"");
                writer.println(msg);
                writer.flush();
            }
            System.out.println("Client " + socket.getInetAddress() + " disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

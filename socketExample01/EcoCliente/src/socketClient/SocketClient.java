package socketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * Created by gorkaolalde on 10/2/16.
 */
class SocketClient {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean connected = false;
    private final ReceiverThread receiverThread = new ReceiverThread(this);

    public void startConnection(String address, int port) throws IOException {
        socket = new Socket(address, port);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());
        connected = true;
        receiverThread.start();
    }

    public void sendMessage(String msg) {
        if (socket.isConnected()) {
            writer.println(msg);
            writer.flush();
            System.out.println("Message sent: \"" + msg + "\"");
        } else {
            System.out.println("Error sending the message");
            connected = false;
        }
    }

    public void getMessage() throws IOException {
        String msg;
        if (socket.isConnected()) {
            msg = reader.readLine();
            if (msg != null) {
                System.out.println("Message received: \"" + msg + "\"");
            } else {
                connected = false;
            }
        } else {
            System.out.println("Error in reception");
            connected = false;
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public void stopConnection() throws IOException {
        receiverThread.exitThread();
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
        connected = false;
        try {
            receiverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

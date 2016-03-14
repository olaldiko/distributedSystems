package CalculusServer;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by gorkaolalde on 10/2/16.
 */
class Principal {
    private final Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        Principal p = new Principal();
        p.exec();
    }

    private void exec() {
        int port;
        SocketServer socketServer = new SocketServer();
        System.out.println("Enter port to listen to");
        port = Integer.parseInt(kb.nextLine());
        Thread listener;
        try {
            socketServer.initServer(port);
            System.out.println("Server started, press any key to exit");
            listener = new Thread(() -> {
                try {
                    socketServer.handleConnections();
                } catch (IOException ignored) {
                }
            });
            listener.start();
            kb.nextLine();
            socketServer.stopServer();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

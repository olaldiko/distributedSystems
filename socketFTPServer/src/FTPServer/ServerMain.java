package FTPServer;

import java.util.Scanner;

/**
 * Created by gorkaolalde on 29/2/16.
 */
public class ServerMain {
    FTPServerManager server = new FTPServerManager();
    Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
       ServerMain s = new ServerMain();
        s.exec();
    }

    public void exec() {
        server.initServer();
        Thread listener = new Thread(() -> server.listenConnections());
        listener.start();
        kb.nextLine();
        server.terminateServer();

    }
}

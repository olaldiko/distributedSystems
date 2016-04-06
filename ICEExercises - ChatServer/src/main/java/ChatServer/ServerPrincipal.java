package ChatServer;

import java.util.Scanner;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
public class ServerPrincipal {
    Scanner kb = new Scanner(System.in);
    ServerCommunications server = new ServerCommunications();
    public static void main(String[] args) {
        ServerPrincipal p = new ServerPrincipal();
        p.exec();
    }

    public void exec() {
        server.initServer();
        System.out.println("Server started, press enter to exit");
        kb.nextLine();
        server.stopServer();
    }
}

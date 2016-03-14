package CalculusServer;


import java.util.Scanner;

/**
 * Created by gorkaolalde on 12/3/16.
 */
public class ServerPrincipal {
    CalculusServer server = new CalculusServer();
    Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        ServerPrincipal p = new ServerPrincipal();
        p.exec();
    }

    public void exec() {
        server.initServer();
        System.out.println("Press any key to exit");
        kb.nextLine();
    }
}

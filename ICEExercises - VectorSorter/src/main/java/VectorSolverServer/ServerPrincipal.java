package VectorSolverServer;

import java.util.Scanner;

/**
 * Created by gorkaolalde on 14/3/16.
 */
class ServerPrincipal {
    private final Scanner kb = new Scanner(System.in);
    private final VectorServer server = new VectorServer();
    public static void main(String[] args) {
        ServerPrincipal p = new ServerPrincipal();
        p.exec();
    }

    private void exec() {
        server.initServer();
        System.out.println("Press enter to exit");
        kb.nextLine();
        server.stopServer();
    }

}

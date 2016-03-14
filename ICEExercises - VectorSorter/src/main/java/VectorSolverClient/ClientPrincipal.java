package VectorSolverClient;

import java.util.Scanner;

/**
 * Created by Gorka Olalde on 14/3/16.
 */
class ClientPrincipal {
    Scanner kb = new Scanner(System.in);
    private final VectorClient client = new VectorClient();
    public static void main(String[] args) {
        ClientPrincipal p = new ClientPrincipal();
        p.exec();
    }

    private void exec() {
        client.initClient();
        client.testSorting();
        client.testUnique();
        client.stopClient();
    }
}

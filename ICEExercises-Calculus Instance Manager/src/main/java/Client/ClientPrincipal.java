package Client;

/**
 * Created by gorkaolalde on 14/3/16.
 */
public class ClientPrincipal {
    CalculusClient client = new CalculusClient();


    public static void main(String[] args) {
        ClientPrincipal p = new ClientPrincipal();
        p.exec();
    }

    public void exec() {
        client.initClient();
        client.runClient();
    }
}

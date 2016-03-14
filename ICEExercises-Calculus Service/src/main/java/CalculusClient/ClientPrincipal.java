package CalculusClient;

/**
 * Created by gorkaolalde on 12/3/16.
 */
public class ClientPrincipal {
    CalculusClient client = new CalculusClient();
    public static void main(String[] args) {
        ClientPrincipal p = new ClientPrincipal();
        p.exec();
    }

    public void exec() {
        try {
            client.initClient();
            client.runClient();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package ChatClient;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
public class ClientPrincipal {
    ChatClient client = new ChatClient();

    public static void main(String[] args) {
        ClientPrincipal p = new ClientPrincipal();
        p.exec();
    }

    public void exec() {
        client.initClient();
        client.showMenu();
        client.stopClient();
    }
}

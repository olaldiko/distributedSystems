package FTPClient;

/**
 * Created by gorkaolalde on 29/2/16.
 */
public class ClientMain {
        TextInterface iface = new TextInterface();
    public static void main(String[] args) {
        ClientMain c = new ClientMain();
        c.exec();
    }

    public void exec() {
        iface.exec();
    }
}

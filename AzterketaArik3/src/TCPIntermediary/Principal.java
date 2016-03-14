package TCPIntermediary;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by gorkaolalde on 1/3/16.
 */
public class Principal {
    Scanner kb = new Scanner(System.in);

    ClientListener listener = new ClientListener();
    public static void main(String[] args) {
        Principal p = new Principal();
        p.exec();

    }

    public void exec() {
        Thread listenerThread;
        try {
            listener.initServer();
            listenerThread = new Thread(() ->listener.listenConnections());
            listenerThread.start();
            kb.nextLine();
            listener.stopListener();
            listenerThread.join(1000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

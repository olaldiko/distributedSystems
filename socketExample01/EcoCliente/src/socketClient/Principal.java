package socketClient;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by gorkaolalde on 10/2/16.
 */
class Principal {
    private final SocketClient socketClient = new SocketClient();
    private final Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.exec();
    }

    private void exec() {
        String address;
        String msg;
        int port;
        boolean exit = false;

        System.out.println("Enter destination address: ");
        address = kb.nextLine();
        System.out.println("Enter destination port: ");
        port = Integer.parseInt(kb.nextLine());
        try {
            socketClient.startConnection(address, port);
        } catch (IOException e) {
            System.out.println("Error making the connection");
            e.printStackTrace();
        }
        if (socketClient.isConnected()) {
            while (!exit) {
                if (socketClient.isConnected()) {
                    System.out.println("Please, enter message to send(enter exit to exit):");
                    msg = kb.nextLine();
                    if (msg.equals("exit")) {
                        exit = true;
                    } else {
                        if (socketClient.isConnected()) {
                            socketClient.sendMessage(msg);
                        } else {
                            exit = true;
                        }
                    }
                }
            }
            try {
                socketClient.stopConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

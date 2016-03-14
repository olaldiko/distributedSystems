package socketClient;

import java.io.IOException;

/**
 * Created by gorkaolalde on 10/2/16.
 */
class ReceiverThread extends Thread {
    private final SocketClient sockClient;
    private volatile boolean exit = false;

    public ReceiverThread(SocketClient sockClient) {
        this.sockClient = sockClient;
    }

    @Override
    public void run() {
        while (!exit) {
            if (sockClient.isConnected()) {
                try {
                    sockClient.getMessage();
                } catch (IOException e) {
                    System.out.println("Error in reception, Thread exiting");
                    e.printStackTrace();
                    exit = true;
                }
            }
        }
    }

    public void exitThread() {
        exit = true;
    }
}


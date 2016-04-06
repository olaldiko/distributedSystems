package ChatClient;

import Ice.Communicator;
import Ice.ObjectAdapter;
import Ice.ObjectPrx;
import Ice.StringHolder;
import chat.*;

import java.util.Scanner;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
public class ChatClient {
    Scanner kb = new Scanner(System.in);
    Communicator communicator;
    ObjectPrx objectPrx;
    ChatServerPrx chatServerPrx;
    ObjectAdapter adapter;
    ListenerI listener = new ListenerI();
    ListenerPrx listenerPrx;
    public void initClient() {
        communicator = Ice.Util.initialize();
        adapter = communicator.createObjectAdapterWithEndpoints("ListenerAdapter", "tcp -h 127.0.0.1 -p 10001");
        objectPrx = adapter.add(listener, communicator.stringToIdentity("Listener"));
        listenerPrx = ListenerPrxHelper.checkedCast(objectPrx);
        adapter.activate();

        objectPrx = communicator.stringToProxy("ChatServer:tcp -h 127.0.0.1 -p 10000");
        chatServerPrx = ChatServerPrxHelper.checkedCast(objectPrx);
    }

    public void stopClient() {
        communicator.shutdown();
        communicator.destroy();
    }

    public void showMenu() {
        int option = 0;
        do {
            System.out.println("1. Send message to server");
            System.out.println("2. Get message from server");
            System.out.println("0. Exit");
            option = kb.nextInt();
            chooseAction(option);
        } while (option != 0);
    }

    private void chooseAction(int option) {
        switch(option) {
            case 1:
                sendMessage();
                break;
            case 2:
                getMessage();
                break;
            default:
                System.out.println("Unknown option");
        }
    }

    private void sendMessage() {
        String msg;
        System.out.println("Please, enter the message:");
        msg = kb.nextLine();
        chatServerPrx.pushMessage(msg, listenerPrx);
    }

    private void getMessage() {
        int msgId;
        boolean receivedOk;
        StringHolder msgHolder = new StringHolder();
        System.out.println("Please, enter the message ID:");
        msgId = kb.nextInt();
        receivedOk = chatServerPrx.getMessage(msgId, msgHolder);
        System.out.println("Received message: " + msgHolder.value);
    }
}

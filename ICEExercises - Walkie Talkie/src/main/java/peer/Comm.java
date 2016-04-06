package peer;

import Ice.Communicator;
import Ice.ObjectAdapter;
import Ice.ObjectPrx;
import Ice.Util;
import walkietalkie.CommunicatorPrx;
import walkietalkie.CommunicatorPrxHelper;

import java.util.Scanner;


/**
 * Created by Gorka Olalde on 22/3/16.
 */
public class Comm {
    CommunicatorPrx communicatorPrx;
    private final Communicator communicator = Util.initialize();
    private ObjectAdapter adapter;
    Scanner kb = new Scanner(System.in);
    Ice.Object communicatorHost = new CommunicatorI();

    public void initComm() {
        adapter = communicator.createObjectAdapterWithEndpoints("WalkieTalkie", "tcp -p 10000 -h 127.0.0.1");
        adapter.add(communicatorHost, communicator.stringToIdentity("Communicator"));
        adapter.activate();
    }

    public void connectToPeer() {
        ObjectPrx prx;
        prx = communicator.stringToProxy("Communicator");
        communicatorPrx = CommunicatorPrxHelper.checkedCast(prx);
    }

    public void sendMessage() {
        String msg;
        System.out.println("Enter message to send");
        msg = kb.nextLine();
        communicatorPrx.sendMessage(msg);
    }

    public void runWalkieTalkie() {
        initComm();
        connectToPeer();
        while(true) {
            sendMessage();
        }
    }
}

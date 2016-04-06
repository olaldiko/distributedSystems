package peer;

import Ice.Communicator;
import Ice.Current;

/**
 * Created by Gorka Olalde on 22/3/16.
 */
public class CommunicatorI extends walkietalkie._CommunicatorDisp {

    public void sendMessage(String inMsg, Current __current) {
        System.out.println("Message received: " + inMsg);
    }

}

package ChatClient;

import Ice.Current;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
public class ListenerI extends chat._ListenerDisp {

    public boolean messageNotification(int msgNumber, Current __current) {
        return false;
    }
}

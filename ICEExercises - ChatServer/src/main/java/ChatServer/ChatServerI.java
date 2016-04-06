package ChatServer;

import ChatClient.ListenerI;
import Ice.Current;
import Ice.StringHolder;
import chat.ListenerPrx;

import javax.sql.rowset.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
public class ChatServerI extends chat._ChatServerDisp {
    ArrayList<ListenerPrx> listenerList = new ArrayList<ListenerPrx>();
    Map<Integer, String> messageList = new HashMap<>();
    AtomicInteger counter = new AtomicInteger();

    public boolean registerListener(ListenerPrx listenerInstance, Current __current) {
        listenerList.add(listenerInstance);
        return true;
    }

    public boolean deleteListener(ListenerPrx listenerInstance, Current __current) {
        boolean retVal = false;
        if (listenerList.contains(listenerInstance)) {
            listenerList.remove(listenerInstance);
            retVal = true;
        }
        return retVal;

    }

    public void pushMessage(String message, ListenerPrx associatedListener, Current __current) {
        int msgNumber = counter.incrementAndGet();
        messageList.put(msgNumber, message);
    }

    public boolean getMessage(int msgNumber, StringHolder message, Current __current) {
        boolean retVal = false;
        if(messageList.containsKey(msgNumber)) {
            message.value = messageList.get(msgNumber);
            retVal = true;
        }
        return retVal;
    }

    public void notifyOthers(ListenerPrx sender, int msgId) {
        for (ListenerPrx listener : listenerList) {
            if (listener != sender) {
                listener.messageNotification(msgId);
            }
        }
    }
}

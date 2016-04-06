package ChatServer;

import Ice.Communicator;
import Ice.ObjectAdapter;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
public class ServerCommunications {

    Communicator communicator;
    ObjectAdapter adapter;
    ChatServerI server;

    public void initServer() {
        communicator = Ice.Util.initialize();
        adapter = communicator.createObjectAdapterWithEndpoints("ChatServerHandler", "tcp -h 127.0.0.1 -p 10000");
        server = new ChatServerI();
        adapter.add(server, communicator.stringToIdentity("ChatServer"));
        adapter.activate();
    }

    public void stopServer() {
        communicator.shutdown();
        communicator.destroy();
    }
}

package Server;

/**
 * Created by gorkaolalde on 14/3/16.
 */
public class CalculusServer {

    Ice.Communicator communicator;
    Ice.ObjectAdapter adapter;
    CalculatorManagerI manager;

    public void initServer() {
        communicator = Ice.Util.initialize();
        adapter = communicator.createObjectAdapterWithEndpoints("CalculusInstanceManager", "tcp -h 127.0.0.1 -p 10000");
        manager = new CalculatorManagerI(adapter);
        adapter.add(manager, communicator.stringToIdentity("CalculatorManager"));
        adapter.activate();
    }

    public void stopServer() {
        communicator.destroy();
    }
}

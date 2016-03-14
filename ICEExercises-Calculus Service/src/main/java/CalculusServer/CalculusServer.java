package CalculusServer;

/**
 * Created by gorkaolalde on 12/3/16.
 */
public class CalculusServer {
        Ice.Communicator communicator = Ice.Util.initialize();
        Ice.ObjectAdapter adapter;

    public void initServer() {
        Ice.Object calculator = new CalculatorI();
        adapter = communicator.createObjectAdapterWithEndpoints("CalculusAdapter", "default -p 10000");
        adapter.add(calculator, communicator.stringToIdentity("Calculator"));
        adapter.activate();
        communicator.waitForShutdown();
    }
}

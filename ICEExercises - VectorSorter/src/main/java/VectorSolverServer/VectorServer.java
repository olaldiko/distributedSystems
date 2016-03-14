package VectorSolverServer;

import Ice.Communicator;
import Ice.ObjectAdapter;
import utils.VectorManipulator;

/**
 * Created by gorkaolalde on 14/3/16.
 */
class VectorServer {
    private Communicator communicator;
    private final VectorManipulator manipulator = new VectorManipulatorI();
    public void initServer() {
        communicator = Ice.Util.initialize();
        ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("VectorSorterAdapter", "tcp -h 127.0.0.1 -p 10000");
        adapter.add(manipulator, communicator.stringToIdentity("VectorManipulator"));
        adapter.activate();

    }

    public void stopServer() {
        communicator.shutdown();
        communicator.destroy();
    }

}

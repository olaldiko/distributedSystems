package VectorSolverClient;

import Ice.Communicator;
import Ice.ObjectPrx;
import utils.IntVectorHolder;
import utils.VectorManipulatorPrx;
import utils.VectorManipulatorPrxHelper;

import java.util.Arrays;

/**
 * Created by gorkaolalde on 14/3/16.
 */
class VectorClient {
    Communicator communicator;
    ObjectPrx objectPrx;
    VectorManipulatorPrx manipulatorPrx;

    public void initClient() {
        communicator = Ice.Util.initialize();
        objectPrx = communicator.stringToProxy("VectorManipulator:tcp -h 127.0.0.1 -p 10000");
        manipulatorPrx = VectorManipulatorPrxHelper.checkedCast(objectPrx);
    }

    public void stopClient() {
        communicator.shutdown();
        communicator.destroy();
    }

    public void testSorting() {
        int[] inVector = {10, 2, 1, 9, 5, 120, 55, 67, 33, 12, 45, 87, 76};
        IntVectorHolder outVectorHolder = new IntVectorHolder();
        System.out.println("Input vector for sorting: ");
        Arrays.stream(inVector).forEach(i -> System.out.print(" " + i));
        System.out.println();
        manipulatorPrx.sort(inVector, outVectorHolder);
        System.out.println("Ordered vector: ");
        Arrays.stream(outVectorHolder.value).forEach(i -> System.out.print(" " + i));
        System.out.println();
    }

    public void testUnique() {
        int[] inVector = {2, 4, 6, 2, 2, 3, 5, 8, 10, 6, 5};
        IntVectorHolder outVectorHolder = new IntVectorHolder();
        System.out.println("Input vector for filtering: ");
        Arrays.stream(inVector).forEach(i -> System.out.print(" " + i));
        System.out.println();
        manipulatorPrx.copyWithoutDuplicates(inVector, outVectorHolder);
        System.out.println("Vector with only unique values: ");
        Arrays.stream(outVectorHolder.value).forEach(i -> System.out.print(" " + i));
        System.out.println();
    }


}

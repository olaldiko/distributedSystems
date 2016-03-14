package VectorSolverServer;

import Ice.Current;
import utils.IntVectorHolder;

import java.util.Arrays;

/**
 * Created by gorkaolalde on 14/3/16.
 */
public class VectorManipulatorI extends utils._VectorManipulatorDisp {

    public void sort(int[] inVector, IntVectorHolder outVector, Current __current) {
        Arrays.parallelSort(inVector);
        outVector.value = inVector;
    }

    public void copyWithoutDuplicates(int[] inVector, IntVectorHolder outVector, Current __current) {
        outVector.value = Arrays.stream(inVector)
                .distinct()
                .toArray();
    }
}

module utils {
    sequence<int> IntVector;
    interface VectorManipulator {
        void sort(IntVector inVector, out IntVector outVector);
        void copyWithoutDuplicates(IntVector inVector, out IntVector outVector);
    };
};
package Server;

import Ice.Current;
import Ice.ObjectPrx;
import utils.CalculatorPrx;
import utils.CalculatorPrxHelper;

import java.util.ArrayList;

/**
 * Created by gorkaolalde on 14/3/16.
 */
public class CalculatorManagerI extends utils._CalculatorManagerDisp {
    ArrayList<CalculatorPrx> calculators = new ArrayList<>();
    final int MAX_CALCULATORS = 10;
    int calculatorIndex = 0;

    public CalculatorManagerI(Ice.ObjectAdapter adapter) {
        CalculatorPrx calcProxy;
        ObjectPrx objectProxy;
        CalculatorI calculator;
        for( int i = 0; i < MAX_CALCULATORS; i++ ) {
            calculator = new CalculatorI();
            objectProxy = adapter.addWithUUID(calculator);
            calcProxy = CalculatorPrxHelper.checkedCast(objectProxy);
            calculators.add(calcProxy);
        }
    }
    public CalculatorPrx getCalculatorInstance(Current __current) {
        CalculatorPrx retVal;
        retVal = calculators.get(calculatorIndex % MAX_CALCULATORS);
        calculatorIndex++;
        return retVal;
    }
}

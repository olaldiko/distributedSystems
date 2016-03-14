package CalculusCommon;

import CalculusCommon.CalculusWorker;


/**
 * Created by gorkaolalde on 11/2/16.
 */
public class LocalCalculusWorker implements CalculusWorker{

    @Override
    public int calcGCD(int num1, int num2) {
        int result = 0;
        while (num1 % num2 != 0) {
            result = num1 % num2;
            num2 = num1;
            num1 = result;
        }
        return result;
    }

    @Override
    public int calcLCM(int num1, int num2) {
        int result;
        result = num1 / calcGCD(num1, num2) * num2;
        return result;
    }

    @Override
    public int calcFactiorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}

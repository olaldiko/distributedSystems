package CalculusServer;

import Ice.Current;

/**
 * Created by gorkaolalde on 12/3/16.
 */
public class CalculatorI extends utils._CalculatorDisp{


    public int gcd(int num1, int num2, Current __current) {
        int result = 0;
        while (num1 % num2 != 0) {
            result = num1 % num2;
            num2 = num1;
            num1 = result;
        }
        return result;
    }

    public int lcm(int num1, int num2, Current __current) {
        int result;
        result = num1 / gcd(num1, num2) * num2;
        return result;
    }

    public int factorial(int num1, Current __current) {
        int result = 1;
        for (int i = 2; i <= num1; i++) {
            result *= i;
        }
        return result;
    }
}

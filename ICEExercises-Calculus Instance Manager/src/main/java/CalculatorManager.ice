module utils {
    interface Calculator {
        int gcd(int num1, int num2);
        int lcm(int num1, int num2);
        int factorial(int num1);
    };
    interface CalculatorManager {
        Calculator *getCalculatorInstance();
    };
};
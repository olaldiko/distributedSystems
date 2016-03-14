module utils {

    interface Calculator {
        int gcd(int num1, int num2);
        int lcd(int num1, int num2);
    };
    interface CalculatorManager {
        Calculator *getCalculatorInstance();
    };

};
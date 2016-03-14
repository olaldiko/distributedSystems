package CalculusClient;

import IceInternal.Ex;

import java.util.Scanner;

/**
 * Created by gorkaolalde on 12/3/16.
 */
public class CalculusClient {
    Ice.Communicator communicator = Ice.Util.initialize();
    Ice.ObjectAdapter adapter;
    utils.CalculatorPrx calculatorPrx;
    boolean status = false;
    Scanner kb = new Scanner(System.in);

    public void initClient() throws Exception {
        Ice.ObjectPrx proxy = communicator.stringToProxy("Calculator:default -p 10000");
        calculatorPrx = utils.CalculatorPrxHelper.checkedCast(proxy);
        if (calculatorPrx == null) {
            throw new Exception("Uknown proxy");
        }
        status = true;
    }

    public void runClient() {
        int option;
        do{
            option = showMenu();
            switch (option) {
                case 1:
                    promptGCD();
                    break;
                case 2:
                    promptLCM();
                    break;
                case 3:
                    promptFactorial();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        }while(option != 0 && status == true);

    }

    private int showMenu() {
        int option;
        do {
            System.out.println("********************************************");
            System.out.println("1. Calculate the GCD of two numbers");
            System.out.println("2. Calculate the LCM of two numbers");
            System.out.println("3. Calculate the Factorial of a number");
            System.out.println("0. Exit");
            System.out.println("********************************************");
            System.out.println("Choose an option:");
            option = kb.nextInt();
        } while(option < 0 || option > 3);
        return option;
    }

    private void promptGCD() {
        int num1, num2, result;
        System.out.println("Please, enter the first operand:");
        num1 = kb.nextInt();
        System.out.println("Please, enter the second operand:");
        num2 = kb.nextInt();
        result = calculatorPrx.gcd(num1, num2);
        System.out.println(num1 + " and " + num2 + " GCD result = " + result);
    }
    private void promptLCM() {
        int num1, num2, result;
        System.out.println("Please, enter the first operand:");
        num1 = kb.nextInt();
        System.out.println("Please, enter the second operand:");
        num2 = kb.nextInt();
        result = calculatorPrx.lcm(num1, num2);
        System.out.println(num1 + " and " + num2 + " LCM result = " + result);
    }

    private void promptFactorial() {
        int num1, result;
        System.out.println("Please, enter the operand:");
        num1 = kb.nextInt();
        result = calculatorPrx.factorial(num1);
        System.out.println(num1 + " factorial result = " + result);
    }

}

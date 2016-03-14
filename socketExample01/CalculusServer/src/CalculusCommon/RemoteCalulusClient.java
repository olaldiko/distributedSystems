package CalculusCommon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gorkaolalde on 15/2/16.
 */
public class RemoteCalulusClient implements CalculusWorker{

    private String address;
    private int port;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public RemoteCalulusClient(String address, int port) {
        this.address = address;
        this.port = port;
    }
    @Override
    public int calcGCD(int num1, int num2) {
        int result = 0;
        try {
            result = sendCalculation(Operation.GCD, num1, num2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int calcLCM(int num1, int num2) {
        int result = 0;
        try {
            result = sendCalculation(Operation.LCM, num1, num2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int calcFactiorial(int num) {
        int result = 0;
        try {
            result = sendCalculation(Operation.FACT, num);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void initConnection() throws IOException {
        socket = new Socket(address, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());
    }
    private void closeConnection() throws IOException{
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
        input = null;
        output = null;
    }
    private int getResult() throws IOException{
        String message;
        int result;
        Pattern pattern = Pattern.compile("\\$(\\w+),{1}(\\d+),?(\\d+)%");
        message = input.readLine();
        Matcher matcher = pattern.matcher(message);
        if(matcher.matches()) {
            System.out.println("Received result from "+matcher.group(1)+" result= "+matcher.group(2));
            result = Integer.parseInt(matcher.group(2));
        } else {
            throw new NumberFormatException();
        }
        return result;
    }

    private int sendCalculation(Operation operation, int num1, int num2) throws IOException {
        int result;
        initConnection();
        switch (operation) {
            case GCD:
                output.println("$GCD," + num1 + "," + num2 + "%");
                break;
            case LCM:
                output.println("$LCM," + num1 + "," + num2 + "%");
                break;
            case FACT:
                output.println("$FACT," + num1 + "," + num2 + "%");
                break;
        }
        output.flush();
        result = getResult();
        closeConnection();
        return result;
    }
    private int sendCalculation(Operation operation, int num1) throws IOException {
        int result;
        initConnection();
        switch (operation) {
            case FACT:
                output.println("$FACT," + num1 +"%");
                break;
        }
        output.flush();
        result = getResult();
        closeConnection();
        return result;
    }
}

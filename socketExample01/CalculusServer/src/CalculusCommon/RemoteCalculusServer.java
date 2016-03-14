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
public class RemoteCalculusServer implements Runnable{
    private CalculusWorker worker = new LocalCalculusWorker();
    private Pattern pattern = Pattern.compile("\\$(\\w+),{1}(\\d+),?(\\d+)%");
    private Socket client;
    private int result;

    public RemoteCalculusServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream());
            String inMessage = input.readLine();
            Matcher matcher = pattern.matcher(inMessage);
            if (matcher.matches()) {
                String type = matcher.group(1);
                int num1 = Integer.parseInt(matcher.group(2));
                switch (type) {
                    case "FACT":
                        result = worker.calcFactiorial(num1);
                        break;
                    case "GCD":
                        int num2 = Integer.parseInt(matcher.group(3));
                        result = worker.calcGCD(num1, num2);
                        break;
                    case "LCM":
                        num2 = Integer.parseInt(matcher.group(3));
                        result = worker.calcLCM(num1, num2);
                        break;
                }
                String outMessage = "$" + type + "," + result + "%";
                output.println(outMessage);
                output.flush();
                System.out.println("Client "+client.getInetAddress()+" calculation done: "+ type +" result: "+result);
            } else {
                System.out.println("Error reading message from client");
            }
        }catch (IOException e) {
            System.out.println("Error in client connection handling");
        } finally {
            try {
                client.shutdownInput();
                client.shutdownOutput();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

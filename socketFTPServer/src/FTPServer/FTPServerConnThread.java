package FTPServer;

import java.io.*;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by gorkaolalde on 29/2/16.
 */
public class FTPServerConnThread implements Runnable{

    Socket client;
    BufferedReader in;
    DataOutputStream rawOut;
    PrintWriter out;
    public FTPServerConnThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        String inputData, fileName;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            rawOut = new DataOutputStream(client.getOutputStream());
            out = new PrintWriter(client.getOutputStream());
            do {
                inputData = in.readLine();
                if (inputData.equals("$LIST%"))         sendFileListing(); 
                else if (inputData.contains("$GET")){
                    fileName = inputData.substring(5, inputData.length()-1);
                    sendRequestedFile(fileName);
                }
            } while (inputData != "");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendRequestedFile(String fileName) {
        Path file = FileSystems.getDefault().getPath(fileName);
        byte[] fileData;
        if (Files.exists(file)) {
            try {
                fileData = Files.readAllBytes(file);
                out.println("$OK,"+fileData.length+"%");
                out.flush();
                rawOut.write(fileData);
                rawOut.flush();
                out.println();
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            out.println("$NF%");
            out.flush();
        }
    }

    private void sendFileListing() {
        File dir = new File(".");
        File[] fileList = dir.listFiles();
        for(File file : fileList) {
            if(file.isFile()) {
                out.println(file.getName());
                out.flush();
            }
        }
        out.println("$END%");
        out.flush();
    }

}

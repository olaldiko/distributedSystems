package FTPClient;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by gorkaolalde on 29/2/16.
 */
public class FTPConnectionManager {

    String address;
    int port;
    boolean isConnected = false;
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out;

    public boolean initConnection(String address, int port) {
        isConnected = false;
        try {
            clientSocket = new Socket(address, port);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream());
            isConnected = true;
        } catch (UnknownHostException e) {
            System.out.println("Error: The server was not found!");
        } catch (IOException e) {
            System.out.println("Un Juanker ha irrumpido y no te puedes conectar");
        }
        return isConnected;
    }

    public ArrayList<String> listFiles() {
        ArrayList<String> files = new ArrayList<>();
        String receivedData;
        boolean listingEnd = false;
        out.println("$LIST%");
        out.flush();
        do {
            try {
                receivedData = in.readLine();
                if (receivedData.equals("$END%")) {
                    listingEnd = true;
                } else {
                    if(receivedData.equals("")) {
                        isConnected = false;
                    } else {
                        files.add(receivedData);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!listingEnd);
    return files;
    }

    public byte[] getFile(String filename) throws FileNotFoundException{
        byte[] fileData = null;
        int size;
        String inData;
        boolean endReading = false;
        out.println("$GET,"+filename+"%");
        out.flush();
        try {
            inData = in.readLine();
            if(inData.contains("$OK,")) {
                size = Integer.parseInt(inData.substring(4,inData.length()-1));
                fileData = new byte[size];
                for (int i = 0; i < size; i++) {
                    fileData[i] = (byte)in.read();
                }
                endReading = true;
            } else {
                throw new FileNotFoundException();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (endReading == true) {
            return fileData;
        } else {
            return null;
        }
    }

    public void writeFile(String fileName, byte[] fileData) throws IOException {
        FileOutputStream outputFile = new FileOutputStream(fileName+"copy");
        outputFile.write(fileData);
        outputFile.close();
    }

    public void closeConnection() {
        try {
            clientSocket.shutdownInput();
            clientSocket.shutdownOutput();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isConneted() {
        return isConnected;
    }
}




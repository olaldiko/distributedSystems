package FTPClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gorkaolalde on 29/2/16.
 */
public class TextInterface {
    FTPConnectionManager manager;
    String address;
    int port;
    ArrayList<String> listedFiles = new ArrayList<>();
    Scanner kb = new Scanner(System.in);
    public void showMenu() {
        System.out.println("1. Request file from server");
        System.out.println("2. Exit");

    }

    public void showConnectionDialog() {
        System.out.println("Please, enter the server address to connect:");
        address = kb.nextLine();
        System.out.println("Please, enter the server port:");
        port = kb.nextInt();
    }

    public void showListedFiles() {

        if(manager.isConnected) {
             listedFiles = manager.listFiles();
            for (int i = 0; i < listedFiles.size(); i++) {
                System.out.println(i+". "+listedFiles.get(i));
            }
        }
    }

    public void getFile() {
        System.out.println("Please, choose a file:");
        int fileIndex;
        showListedFiles();
        fileIndex = kb.nextInt();
        byte[] fileData;
        if(fileIndex >= 0 && fileIndex < listedFiles.size()) {
            try {
                fileData = manager.getFile(listedFiles.get(fileIndex));
                if (fileData != null) {
                    manager.writeFile(listedFiles.get(fileIndex), fileData);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error opening destination file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Error receiving the file");
                e.printStackTrace();
            }
        }
    }

    public void exec() {
        int option;
        boolean connOk = false;
        boolean exit = false;
        showConnectionDialog();
        manager = new FTPConnectionManager();
        connOk = manager.initConnection(address, port);
        if (connOk) {
            while(!exit) {
                showMenu();
                option = kb.nextInt();
                switch (option) {
                    case 1:
                        getFile();
                        break;
                    case 2:
                        exit = true;
                        manager.closeConnection();
                        break;
                }
            }
        } else {
            System.out.println("Error opening connection");
        }
    }
}

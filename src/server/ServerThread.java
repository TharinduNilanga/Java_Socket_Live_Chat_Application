package server;

import client.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {

    private final Socket socket;
    private final ArrayList<ServerThread> threadArrayList;
    private ObjectOutputStream objectOutputStream;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadArrayList = threads;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                Message msg = (Message) objectInputStream.readObject();
                if (msg.getMessage().equals("exit")) {
                    break;
                }
                System.out.println("Server received " + msg.getMessage());
                printToAllClients(msg.getName(), msg.getMessage(), msg.getEmoji(), msg.getImage());


            }
        } catch (Exception e) {
            System.out.println("Error occurred in thread" + e.getStackTrace());
        }
    }

    private void printToAllClients(String name, String outputString, String emoji, String image) throws IOException {
        for (ServerThread sT : threadArrayList) {
            try {
                System.out.println("Server side name = " + name);
                System.out.println("Server side msg = " + outputString);
                System.out.println("Server side emoji = " + emoji);
                if (image != null) {
                    sT.objectOutputStream.writeObject(new Message(name, outputString, emoji, image));
                    sT.objectOutputStream.flush();
                } else {
                    sT.objectOutputStream.writeObject(new Message(name, outputString, emoji, null));
                    sT.objectOutputStream.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

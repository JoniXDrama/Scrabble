package model.network;
import model.concrete.GameState;
import model.concrete.HostPlayer;
import model.concrete.Player;
import view.GamePage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// Server class
public class GameServer {
    int port;
    private static final int MAX_CLIENTS = 3;
    public static List<GameClientHandler> clients = new ArrayList<>();
    public HostPlayer hostPlayer;
    GameState gameState;

    public GameServer(int port,String name) {
        this.port = port;
        gameState = GameState.getGM();
        hostPlayer = new HostPlayer(name);
    }




    public static List<GameClientHandler> getClients() {
        return clients;
    }

    public  void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server started. Listening on port: "+port);


            hostPlayer.stop=false;
            while (!hostPlayer.stop) {
                Socket clientSocket = serverSocket.accept();

                if (clients.size() < MAX_CLIENTS) {
                    Player p = new Player();
                    GameClientHandler gch = new GameClientHandler(clientSocket, p);
                    clients.add(gch);
                    gch.start();
                    gameState.addPlayer(p);

                }
                else {
                    System.out.println("too much clients");
                    clientSocket.close();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastToClients(String message) {
        synchronized (clients) {
            for (GameClientHandler client : clients) {
                client.sendMessage(message);
            }
        }
    }

    public static void removeClient(GameClientHandler gameClientHandler) {
        synchronized (clients) {
            clients.remove(gameClientHandler);
        }
    }
}



package sr3.test;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer {

    private int port;
    private ClientHandler ch;
    private volatile boolean stop;
    private ServerSocket server;

    public MyServer(int port, ClientHandler ch) {
        this.port = port;
        this.ch = ch;

    }

    public void start()
    {
        stop = false;
        new Thread(()-> {
            try {
                startServer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    private void startServer() throws Exception
    {
        server = new ServerSocket(port);
        server.setSoTimeout(1000);
        while(!stop) {

            try {
                Socket aClient = server.accept();
                try {
                    ch.handleClient(aClient.getInputStream(), aClient.getOutputStream());
                    ch.close();
                    aClient.getInputStream().close();
                    aClient.getOutputStream().close();
                    aClient.close();


                } catch (IOException e) {
                    e.getMessage();
                 ;}
            } catch (SocketTimeoutException e) {
                e.getMessage();

            }
        }
        server.close();
    }

    public void close()
    {
        stop = true;
    }

}

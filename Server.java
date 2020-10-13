/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecdh.server;
import java.net.ServerSocket;
import java.util.Set;


/**
 *
 * @author thanj
 */
public class Server {
    static final int port = 8080;
    private ServerSocket serverSocket;
    private Set<ServerThread> serverThreads = new HashSet<ServerThread>();
    private String Gx = null, Gy = null;
    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
        server.serverSocket = new ServerSocket(port);
        System.out.println("[Passive Eve]: eavesdropping on all communication");
        while(true)
        {
            ServerThread serverThread = new ServerThread(server.serverSocket.accept(), server);
            server.serverThreads.add(serverThread);
            serverThread.start();
        }
    }
    void forwardMessage(String message, ServerThread originatingServerThread)
    {
        serverThreads.forEach(serverThread->{
            if(serverThread != originatingServerThread)serverThread.forwardMessage(message);
        });
    }
    
    
    public String getGx()
    {
        return Gx;
    }
    public String getGy()
    {
        return Gy;
    }
    public Set<ServerThread> getServerThreads()
    {
        return serverThreads;
    }
    public void setGx(String gx)
    {
        Gx = gx;
    }
    public void setGy(String gy)
    {
        Gy = gy;
        
    }
}
    
    


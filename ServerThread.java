/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecdh.server;
import java.io.BufferedReader;

/**
 *
 * @author thanj
 */
public class ServerThread extends Thread {
private Server server;
private BufferedReader bufferedReader;
private PrintWriter printWriter;
public ServerThread(Socket socket, Server server) throws IOException{
    this.server = server;
    this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.printWriter = new PrintWriter(socket.getOutputStream(), true);
}
    void forwardMessage(String message)
    {
        printWriter.println(message);
    }
}

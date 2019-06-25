package ru.job4j.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

@Slf4j
public class Client {
    private Socket socket;

    public Client(int port) throws IOException {
        this.socket = new Socket(InetAddress.getLocalHost(), port);
    }

    public void connectToServer() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            String msgFromServer;
            do {
                log.info("Введите сообщение на сервер : ");
                String inputUser = scanner.nextLine();
                writer.write(inputUser);
                writer.newLine();
                writer.flush();
                msgFromServer = reader.readLine();
                log.info("Сообщение с сервера \"{}\"", msgFromServer);
            } while (msgFromServer != null && !msgFromServer.equals("Goodbye"));
        }
    }
}

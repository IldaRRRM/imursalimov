package ru.job4j.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class TestServer {

    private final int port;

    public TestServer(int port) {
        this.port = port;
    }

    public void initServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("Сервер стартует");
            String msgFromClient;
            log.info("Жду подключения");
            Socket socket = serverSocket.accept();
            log.info("Подключение состоялось");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                String answer;
                do {
                    log.info("Жду сообщения от клиента");
                    msgFromClient = reader.readLine();
                    log.info("Сообщение от клиента:  \"{}\"", msgFromClient);
                    answer = createAnswer(msgFromClient);
                    sendAnswer(writer, answer);
                } while (!"Goodbye".equals(answer));
            }
        }
    }

    private boolean checkExit(String msg) {
        return "EXIT".equals(msg.toUpperCase().trim());
    }

    private String createAnswer(String msg) {
        if (checkHello(msg)) {
            return "Hello, I'm the Oracle!";
        } else if (checkHowAreYou(msg)) {
            return "Everything is fine, thx!";
        } else if (checkExit(msg)) {
            return "Goodbye";
        }
        return "Congratz, you are speaking with oracle";
    }

    private void sendAnswer(BufferedWriter writer, String answer) throws IOException {
        writer.write(answer);
        writer.newLine();
        writer.flush();
    }

    private boolean checkHello(String msg) {
        String hiRegex = "^ПРИ*.[^. ?!]";
        String helloRegex = "^ЗДРА*.[^. ?!]";
        Pattern pattern = Pattern.compile(hiRegex + "|" + helloRegex);
        Matcher matcher = pattern.matcher(msg.toUpperCase());
        return matcher.find();
    }

    private boolean checkHowAreYou(String msg) {
        String how = "^КАК*.[^. ?!]";
        Pattern pattern = Pattern.compile(how);
        Matcher matcher = pattern.matcher(msg.toUpperCase());
        return matcher.find();
    }
}





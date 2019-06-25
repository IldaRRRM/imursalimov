package ru.job4j.socket;

import java.io.IOException;

public class OracleTest {
    public static void main(String[] args) throws IOException {
        TestServer server = new TestServer(7070);
        new Thread(() -> {
            try {
                Client client = new Client(7070);
                Thread.sleep(2000);
                client.connectToServer();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        server.initServer();
    }
}

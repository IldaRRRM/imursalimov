package ru.job4j.threads.pingpong;

import org.junit.Test;


public class PingPongTest {

    @Test
    public void startSimulationTest() {
        PingPong.launch(PingPong.class);
    }
}
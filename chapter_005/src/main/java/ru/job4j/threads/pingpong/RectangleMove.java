package ru.job4j.threads.pingpong;

import javafx.scene.shape.Rectangle;


public class RectangleMove implements Runnable {

    private final Rectangle rect;
    private final int xLimit;
    private final int yLimit;


    public RectangleMove(Rectangle rect, int xLimit, int yLimit) {
        this.rect = rect;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            rightMove();
            leftMove();
        }
    }

    private void rightMove() {
        while (rect.getX() != xLimit - 10) {
            this.rect.setX(this.rect.getX() + 1);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    private void leftMove() {
        while (rect.getX() != 0) {
            this.rect.setX(this.rect.getX() - 1);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}



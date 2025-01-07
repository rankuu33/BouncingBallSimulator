package bouncingBall;

import java.awt.*;
import java.util.List;

public class Ball {
    private static final double GRAVITY = 1;
    private static final double DAMPING = 1;
    public int BALL_DIAMETER = 30;

    private final int x;
    private int y;
    private double velocityY;
    private final Color color;


    public Ball(int startX, int startY, Color color, int BALL_DIAMETER) {
        this.x = startX;
        this.y = startY;
        this.color = color;
        this.velocityY = 0;
        this.BALL_DIAMETER = BALL_DIAMETER;
    }

    public void updatePosition(int panelHeight) {
        velocityY += GRAVITY;
        y += (int) velocityY;

        if (y >= panelHeight - BALL_DIAMETER) {
            y = panelHeight - BALL_DIAMETER;
            velocityY *= -DAMPING;
        } else if (y <= 0) {
            y = 0;
            velocityY *= -DAMPING;
        }
    }

    public void otherBalls(List<Ball> otherBalls){}

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, BALL_DIAMETER, BALL_DIAMETER);
    }

}

package bouncingBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BouncingBall extends JPanel implements ActionListener {

    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 700;
    private final List<Ball> balls;

    public BouncingBall() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.BLACK);
        Ball whiteBall = new Ball((PANEL_WIDTH  - 190 )  , PANEL_HEIGHT / 4, Color.white, 35);
        balls = new ArrayList<>();
        balls.add(whiteBall);
        balls.add(new Ball((PANEL_WIDTH + 40) / 2, PANEL_HEIGHT / 5, Color.RED, 45));
        balls.add(new Ball((PANEL_WIDTH - 40) / 3, PANEL_HEIGHT / 2, Color.BLUE, 35));
        balls.add(new Ball((PANEL_WIDTH -40) / 4, PANEL_HEIGHT / 2, Color.yellow, 20));
        balls.add(new Ball((PANEL_WIDTH - 10)/ 7, PANEL_HEIGHT / 2, Color.GREEN, 60));
        for(Ball ball:balls){
            ball.otherBalls(this.balls);
        }

        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ball ball : balls) {
            ball.updatePosition(PANEL_HEIGHT);
        }
        repaint();
    }
}

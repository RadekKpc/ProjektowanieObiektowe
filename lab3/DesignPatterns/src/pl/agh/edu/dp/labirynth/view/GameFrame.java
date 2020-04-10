package pl.agh.edu.dp.labirynth.view;

import pl.agh.edu.dp.gameplay.MazeGame;
import pl.agh.edu.dp.gameplay.Player;
import pl.agh.edu.dp.labirynth.mazes.Maze;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements ActionListener,KeyListener {

    JPanel panel;
    public GameFrame(Maze maze, Player player) {
         super("Maze");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(600,600);
         setLocationRelativeTo(null);

         panel = new GamePanel(maze,player,this);
         add(panel);

         addKeyListener(this);
         setVisible(true);
    }

    public void paint(){
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.panel.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();

        if (i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) {
            MazeGame.getInstance().movePlayerLeft();
        }

        if (i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) {
            MazeGame.getInstance().movePlayerRgiht();
        }
        if (i == KeyEvent.VK_W || i == KeyEvent.VK_UP) {
            MazeGame.getInstance().movePlayerAhead();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
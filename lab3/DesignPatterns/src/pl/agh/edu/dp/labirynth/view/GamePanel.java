package pl.agh.edu.dp.labirynth.view;

import pl.agh.edu.dp.gameplay.MazeGame;
import pl.agh.edu.dp.gameplay.Player;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.MazeFactory;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.mazes.Maze;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    Maze maze;
    Player player;
    int WIDTH;
    int HEIGHT;
    int SCALE = 50;
    int start_x;
    int stary_y;
    int BOLD = 6;
    GameFrame gameFrame;
    public GamePanel(Maze maze,Player player,GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.player = player;
        this.maze = maze;
        this.HEIGHT = gameFrame.getHeight();
        this.WIDTH = gameFrame.getWidth();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setSize(gameFrame.getWidth(),gameFrame.getHeight()-38);
        this.setLocation(0, 0);
        start_x = 0;
        stary_y = 30;

        int length = maze.getRooms().size();
        List<Integer> roomsColors = new ArrayList<>(length);
        drawMazeBfs(g,start_x,stary_y,maze.getStartRooom(),roomsColors);

        g.setColor(Color.BLACK);
        g.drawString(MazeGame.getInstance().getCommunicat(),20,20);
    }

    public void  drawMazeBfs(Graphics g,int x,int y,Room r,List<Integer> roomsColors){
        if(roomsColors.contains(r.getRoomNumber()))return;
        drawRoom(x,y,g,r);
        roomsColors.add(r.getRoomNumber());
        for(Direction d: Direction.values()){
            for (Room r2 : maze.getRooms()) {
                if (r.getSide(d) == r2.getSide(Direction.getOpposite(d))) {
                    switch (d) {
                        case West:
                            drawMazeBfs(g, x - SCALE,y, r2,roomsColors);
                            break;
                        case East:
                            drawMazeBfs(g, x + SCALE,y,  r2,roomsColors);
                            break;
                        case North:
                            drawMazeBfs(g, x ,y - SCALE,  r2,roomsColors);
                            break;
                        case South:
                            drawMazeBfs(g, x ,y  + SCALE,  r2,roomsColors);
                            break;
                    }
                }
            }
        }
    }

    public void drawRoom(int weight,int height,Graphics g,Room room){

        g.setColor(Color.WHITE);
        if(maze.getStartRooom() == room)
            g.setColor(Color.BLUE);
        if(maze.getEndRoom() == room)
            g.setColor(Color.GREEN);

        g.fillRect(weight,height,SCALE,SCALE);

        for(Direction d: Direction.values()){

            if(room.getSide(d) instanceof Wall){
                g.setColor(Color.black);
            }
            else if(room.getSide(d) instanceof Door){
                g.setColor(Color.WHITE);
            }

            switch (d){
                case West:
                    g.fillRect(weight ,height+BOLD , BOLD , SCALE -BOLD);
                    break;
                case East:
                    g.fillRect(weight + SCALE -BOLD,height + BOLD, BOLD , SCALE - BOLD );
                    break;
                case North:
                    g.fillRect(weight,height, SCALE , BOLD);
                    break;
                case South:
                    g.fillRect(weight  ,height + SCALE - BOLD, SCALE ,  BOLD);
                    break;

            }

            if(player.getRoom() == room){
                g.setColor(Color.RED);
                switch (player.getDirection()){
                    case West:
                        int[] tabx = {weight + 2*BOLD,weight + SCALE - 2*BOLD,weight + SCALE - 3*BOLD, weight + SCALE - 2*BOLD};
                        int[] taby = {height + SCALE/2,height + 2*BOLD,height + SCALE/2,height + SCALE - 2*BOLD};
                        g.fillPolygon(tabx,taby,4);
                        break;
                    case East:
                        int[] tabx2 = {weight + SCALE - 2*BOLD,weight + 2*BOLD,weight +  3*BOLD, weight + 2*BOLD};
                        int[] taby2 = {height + SCALE/2,height + 2*BOLD,height + SCALE/2,height + SCALE - 2*BOLD};
                        g.fillPolygon(tabx2,taby2,4);
                        break;
                    case North:
                        int[] taby3 = {height + 2*BOLD,height + SCALE - 2*BOLD,height + SCALE - 3*BOLD, height + SCALE - 2*BOLD};
                        int[] tabx3 = {weight + SCALE/2,weight + 2*BOLD,weight + SCALE/2,weight + SCALE - 2*BOLD};
                        g.fillPolygon(tabx3,taby3,4);
                        break;
                    case South:
                        int[] taby4 = {height + SCALE - 2*BOLD,height + 2*BOLD,height +  3*BOLD, height + 2*BOLD};
                        int[] tabx4 = {weight + SCALE/2,weight + 2*BOLD,weight + SCALE/2,weight + SCALE - 2*BOLD};
                        g.fillPolygon(tabx4,taby4,4);
                        break;

                }
            }
        }

    }
}

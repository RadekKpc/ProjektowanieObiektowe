package pl.agh.edu.dp.gameplay;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MazeBuilder;
import pl.agh.edu.dp.labirynth.MazeFactory;
import pl.agh.edu.dp.labirynth.mazes.Maze;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.view.GameFrame;

import java.util.ArrayList;
import java.util.List;

public class MazeGame {

    private static MazeGame instance;
    private Player player;
    private String communicat = "";

    public String getCommunicat() {
        return communicat;
    }

    private MazeGame(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static MazeGame getInstance(){
        if(instance == null){
            instance = new MazeGame();
        }
        return instance;
    }

    public void createMaze(MazeBuilder mazeBuilder, MazeFactory factory){

        List<Room> rooms = new ArrayList<>(100);

        for(int i =0;i<7;i++){
            for(int j=0;j<10;j++){
                Room r = factory.createRoom(10*i+j);
                mazeBuilder.addRoom(r);
                rooms.add(r);
            }
        }

        for(int i =0;i<6;i++){
            for(int j=0;j<10;j++){
                mazeBuilder.setWallBetweenRooms(Direction.East,rooms.get(10*i + j),rooms.get(10*(i+1)+j));
            }
        }

        for(int i =0;i<7;i++){
            for(int j=0;j<9;j++){
                mazeBuilder.setWallBetweenRooms(Direction.South,rooms.get(10*i + j),rooms.get(10*(i)+j+1));
            }
        }

        mazeBuilder.createStartRoom(rooms.get(0));
        mazeBuilder.createEndRoom(rooms.get(69));

        mazeBuilder.setDoorBetweenRooms(rooms.get(0),rooms.get(1));
        mazeBuilder.setDoorBetweenRooms(rooms.get(1),rooms.get(2));
        mazeBuilder.setDoorBetweenRooms(rooms.get(2),rooms.get(3));
        mazeBuilder.setDoorBetweenRooms(rooms.get(3),rooms.get(4));
        mazeBuilder.setDoorBetweenRooms(rooms.get(4),rooms.get(5));
        mazeBuilder.setDoorBetweenRooms(rooms.get(5),rooms.get(6));
        mazeBuilder.setDoorBetweenRooms(rooms.get(6),rooms.get(7));
        mazeBuilder.setDoorBetweenRooms(rooms.get(7),rooms.get(8));
        mazeBuilder.setDoorBetweenRooms(rooms.get(8),rooms.get(9));
        mazeBuilder.setDoorBetweenRooms(rooms.get(0),rooms.get(10));
        mazeBuilder.setDoorBetweenRooms(rooms.get(10),rooms.get(20));
        mazeBuilder.setDoorBetweenRooms(rooms.get(20),rooms.get(30));
        mazeBuilder.setDoorBetweenRooms(rooms.get(30),rooms.get(31));
        mazeBuilder.setDoorBetweenRooms(rooms.get(31),rooms.get(32));
        mazeBuilder.setDoorBetweenRooms(rooms.get(32),rooms.get(42));
        mazeBuilder.setDoorBetweenRooms(rooms.get(42),rooms.get(52));

        mazeBuilder.setDoorBetweenRooms(rooms.get(52),rooms.get(62));
        mazeBuilder.setDoorBetweenRooms(rooms.get(62),rooms.get(61));
        mazeBuilder.setDoorBetweenRooms(rooms.get(61),rooms.get(60));
        mazeBuilder.setDoorBetweenRooms(rooms.get(60),rooms.get(50));
        mazeBuilder.setDoorBetweenRooms(rooms.get(50),rooms.get(40));
        mazeBuilder.setDoorBetweenRooms(rooms.get(40),rooms.get(41));
        mazeBuilder.setDoorBetweenRooms(rooms.get(41),rooms.get(51));
        mazeBuilder.setDoorBetweenRooms(rooms.get(62),rooms.get(63));
        mazeBuilder.setDoorBetweenRooms(rooms.get(63),rooms.get(64));
        mazeBuilder.setDoorBetweenRooms(rooms.get(64),rooms.get(65));
        mazeBuilder.setDoorBetweenRooms(rooms.get(65),rooms.get(66));
        mazeBuilder.setDoorBetweenRooms(rooms.get(20),rooms.get(30));
        mazeBuilder.setDoorBetweenRooms(rooms.get(30),rooms.get(31));
        mazeBuilder.setDoorBetweenRooms(rooms.get(31),rooms.get(32));
        mazeBuilder.setDoorBetweenRooms(rooms.get(32),rooms.get(42));
        mazeBuilder.setDoorBetweenRooms(rooms.get(42),rooms.get(52));
        mazeBuilder.setDoorBetweenRooms(rooms.get(66),rooms.get(67));
        mazeBuilder.setDoorBetweenRooms(rooms.get(67),rooms.get(68));
        mazeBuilder.setDoorBetweenRooms(rooms.get(68),rooms.get(58));
        mazeBuilder.setDoorBetweenRooms(rooms.get(58),rooms.get(48));
        mazeBuilder.setDoorBetweenRooms(rooms.get(48),rooms.get(38));
        mazeBuilder.setDoorBetweenRooms(rooms.get(38),rooms.get(28));
        mazeBuilder.setDoorBetweenRooms(rooms.get(28),rooms.get(27));
        mazeBuilder.setDoorBetweenRooms(rooms.get(27),rooms.get(26));
        mazeBuilder.setDoorBetweenRooms(rooms.get(26),rooms.get(25));
        mazeBuilder.setDoorBetweenRooms(rooms.get(25),rooms.get(24));
        mazeBuilder.setDoorBetweenRooms(rooms.get(24),rooms.get(23));
        mazeBuilder.setDoorBetweenRooms(rooms.get(66),rooms.get(67));
        mazeBuilder.setDoorBetweenRooms(rooms.get(69),rooms.get(59));
        mazeBuilder.setDoorBetweenRooms(rooms.get(59),rooms.get(49));
        mazeBuilder.setDoorBetweenRooms(rooms.get(49),rooms.get(39));
        mazeBuilder.setDoorBetweenRooms(rooms.get(39),rooms.get(29));
        mazeBuilder.setDoorBetweenRooms(rooms.get(29),rooms.get(19));
        mazeBuilder.setDoorBetweenRooms(rooms.get(19),rooms.get(18));
        mazeBuilder.setDoorBetweenRooms(rooms.get(18),rooms.get(17));
        mazeBuilder.setDoorBetweenRooms(rooms.get(17),rooms.get(16));
        mazeBuilder.setDoorBetweenRooms(rooms.get(16),rooms.get(15));
        mazeBuilder.setDoorBetweenRooms(rooms.get(15),rooms.get(14));
        mazeBuilder.setDoorBetweenRooms(rooms.get(14),rooms.get(4));
        mazeBuilder.setDoorBetweenRooms(rooms.get(14),rooms.get(13));
        mazeBuilder.setDoorBetweenRooms(rooms.get(13),rooms.get(12));
        mazeBuilder.setDoorBetweenRooms(rooms.get(12),rooms.get(22));
        mazeBuilder.setDoorBetweenRooms(rooms.get(22),rooms.get(21));
        mazeBuilder.setDoorBetweenRooms(rooms.get(21),rooms.get(11));
        mazeBuilder.setDoorBetweenRooms(rooms.get(52),rooms.get(53));
        mazeBuilder.setDoorBetweenRooms(rooms.get(53),rooms.get(54));
        mazeBuilder.setDoorBetweenRooms(rooms.get(54),rooms.get(55));
        mazeBuilder.setDoorBetweenRooms(rooms.get(55),rooms.get(56));
        mazeBuilder.setDoorBetweenRooms(rooms.get(56),rooms.get(57));
        mazeBuilder.setDoorBetweenRooms(rooms.get(57),rooms.get(47));
        mazeBuilder.setDoorBetweenRooms(rooms.get(47),rooms.get(37));
        mazeBuilder.setDoorBetweenRooms(rooms.get(37),rooms.get(36));
        mazeBuilder.setDoorBetweenRooms(rooms.get(36),rooms.get(35));
        mazeBuilder.setDoorBetweenRooms(rooms.get(35),rooms.get(34));
        mazeBuilder.setDoorBetweenRooms(rooms.get(34),rooms.get(33));
        mazeBuilder.setDoorBetweenRooms(rooms.get(33),rooms.get(43));
        mazeBuilder.setDoorBetweenRooms(rooms.get(43),rooms.get(44));
        mazeBuilder.setDoorBetweenRooms(rooms.get(44),rooms.get(45));
        mazeBuilder.setDoorBetweenRooms(rooms.get(45),rooms.get(46));

    }

    public void startGame(Maze maze){

        player = new Player(Direction.South,maze.getStartRooom(),20);
        GameFrame frame = new GameFrame(maze,player);
        boolean exit = true;
        while(exit){

            try {
                Thread.sleep(50);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }

            frame.paint();
            if(player.getHealth() <= 0){
                communicat =  "Zginales z powodu obrazen";
                break;
            }
            if(player.getRoom() == maze.getEndRoom()){
                communicat =  "Jests na mecie gratulacje!";

            }
            if(player.getRoom() == maze.getStartRooom()){
                communicat =  "Jestes na starcie";

            }

        }

    }

    public void movePlayerLeft(){
        player.moveLeft();
    }
    public void movePlayerRgiht(){
        player.moveRigth();
    }
    public void movePlayerAhead(){
        player.goAhead();
    }
    public void changePlayerRoom(Room r1,Room r2){
        if(player.getRoom() == r1) {
            player.setRoom(r2);
        }
        else {
            player.setRoom(r1);
        }
    }
    public void changePlayerHealth(int i){
        player.setHealth(player.getHealth() + i);
        System.out.println(player.getHealth());
    }

    public void setCommunicat(String s){
        communicat = s;
    }

}

package pl.agh.edu.dp.labirynth.concreteMazeFacotories;

import pl.agh.edu.dp.labirynth.MazeFactory;
import pl.agh.edu.dp.labirynth.doors.BombedDoor;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.BombedRoom;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.BombedWall;
import pl.agh.edu.dp.labirynth.walls.Wall;

public final class BombedMazeFactory implements MazeFactory {

    private static BombedMazeFactory instance;

    private BombedMazeFactory(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static BombedMazeFactory getInstance(){
        if (instance == null){
            instance = new BombedMazeFactory();
        }
        return  instance;
    }

    @Override
    public Room createRoom(int n) {
        return new BombedRoom(n);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return new BombedDoor(r1,r2);
    }
}

package pl.agh.edu.dp.labirynth.concreteMazeFacotories;

import pl.agh.edu.dp.labirynth.MazeFactory;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.doors.EnchantedDoor;
import pl.agh.edu.dp.labirynth.rooms.EnchantedRoom;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.EnchantedWall;
import pl.agh.edu.dp.labirynth.walls.Wall;

public final class EnchantedMazeFactory implements MazeFactory {

    private static EnchantedMazeFactory instance;

    // slow initialization
    private EnchantedMazeFactory(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static EnchantedMazeFactory getInstance(){
        if (instance == null){
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }


    @Override
    public Room createRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }

    @Override
    public Door createDoor(Room r1,Room r2) {
        return new EnchantedDoor(r1,r2);
    }


}

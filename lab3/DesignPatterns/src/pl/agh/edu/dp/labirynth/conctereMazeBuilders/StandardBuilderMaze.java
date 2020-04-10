package pl.agh.edu.dp.labirynth.conctereMazeBuilders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MazeBuilder;
import pl.agh.edu.dp.labirynth.MazeFactory;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.mazes.Maze;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class StandardBuilderMaze implements MazeBuilder {

    private Maze currentMaze = new Maze();
    public Maze getResult(){
        return this.currentMaze;
    }
    private MazeFactory factory;

    public StandardBuilderMaze(MazeFactory factory){
        this.factory = factory;
    }

    @Override
    public void reset(){
        this.currentMaze = new Maze();
    }

    @Override
    public void addRoom(Room room) {
        room.setSide(Direction.North, factory.createWall());
        room.setSide(Direction.East, factory.createWall());
        room.setSide(Direction.South, factory.createWall());
        room.setSide(Direction.West, factory.createWall());
        this.currentMaze.addRoom(room);
    }

    @Override
    public void setDoorBetweenRooms(Room room1,Room room2){
        Door door = factory.createDoor(room1,room2);
        Direction dir = commonWall(room1,room2);
        if(dir == null){
            System.out.println("Pomieszczenia nie mają wspólnej sciany");
            return;
        }
        room1.setSide(dir,door);
        room2.setSide(Direction.getOpposite(dir),door);
    }

    @Override
    public void setWallBetweenRooms(Direction firstRoomDirection, Room room1, Room room2) {
        if(room1.getSide(firstRoomDirection) == null){
            room1.setSide(firstRoomDirection,factory.createWall());
        }

        room2.setSide(Direction.getOpposite(firstRoomDirection),room1.getSide(firstRoomDirection));
    }

    @Override
    public void createStartRoom(Room room) {
        currentMaze.setStartRooom(room);
    }

    @Override
    public void createEndRoom(Room room) {
        currentMaze.setEndRoom(room);
    }

    private Direction commonWall(Room room1,Room room2){
        for (Direction dir : Direction.values()){
            if(room1.getSide(dir) == room2.getSide(Direction.getOpposite(dir))){
                if(room1.getSide(dir) != null){
                    return dir;
                }
            }
        }
        return null;
    }
}

package pl.agh.edu.dp.labirynth.conctereMazeBuilders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MazeBuilder;
import pl.agh.edu.dp.labirynth.mazes.CountingMaze;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class CountingMazeBuilder implements MazeBuilder {

    CountingMaze countingMaze = new CountingMaze();

    @Override
    public void reset() {
        this.countingMaze = new CountingMaze();
    }

    public CountingMaze getResult(){
        return this.countingMaze;
    }

    @Override
    public void addRoom(Room room) {
        this.countingMaze.setRooms(this.countingMaze.getRooms() + 1);
        this.countingMaze.setWalls(this.countingMaze.getWalls() + 4);
    }

    @Override
    public void setDoorBetweenRooms(Room room1, Room room2) {
        this.countingMaze.setDoors(this.countingMaze.getDoors() +1);
        this.countingMaze.setWalls(this.countingMaze.getWalls() - 1);
    }

    @Override
    public void setWallBetweenRooms(Direction firstRoomDirection, Room room1, Room room2) {
        this.countingMaze.setWalls(this.countingMaze.getWalls() - 1);
    }

    @Override
    public void createStartRoom(Room room) {

    }

    @Override
    public void createEndRoom(Room room) {

    }


}

package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.rooms.Room;

public interface MazeBuilder {

    void reset();
    void addRoom(Room room);
    void setDoorBetweenRooms(Room room1,Room room2);
    void setWallBetweenRooms(Direction firstRoomDirection,Room room1,Room room2);
    void createStartRoom(Room room);
    void createEndRoom(Room room);
}

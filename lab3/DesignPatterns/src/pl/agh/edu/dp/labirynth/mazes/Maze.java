package pl.agh.edu.dp.labirynth.mazes;

import pl.agh.edu.dp.labirynth.rooms.Room;

import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;

    public Vector<Room> getRooms() {
        return rooms;
    }

    public Room getStartRooom() {
        return startRooom;
    }

    public void setStartRooom(Room startRooom) {
        this.startRooom = startRooom;
    }

    public Room getEndRoom() {
        return endRoom;
    }

    public void setEndRoom(Room endRoom) {
        this.endRoom = endRoom;
    }

    private Room startRooom;
    private Room endRoom;

    public Maze() {
        this.rooms = new Vector<Room>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }
}

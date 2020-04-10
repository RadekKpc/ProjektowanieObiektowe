package pl.agh.edu.dp.labirynth.mazes;

public class CountingMaze {

    private  int walls;
    private int rooms;
    private int doors;

    public CountingMaze(){
        this.doors = 0;
        this.walls = 0;
        this.rooms = 0;
    }
    public int getWalls() {
        return walls;
    }

    public void setWalls(int walls) {
        this.walls = walls;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }


}

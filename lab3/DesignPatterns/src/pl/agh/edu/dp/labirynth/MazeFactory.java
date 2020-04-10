package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.mazes.Maze;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public interface MazeFactory {

    Room createRoom(int n);
    Wall createWall();
    Door createDoor(Room r1, Room r2);

}

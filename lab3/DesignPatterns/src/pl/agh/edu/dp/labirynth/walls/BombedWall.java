package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.gameplay.MazeGame;

public class BombedWall extends Wall {

    @Override
    public void Enter(){
        MazeGame.getInstance().setCommunicat("Wybuchowa sciana");

    }
}

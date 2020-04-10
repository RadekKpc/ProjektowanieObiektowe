package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.gameplay.MazeGame;
import pl.agh.edu.dp.labirynth.mazes.Maze;

public class EnchantedWall extends Wall {

    private int wallStamina = 2;

    @Override
    public void Enter(){
        wallStamina--;
        MazeGame.getInstance().setCommunicat("Uderzyles w magiczna sciane, zaczynasz krwawić");

        if(wallStamina < 0){
            MazeGame.getInstance().setCommunicat("Orzymano obrazenia");
            MazeGame.getInstance().changePlayerHealth(-10);
        }
    }
}

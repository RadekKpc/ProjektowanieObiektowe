package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.gameplay.MazeGame;
import pl.agh.edu.dp.labirynth.MapSite;

public class Wall extends MapSite {

    public Wall(){

    }

    @Override
    public void Enter(){
        MazeGame.getInstance().setCommunicat("Normalna sciana,brak przejscia");
    }
}

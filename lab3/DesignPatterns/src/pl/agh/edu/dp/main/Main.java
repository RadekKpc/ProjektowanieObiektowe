package pl.agh.edu.dp.main;

import pl.agh.edu.dp.gameplay.MazeGame;
import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.concreteMazeFacotories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.concreteMazeFacotories.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.mazes.CountingMaze;
import pl.agh.edu.dp.labirynth.conctereMazeBuilders.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.conctereMazeBuilders.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.mazes.Maze;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = MazeGame.getInstance();
        MazeFactory factory = EnchantedMazeFactory.getInstance();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze(factory);
        mazeGame.createMaze(standardBuilderMaze,factory);
        Maze maze = standardBuilderMaze.getResult();

        mazeGame.startGame(maze);

    }
}




package io.github.KunalSuman.Angry_Bird;


import com.badlogic.gdx.utils.Json;
import io.github.KunalSuman.Angry_Bird.Levels.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameSaver implements Serializable {
    public int score;
    public float birdPositionX;
    public float birdPositionY;
    public int currentBird;
    public static boolean level1Saved = false;
    public static boolean level2Saved = false;
    public static boolean level3Saved = false;
    public static boolean level4Saved = false;
    public static boolean level5Saved = false;
    public HashMap<Integer,Float> objectPositionsX;
    public HashMap<Integer,Float> objectPositionsY;
    public HashMap<Integer,Properties> p1;
    public int birdHealth;

    public GameSaver(Level1 level1, Level2 level2, Level3 level3, Level4 level4, Level5 level5) {
        System.out.println("Lol");
    }
    public GameSaver(int score, float birdPositionX,float birdPositionY, int birdHealth, int currentBird, HashMap<Integer,Float> objectPositionsX, HashMap<Integer,Float> objectPositionsY, HashMap<Integer,Properties> p1) {
        this.score = score;
        this.birdHealth = birdHealth;
        this.p1 = p1;
        this.birdPositionX = birdPositionX;
        this.birdPositionY = birdPositionY;
        this.currentBird = currentBird;
        this.objectPositionsX = objectPositionsX;
        this.objectPositionsY = objectPositionsY;
    }
    public void saveGame() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("SaveData.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
        System.out.println("Saved Game");
    }
}

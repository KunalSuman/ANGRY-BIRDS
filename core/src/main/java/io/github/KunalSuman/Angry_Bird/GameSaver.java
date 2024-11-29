package io.github.KunalSuman.Angry_Bird;


import com.badlogic.gdx.utils.Json;
import io.github.KunalSuman.Angry_Bird.Levels.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameSaver implements Serializable {
    public int score;
    public int CBI;
    public ArrayList<Float> birdPositionX;
    public ArrayList<Float> birdPositionY;
    public HashMap<Integer,Float> piggyPositionX;
    public HashMap<Integer,Float> piggyPositionY;
    public int currentBird;
    public boolean gameCompleted;
    public static boolean level1Saved = false;
    public static boolean level2Saved = false;
    public static boolean level3Saved = false;
    public static boolean level4Saved = false;
    public static boolean level5Saved = false;
    public int levelCalled;
    public HashMap<Integer,Float> objectPositionsX;
    public HashMap<Integer,Float> objectPositionsY;
    public HashMap<Integer,Properties> p1;
    public HashMap<Integer,Properties> p2;
    public ArrayList<Integer> birdHealth;
    public ArrayList<Float> birdSpeedX,birdSpeedY;
    public HashMap<Integer,ArrayList<Float>> piggySpeed;
    public HashMap<Integer,ArrayList<Float>> objectSpeed;
    public HashMap<Integer,Integer> piggyHealth;
    public GameSaver(Level1 level1, Level2 level2, Level3 level3, Level4 level4, Level5 level5) {
        System.out.println("Lol");
    }
    public GameSaver(int score,HashMap<Integer,Integer> piggyHealth,ArrayList<Float> birdSpeedX,ArrayList<Float> birdSpeedY, ArrayList<Float> birdPositionX,ArrayList<Float> birdPositionY,
                     HashMap<Integer,ArrayList<Float>> piggySpeed,HashMap<Integer,ArrayList<Float>> objectSpeed,HashMap<Integer,Float> piggyPositionX,HashMap<Integer,Float> piggyPositionY, ArrayList<Integer> birdHealth, int currentBird, HashMap<Integer,Float> objectPositionsX, HashMap<Integer,Float> objectPositionsY, HashMap<Integer,Properties> p1,HashMap<Integer,Properties> p2,int Levelcalled,
                     Boolean gameCompleted,int CBI) {
        this.score = score;
        this.CBI = CBI;
        this.piggyHealth = piggyHealth;
        this.objectSpeed = objectSpeed;
        this.levelCalled = Levelcalled;
        this.birdHealth = birdHealth;
        this.piggySpeed = piggySpeed;
        this.birdSpeedX = birdSpeedX;
        this.birdSpeedY = birdSpeedY;
        this.gameCompleted = gameCompleted;
        this.p1 = p1;
        this.p2 = p2;
        this.piggyPositionX = piggyPositionX;
        this.piggyPositionY = piggyPositionY;
        this.birdPositionX = birdPositionX;
        this.birdPositionY = birdPositionY;
        this.currentBird = currentBird;
        this.objectPositionsX = objectPositionsX;
        this.objectPositionsY = objectPositionsY;
    }
    public void saveGame() throws IOException {
        FileOutputStream fileOut = null;
        if (levelCalled == 1){
            fileOut = new FileOutputStream("SaveData1.ser");
        }else if (levelCalled == 2){
            fileOut = new FileOutputStream("SaveData2.ser");
        }else if (levelCalled == 3){
            fileOut = new FileOutputStream("SaveData3.ser");
        }else if (levelCalled == 4){
            fileOut = new FileOutputStream("SaveData4.ser");
        }else if (levelCalled == 5){
            fileOut = new FileOutputStream("SaveData5.ser");
        }

        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
        System.out.println("Saved Game");
    }
}

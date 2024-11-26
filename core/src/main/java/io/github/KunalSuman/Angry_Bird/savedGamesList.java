package io.github.KunalSuman.Angry_Bird;

import java.io.*;
import java.util.ArrayList;

public class savedGamesList implements Serializable {

    ArrayList<Integer> completedLevel=new ArrayList<>();
    public savedGamesList(){

    }
    public int setLevel1(){
        completedLevel.add(1);
        return 1;
    }
    public int setLevel2(){
        completedLevel.add(2);
        return 2;
    }
    public int setLevel3(){
        completedLevel.add(3);
        return 3;
    }
    public int setLevel4(){
        completedLevel.add(4);
        return 4;
    }
    public int setLevel5(){
        completedLevel.add(5);
        return 5;
    }
    public void saveArray() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("SaveArray.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
        System.out.println("Saved Game");
    }
    public static ArrayList<Integer> loadArray() throws IOException, ClassNotFoundException {
        savedGamesList savedGames;
        FileInputStream fileIn = new FileInputStream("SaveArray.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        savedGames = (savedGamesList) in.readObject();
        in.close();
        fileIn.close();
        return savedGames.completedLevel;
    }
}

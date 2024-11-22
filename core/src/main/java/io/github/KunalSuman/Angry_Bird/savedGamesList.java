package io.github.KunalSuman.Angry_Bird;

import java.io.*;
import java.util.ArrayList;

public class savedGamesList implements Serializable {

    ArrayList<Integer> completedLevel=new ArrayList<>();
    public savedGamesList(){

    }
    public void setLevel1(){
        completedLevel.add(1);
    }
    public void setLevel2(){
        completedLevel.add(2);
    }
    public void setLevel3(){
        completedLevel.add(3);
    }
    public void setLevel4(){
        completedLevel.add(4);
    }
    public void setLevel5(){
        completedLevel.add(5);
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

package tests;

import io.github.KunalSuman.Angry_Bird.savedGamesList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Test2 {
    @Test
    public void level1SetTest(){
        savedGamesList s = new savedGamesList();
        int k = s.setLevel1();
        assertEquals(k,1);
    }
    @Test
    public void level2SetTest(){
        savedGamesList s = new savedGamesList();
        int k = s.setLevel2();
        assertEquals(k,2);
    }
    @Test
    public void level3SetTest(){
        savedGamesList s = new savedGamesList();
        int k = s.setLevel3();
        assertEquals(k,3);
    }
    @Test
    public void level4SetTest(){
        savedGamesList s = new savedGamesList();
        int k = s.setLevel4();
        assertEquals(k,4);
    }
    @Test
    public void level5SetTest(){
        savedGamesList s = new savedGamesList();
        int k = s.setLevel5();
        assertEquals(k,5);
    }


}

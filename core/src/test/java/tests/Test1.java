package tests;

import io.github.KunalSuman.Angry_Bird.End_level_helper_class;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {
    @Test
    public void test1(){
        int x = End_level_helper_class.CCL(6);
        assertEquals(x , 0);
    }
    @Test
    public void test2(){
        int x = End_level_helper_class.CWL(6);
        assertEquals(x , 0);
    }
}

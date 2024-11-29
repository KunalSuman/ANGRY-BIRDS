package tests;

import io.github.KunalSuman.Angry_Bird.End_level_helper_class;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test5 {
    @Test
    public void test(){
        int k = End_level_helper_class.setPiggyDamage(60);
        assertEquals(30,k);
    }

}

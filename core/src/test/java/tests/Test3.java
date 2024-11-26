package tests;

import io.github.KunalSuman.Angry_Bird.End_level_helper_class;
import io.github.KunalSuman.Angry_Bird.Levels.Level_selector;
import io.github.KunalSuman.Angry_Bird.StoryPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test3 {
    @Test
    public void pauseReturnerTest(){
        int l =End_level_helper_class.returnNumberChecker(9);
        assertEquals(0, l);
    }
}

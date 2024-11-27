package tests;

import io.github.KunalSuman.Angry_Bird.StoryPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test4 {
    @Test
    public void TestingSaveQuit(){
        boolean frameTrue =StoryPage.numberOfFramesLoaded(12,10);
        assertEquals(frameTrue,false);
    }
}

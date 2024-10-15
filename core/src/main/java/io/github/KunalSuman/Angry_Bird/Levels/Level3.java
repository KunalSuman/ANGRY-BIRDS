package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.KunalSuman.Angry_Bird.Main;

public class Level3 extends ScreenAdapter {
    public Main main ;
    public SpriteBatch batch ;
    public Texture background;
    public Level3(){
        this.main = new Main();
        this.background = new Texture("Level3.png");
    }
    

}

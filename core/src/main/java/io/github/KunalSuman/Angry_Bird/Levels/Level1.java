package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.KunalSuman.Angry_Bird.Main;

public class Level1 extends ScreenAdapter {
    public Main main ;
    public SpriteBatch batch ;
    public Texture background;
    public Level1(Main main){
        this.main = new Main();
        this.background = new Texture("Level3.png");
    }
    public void render(float delta){
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
    }
}

package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.KunalSuman.Angry_Bird.Main;

public class Level_selector extends ScreenAdapter {
    public Main main ;
    public Texture levels_page ;
    public SpriteBatch batch ;
    public Level_selector(Main main) {
        this.main = main;
        this.batch = new SpriteBatch();
        this.levels_page = new Texture("level1.png");
    }
    public void select_level(int level) {

    }
    public void render(float delta){
        batch.begin();
        batch.draw(levels_page,0,0);
        batch.end();
    }
}

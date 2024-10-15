package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.KunalSuman.Angry_Bird.Levels.Level_selector;

import static com.badlogic.gdx.graphics.g3d.particles.ParticleShader.AlignMode.Screen;

public class Menu_page extends ScreenAdapter {
    public Texture background;
    public AssetManager assetManager;
    public SpriteBatch batch;
    public Main main;
    public int y ;
    public Menu_page(Main main) {
        this.main = main;
        this.assetManager = new AssetManager();
        background = new Texture("BACKGROUNDS_GE_1.png");
        this.batch = new SpriteBatch();
        y = 0 ;
    }
    public void render(float delta) {
        batch.begin();
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            y = 1;
        }
        if(y == 1){
            main.setScreen(new Level_selector(main));
        }
        else{
            batch.draw(background, 0, 0);
        }
        batch.end();
    }
}

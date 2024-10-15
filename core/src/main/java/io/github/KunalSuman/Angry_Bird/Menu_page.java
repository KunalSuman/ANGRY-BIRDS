package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.graphics.g3d.particles.ParticleShader.AlignMode.Screen;

public class Menu_page extends ScreenAdapter {
    public Texture background;
    public AssetManager assetManager;
    public SpriteBatch batch;
    public void menu_page(){
        background = new Texture("BACKGROUNDS_GE_1.png");
        batch = new SpriteBatch();
    }
    public void render() {
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
    }
}

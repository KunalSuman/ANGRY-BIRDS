package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.Levels.Level1;
import io.github.KunalSuman.Angry_Bird.Levels.Level2;
import io.github.KunalSuman.Angry_Bird.Levels.Level_selector;

import static com.badlogic.gdx.graphics.g3d.particles.ParticleShader.AlignMode.Screen;

public class Menu_page extends ScreenAdapter {
    public Texture background;
    public AssetManager assetManager;
    public SpriteBatch batch;
    public Main main;
    public int y ;
    public Stage stage ;
    public ImageButton button ;

    public Menu_page(Main main) {
        this.main = main;
        this.assetManager = new AssetManager();
        background = new Texture("BACKGROUNDS_GE_1.png");
        this.batch = new SpriteBatch();
//        stage = new Stage(new ScreenViewport());
//        button = new ImageButton(new Skin());
//        stage.addActor(button);
        y = 0 ;
    }
    public void render(float delta) {
        batch.begin();
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            y = 1;
        }
        if(y == 1){
            main.setScreen(new Level2(main));
        }
        else{

            batch.draw(background, 0, 0);
        }
        batch.end();
    }
}

package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.Levels.Level_selector;

import static com.badlogic.gdx.graphics.g3d.particles.ParticleShader.AlignMode.Screen;

public class Unlocked_birds_page extends ScreenAdapter {
    public Texture background;
    public AssetManager assetManager;
    public Stage stage;
    public SpriteBatch batch;
    private Texture playButtonTexture;
    private Texture settingsButtonTexture;
//    private Texture bird1;
//    private Texture bird2;
//    private Texture bird3;
//    private Texture Egg;
    private float sW,sH,sX,sY;
//    private float pbW, pbH, pbX, pbY;
//    public Texture chuck ;
//    public Texture chuck_unlocked ;
//    public Texture bomb ;
//    public Texture bomb_unlocked ;
//    public Texture blues ;
//    public Texture blues_unlocked ;
    public Texture invisible_png ;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer Bomb_unlocked ;
    public OrthogonalTiledMapRenderer Chuck_unlocked ;
    public OrthogonalTiledMapRenderer Blues_unlocked ;
    public int chuck_unlocked = 0 ;
    public int bomb_unlocked = 0 ;
    public int blues_unlocked = 0 ;
    // Variables for Play button size and position

    public Main main;
    public Unlocked_birds_page(Main main ,int chuck_unlocked,int bomb_unlocked,int blues_unlocked) {
        this.main = main;
        this.assetManager = new AssetManager();
        this.stage = new Stage(new ScreenViewport());
        this.bomb_unlocked = bomb_unlocked ;
        this.chuck_unlocked = chuck_unlocked ;
        this.blues_unlocked = blues_unlocked ;
        Gdx.input.setInputProcessor(stage);
        background = new Texture("BACKGROUNDS_GE_1.png");
        this.batch = new SpriteBatch();
        camera = new OrthographicCamera();
        Bomb_unlocked = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("BOMB_UNLOCKED.tmx"));
        Chuck_unlocked = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("CHUCK_UNLOCKED.tmx"));
        Blues_unlocked = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("BLUES_UNLOCKED.tmx"));


        camera.setToOrtho(false, 1920,1080);
    }
    public void render(float delta) {

        camera.update();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//      batch.draw(playButtonTexture, pbX, pbY, pW, pH);// Draw the button

//        batch.draw(settingsButtonTexture, sX, sY, sW, sH);
        batch.end();



        if(bomb_unlocked == 1) {
            Bomb_unlocked.setView(camera);
            Bomb_unlocked.render();
        }
        if(chuck_unlocked == 1) {
            Chuck_unlocked.setView(camera);
            Chuck_unlocked.render();
        }
        if(blues_unlocked == 1) {
            Blues_unlocked.setView(camera);
            Blues_unlocked.render();
        }

        stage.act(delta);
        Gdx.input.setInputProcessor(stage);
        stage.draw();
        // Render the stage (buttons, if any)

    }
    @Override
    public void resize(int width, int height){
        stage.getViewport().update(width, height, true);
    }
    public void dispose() {
        stage.dispose();
        background.dispose();
        playButtonTexture.dispose(); // Dispose the button texture
        batch.dispose();
    }
}

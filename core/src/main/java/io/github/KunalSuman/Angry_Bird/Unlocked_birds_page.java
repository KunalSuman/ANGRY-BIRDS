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
    private Stage stage;
    public SpriteBatch batch;
    private Texture playButtonTexture;
    private Texture settingsButtonTexture;
    private Texture bird1;
    private Texture bird2;
    private Texture bird3;
    private Texture Egg;
    private float sW,sH,sX,sY;
    private float pbW, pbH, pbX, pbY;
    public Texture chuck ;
    public Texture chuck_unlocked ;
    public Texture bomb ;
    public Texture bomb_unlocked ;
    public Texture blues ;
    public Texture blues_unlocked ;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer Bomb_unlocked ;
    public OrthogonalTiledMapRenderer Chuck_unlocked ;
    public OrthogonalTiledMapRenderer Blues_unlocked ;
    // Variables for Play button size and position

    public Main main;
    public Unlocked_birds_page(Main main) {
        this.main = main;
        this.assetManager = new AssetManager();
        this.stage = new Stage(new ScreenViewport());
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
        Bomb_unlocked.setView(camera);
        Chuck_unlocked.setView(camera);
        Blues_unlocked.setView(camera);
        Bomb_unlocked.render();
        Chuck_unlocked.render();
        Blues_unlocked.render();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//      batch.draw(playButtonTexture, pbX, pbY, pW, pH);// Draw the button
        batch.draw(settingsButtonTexture, sX, sY, sW, sH);
        batch.end();

        // Render the stage (buttons, if any)
        stage.act(delta);
        stage.draw();
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

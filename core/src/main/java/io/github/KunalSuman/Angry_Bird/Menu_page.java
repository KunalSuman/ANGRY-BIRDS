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

public class Menu_page extends ScreenAdapter {
    public Texture background;
    public AssetManager assetManager;
    private Stage stage;
    public SpriteBatch batch;
    public int birdnumber=1;
    private Texture playButtonTexture;
    public ImageButton playButton;
    private Texture settingsButtonTexture;
    private float sW,sH,sX,sY;
    private float pbW, pbH, pbX, pbY;
    private float ubW,ubH,ubX,ubY;
    private Texture unlockedBirdButton;
    public Main main;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer renderer ;
    public int x = 0 ;
    public int y = 0 ;
    public int z = 0 ;
    public OrthogonalTiledMapRenderer Bomb_unlocked ;
    public OrthogonalTiledMapRenderer Chuck_unlocked;
    public OrthogonalTiledMapRenderer Blues_unlocked ;
    public Menu_page(Main main) {
        this.main = main;
        this.assetManager = new AssetManager();
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        //background = new Texture("MENUE_page.png");
        this.batch = new SpriteBatch();
        settingsButtonTexture = new Texture("settings_button.png");
        camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("MENUE_PAGE.tmx"));
        camera.setToOrtho(false, 1920, 1080);
        sW = Gdx.graphics.getWidth() * 0.075f;
        sH = Gdx.graphics.getHeight() * 0.1f;
        sX = 0;  // Position at bottom-left corner
        sY = 50;
        pbW = Gdx.graphics.getWidth() * 0.18f;
        pbH = Gdx.graphics.getHeight() * 0.2f;
        pbX = (Gdx.graphics.getWidth() - pbW) / 2f;
        pbY = (Gdx.graphics.getHeight() - pbH) / 3f;

        ubW = Gdx.graphics.getWidth() * 0.2f;
        ubH = Gdx.graphics.getHeight() * 0.2f;
        ubX = (Gdx.graphics.getWidth() - ubW) ;
        ubY = (0);

        playButtonTexture = new Texture("BUTTONS_SHEET_1.png");
        TextureRegionDrawable playButtonDrawable = new TextureRegionDrawable(new TextureRegion(playButtonTexture));
        TextureRegionDrawable playButtonClickedDrawable = new TextureRegionDrawable(new TextureRegion(settingsButtonTexture));
        ImageButton.ImageButtonStyle playButtonStyle = new ImageButton.ImageButtonStyle();
        playButtonStyle.up = playButtonDrawable;
        playButton = new ImageButton(playButtonStyle);
        stage.addActor(playButton);
        playButton.setSize(pbW, pbH);
        playButton.setPosition(pbX, pbY);
//        pW =700;
//        pH = 400;
//        pbX = (Gdx.graphics.getWidth() - pW) / 2f;
//        pbY = (Gdx.graphics.getHeight() - pH) / 2f;

        unlockedBirdButton = new Texture("BUTTONS_SHEET_1.png");
        TextureRegionDrawable unlockedBirdButtonDrawable = new TextureRegionDrawable(new TextureRegion(unlockedBirdButton));
        ImageButton.ImageButtonStyle unlockedBirdButtonStyle = new ImageButton.ImageButtonStyle();
        unlockedBirdButtonStyle.up = unlockedBirdButtonDrawable;
        ImageButton unlockedBirdButton = new ImageButton(unlockedBirdButtonStyle);
        //stage.addActor(unlockedBirdButton);
        unlockedBirdButton.setSize(ubW, ubH);
        unlockedBirdButton.setPosition(ubX, ubY);

        stage.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                float adjustedY = Gdx.graphics.getHeight() - y;
//                if (x>=pbX && x<=pbX+pW && y>=pbY && y<=pbY+pH){
//                    main.setScreen(new Level_selector(main));}
                if (x>=sX && x<=sX+sW && adjustedY>=sY && y<=sY+sH){
                    main.setScreen(new Settings_page(main , renderer));
                }
            }
        });
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level_selector(main));
            }
        });
//        unlockedBirdButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                if (birdnumber<=4) {
//                    birdnumber++;
//                }
//                if (birdnumber == 1){
//                    background = new Texture("BACKGROUNDS_GE_1.png");
//                }else if (birdnumber == 2){
//                    background = new Texture("BACKGROUNDS_GE_1.png");
//                }else if (birdnumber == 3){
//                    background = new Texture("BACKGROUNDS_GE_1.png");
//                }else if (birdnumber == 4){
//                    background = new Texture("BACKGROUNDS_GE_1.png");
//                }
//            }
//        });
    }
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        renderer.setView(camera);
        renderer.render();
        if(x == 1){
            Bomb_unlocked.setView(camera);
            Bomb_unlocked.render();
        }
        if(y==1){
            Chuck_unlocked.setView(camera);
            Chuck_unlocked.render();
        }
        if(z == 1){
            Blues_unlocked.setView(camera);
            Blues_unlocked.render();
        }
        batch.begin();
        //batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        batch.draw(playButtonTexture, pbX, pbY, pW, pH);// Draw the button
        batch.draw(settingsButtonTexture, sX, sY, sW, sH);
        batch.end();

        // Render the stage (buttons, if any)
        stage.act(delta);
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {

        stage.getViewport().update(width, height, true);
        pbW = Gdx.graphics.getWidth() * 0.18f;
        pbH = Gdx.graphics.getHeight() * 0.2f;
        pbX = (Gdx.graphics.getWidth() - pbW) / 1.9f;
        pbY = (Gdx.graphics.getHeight() - pbH) / 6.25f;

        playButton.setSize(pbW, pbH);
        playButton.setPosition(pbX, pbY);
    }
    public void dispose() {
        stage.dispose();
        background.dispose();
        playButtonTexture.dispose();
        batch.dispose();
    }
}

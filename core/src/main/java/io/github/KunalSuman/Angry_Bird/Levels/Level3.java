package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.Main;

public class Level3 extends ScreenAdapter {
    public Main main ;
    public SpriteBatch batch ;
    public Texture background;
    public Stage stage ;
    public Stage pauseStage;
    public Texture pauseTexture;
    private boolean isPaused = false;
    private int pause;
    public Texture closeButton;
    public Texture pauseButton;
    public Texture backButtonTexture;
    public TiledMap map;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer renderer ;
    public Level3(Main main) {
        this.main = new Main();
        pause =0;
        stage = new Stage(new ScreenViewport());
        pauseStage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        pauseButton = new Texture("pauseButton.png");
        backButtonTexture = new Texture("backButton.png");
        //this.background = new Texture("Level3.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        map = new TmxMapLoader().load("LEVEL3.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        TextureRegionDrawable drawablePauseButton = new TextureRegionDrawable(new TextureRegion(pauseButton));
        ImageButton.ImageButtonStyle pauseButtonStyle = new ImageButton.ImageButtonStyle();
        pauseButtonStyle.up = drawablePauseButton;
        ImageButton pauseButton = new ImageButton(pauseButtonStyle);

        TextureRegionDrawable drawablebackButton = new TextureRegionDrawable(new TextureRegion(backButtonTexture));
        ImageButton.ImageButtonStyle backButtonStyle = new ImageButton.ImageButtonStyle();
        backButtonStyle.up = drawablebackButton;
        ImageButton backButton = new ImageButton(backButtonStyle);

        stage.addActor(pauseButton);
        stage.addActor(backButton);
        pauseButton.setSize(100,100);
        pauseButton.setPosition(0, 0);
        backButton.setSize(100,100);
        backButton.setPosition(0,Gdx.graphics.getHeight()-backButton.getHeight());

        closeButton = new Texture("closeButton.png");
        TextureRegionDrawable drawablecloseButton = new TextureRegionDrawable(new TextureRegion(closeButton));
        ImageButton.ImageButtonStyle closeButtonStyle = new ImageButton.ImageButtonStyle();
        closeButtonStyle.up = drawablecloseButton;
        ImageButton closeButton = new ImageButton(closeButtonStyle);
        pauseStage.addActor(closeButton);
        closeButton.setSize(100,100);
        closeButton.setPosition(Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());


        pauseButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isPaused = true;
                Gdx.input.setInputProcessor(pauseStage);
            }
        });
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level_selector(main));
            }
        });
        closeButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isPaused = false;
                Gdx.input.setInputProcessor(stage);
            }
        });
        pauseTexture = new Texture("SETTINGS.png");
    }
    public void render(float delta){
        camera.update();
        renderer.setView(camera);
        renderer.render();
        if (!isPaused){
            stage.act(delta);
            stage.draw();
        }
        if (isPaused){
            pauseStage.act(delta);
            pauseStage.getBatch().begin();
            pauseStage.getBatch().draw(pauseTexture,(Gdx.graphics.getWidth()-pauseTexture.getWidth())/2f,(Gdx.graphics.getHeight()-pauseTexture.getHeight())/2f);
            pauseStage.getBatch().end();
            pauseStage.draw();
        }
//        batch.begin();
//        batch.draw(background, 0, 0);
//        batch.end();
    }
}

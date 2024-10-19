package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import io.github.KunalSuman.Angry_Bird.LostLevel;
import io.github.KunalSuman.Angry_Bird.Main;
import io.github.KunalSuman.Angry_Bird.Menu_page;

public class Level1 extends ScreenAdapter {
    public Main main ;
    public SpriteBatch batch ;
    public Texture background;
    public Texture elements;
    public Stage stage ;
    public Stage pauseStage;
    public TiledMap map;
    public Texture pauseTexture;
    private boolean isPaused = false;
    private int pause;
    public Texture closeButton;
    public Texture pauseButton;
    public Texture backButtonTexture;
    private float pbX,pbY,pbW,pbH;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera ;
    public Stage lostStage;
    public Texture retryTexture ;
    public Texture tomenue ;
    public Stage winStage;
    public Texture winTexture ;
    public int x = 0 ;

    public Level1(Main main){
        this.main = new Main();
        this.batch = new SpriteBatch();
        pause =0;
        //this.background = new Texture("Level3.png");
        this.elements = new Texture("libgdx.png");
        stage = new Stage(new ScreenViewport());
        pauseStage = new Stage(new ScreenViewport());
        lostStage = new Stage(new ScreenViewport());
        winStage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        pauseButton = new Texture("pauseButton.png");
        closeButton = new Texture("closeButton.png");
        map = new TmxMapLoader().load("LEVEL1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);  // Match camera to window size
        TextureRegionDrawable drawablePauseButton = new TextureRegionDrawable(new TextureRegion(pauseButton));
        ImageButton.ImageButtonStyle pauseButtonStyle = new ImageButton.ImageButtonStyle();
        pauseButtonStyle.up = drawablePauseButton;
        ImageButton pauseButton = new ImageButton(pauseButtonStyle);
        float menuX = (Gdx.graphics.getWidth() - pauseButton.getWidth()) / 2;  // Center horizontally
        float menuY = (Gdx.graphics.getHeight() - pauseButton.getHeight()) / 2; // Center vertically
        stage.addActor(pauseButton);
        pauseButton.setSize(100,100);
        pauseButton.setPosition(0, 0);

        backButtonTexture = new Texture("backButton.png");
        TextureRegionDrawable drawablebackButton = new TextureRegionDrawable(new TextureRegion(backButtonTexture));
        ImageButton.ImageButtonStyle backButtonStyle = new ImageButton.ImageButtonStyle();
        backButtonStyle.up = drawablebackButton;
        ImageButton backButton = new ImageButton(backButtonStyle);
        stage.addActor(backButton);
        backButton.setSize(100,100);
        backButton.setPosition(0,Gdx.graphics.getHeight()-backButton.getHeight());

        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");

        TextureRegionDrawable drawablecloseButton = new TextureRegionDrawable(new TextureRegion(closeButton));
        ImageButton.ImageButtonStyle closeButtonStyle = new ImageButton.ImageButtonStyle();
        closeButtonStyle.up = drawablecloseButton;
        ImageButton closeButton = new ImageButton(closeButtonStyle);

        pauseStage.addActor(closeButton);
        //lostStage.addActor(retryButton);
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
        pauseTexture = new Texture("Pause_menu.png");
        //stage.addActor(elements).width(2).height(4);
    }
    public void render(float delta){

        camera.update();
        renderer.setView(camera);
        renderer.render();
        batch.begin();

        if(x==1){
            lostStage.act(delta);
            lostStage.getBatch().begin();
            lostStage.getBatch().draw(retryTexture,(Gdx.graphics.getWidth()-retryTexture.getWidth())/2f,(Gdx.graphics.getHeight()-retryTexture.getHeight())/2f);
            lostStage.getBatch().end();
            lostStage.draw();
        }
        if(x==2){
            winStage.act(delta);
            winStage.getBatch().begin();
            winStage.getBatch().draw(winTexture,(Gdx.graphics.getWidth()-winTexture.getWidth())/2f,(Gdx.graphics.getHeight()-winTexture.getHeight())/2f);
            winStage.getBatch().end();
            winStage.draw();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            x =1 ;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            x =2 ;
        }
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
        batch.end();
    }
}

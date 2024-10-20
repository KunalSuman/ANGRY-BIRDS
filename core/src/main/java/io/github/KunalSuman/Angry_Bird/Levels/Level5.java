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
import io.github.KunalSuman.Angry_Bird.Completed_Level;
import io.github.KunalSuman.Angry_Bird.Main;
import io.github.KunalSuman.Angry_Bird.New_pause;
import io.github.KunalSuman.Angry_Bird.Pause;

public class Level5 extends ScreenAdapter {
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
    public Texture MenuButton ;
    public Texture backButtonTexture;
    private float pbX,pbY,pbW,pbH;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer renderer ;
    public Stage lostStage;
    public Texture retryTexture ;
    public Texture tomenue ;
    public Stage winStage;
    public Texture winTexture ;
    public Texture MenuButtonTexture ;
    public Texture Nextlevel ;
    public Texture retryButtonTexture;
    public int x = 0 ;
    public Pause pause_render ;
    public Level5(Main main){
        this.main = main ;
        camera = new OrthographicCamera();
        map = new TmxMapLoader().load("LEVEL5.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera.setToOrtho(false, 1920, 1080);
        this.main = new Main();
        this.batch = new SpriteBatch();
        pause =0;
        lostStage = new Stage(new ScreenViewport());
        winStage = new Stage(new ScreenViewport());
        //this.background = new Texture("Level3.png");
        this.elements = new Texture("libgdx.png");
        stage = new Stage(new ScreenViewport());
        pauseStage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        pause_render = new Pause(main ,map ,5);
        pauseButton = new Texture("pauseButton.png");
        closeButton = new Texture("closeButton.png");
        MenuButtonTexture = new Texture("Menu_button.png");
        retryButtonTexture = new Texture("Retry_button.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        Nextlevel = new Texture("Next_level_button.png");
        //map = new TmxMapLoader().load("LEVEL1.tmx");
        //renderer = new OrthogonalTiledMapRenderer(map);
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false, 1920, 1080);  // Match camera to window size
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

        TextureRegionDrawable drawablecloseButton = new TextureRegionDrawable(new TextureRegion(closeButton));
        ImageButton.ImageButtonStyle closeButtonStyle = new ImageButton.ImageButtonStyle();
        closeButtonStyle.up = drawablecloseButton;
        ImageButton closeButton = new ImageButton(closeButtonStyle);
        pauseStage.addActor(closeButton);
        closeButton.setSize(100,100);
        closeButton.setPosition(Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());


        TextureRegionDrawable lost_menu = new TextureRegionDrawable(new TextureRegion(MenuButtonTexture));
        ImageButton.ImageButtonStyle lost_Menu_button = new ImageButton.ImageButtonStyle();
        lost_Menu_button.up = lost_menu;
        ImageButton lostMenubutton = new ImageButton(lost_Menu_button);
        lostStage.addActor(lostMenubutton);
        lostMenubutton.setSize(280,120);
        lostMenubutton.setPosition(1000,175);

        TextureRegionDrawable retryButton = new TextureRegionDrawable(new TextureRegion(retryButtonTexture));
        ImageButton.ImageButtonStyle retryButton_button = new ImageButton.ImageButtonStyle();
        retryButton_button.up = retryButton;
        ImageButton retryButtons = new ImageButton(retryButton_button);
        lostStage.addActor(retryButtons);
        retryButtons.setSize(260,120);
        retryButtons.setPosition(700,175);

        TextureRegionDrawable To_menu = new TextureRegionDrawable(new TextureRegion(MenuButtonTexture));
        ImageButton.ImageButtonStyle Menu_button = new ImageButton.ImageButtonStyle();
        Menu_button.up = To_menu;
        ImageButton Menubutton = new ImageButton(Menu_button);
        winStage.addActor(Menubutton);
        Menubutton.setSize(390,170);
        Menubutton.setPosition(550,70);

        TextureRegionDrawable next_level = new TextureRegionDrawable(new TextureRegion(Nextlevel));
        ImageButton.ImageButtonStyle Next_button = new ImageButton.ImageButtonStyle();
        Next_button.up = next_level;
        ImageButton Nextbutton = new ImageButton(Next_button);
        winStage.addActor(Nextbutton);
        Nextbutton.setSize(400,180);
        Nextbutton.setPosition(1000,70);

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
        Menubutton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level_selector(main));
            }
        });
        Nextbutton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Completed_Level(main , 5));
            }
        });
//        Menubutton.addListener(new ClickListener(){
//
//                main.setScreen(new Completed_Level(main , 5));
//        });
        pauseTexture = new Texture("SETTINGS.png");
    }
    public void render(float delta) {

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
            stage.act(delta);
            stage.draw();
            winStage.act(delta);
            winStage.getBatch().begin();
            winStage.getBatch().draw(winTexture,(Gdx.graphics.getWidth()-winTexture.getWidth())/2f,(Gdx.graphics.getHeight()-winTexture.getHeight())/2f);
            winStage.getBatch().end();
            winStage.draw();
        }
        if(x==0) {
            if (!isPaused) {
                stage.act(delta);
                stage.draw();
            }
            if (isPaused) {
                //Gdx.input.setInputProcessor(pauseStage);
                pause_render.render(delta);
//                pauseStage.act(delta);
//                pauseStage.getBatch().begin();
//                pauseStage.getBatch().draw(pauseTexture, (Gdx.graphics.getWidth() - pauseTexture.getWidth()) / 2f, (Gdx.graphics.getHeight() - pauseTexture.getHeight()) / 2f);
//                pauseStage.getBatch().end();
//                pauseStage.draw();
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            x =1 ;

            Gdx.input.setInputProcessor(lostStage);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            x =2 ;
            Gdx.input.setInputProcessor(winStage);
            }

        batch.end();
    }
    public void dispose() {
        //stage.dispose();
        background.dispose();
        batch.dispose();
        //pauseStage.dispose();
    }
}

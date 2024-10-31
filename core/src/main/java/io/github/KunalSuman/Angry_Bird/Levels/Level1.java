package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.*;

import java.awt.*;

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
    public Texture MenuButtonTexture ;
    public Texture Nextlevel ;
    public Texture retryButtonTexture;
    public int x = 0 ;
    public Pause pause_render;
    private Body body ;
    private PolygonShape shape ;
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer() ;
    private World world  = new World(new Vector2(0,-10),true);
    BodyDef bodyDef = new BodyDef();
    Body body2 ;
    Body body3 ;
    private float distance = 50.0f ;
    private FixtureDef fixtureDef = new FixtureDef() ;
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
        MenuButtonTexture = new Texture("Menu_button.png");
        retryButtonTexture = new Texture("Retry_button.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        Nextlevel = new Texture("Next_level_button.png");
        map = new TmxMapLoader().load("LEVEL1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setInputProcessor(stage);

        // Match camera to window size
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

        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        pause_render = new Pause(main ,map ,1);

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

        pauseStage.addActor(closeButton);
        //lostStage.addActor(retryButton);
        closeButton.setSize(100,100);
        closeButton.setPosition(Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());

        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(291 ,590);
        body2 = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(20);

        fixtureDef.shape = circleShape ;
        body2.createFixture(fixtureDef);


        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle R2 = ((RectangleMapObject) object).getRectangle();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set(R2.x + R2.width/2 , R2.y + R2.height/2);
            body3 = world.createBody(bodyDef);

            shape = new PolygonShape();
            shape.setAsBox(R2.width/2, R2.height/2);
            fixtureDef.shape = shape;
            body3.createFixture(fixtureDef);
        }


        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle R1 = ((RectangleMapObject) object).getRectangle();
            bodyDef.type = BodyDef.BodyType.DynamicBody;
            bodyDef.position.set(R1.x + R1.width/2, R1.y +R1.height/2);
            body = world.createBody(bodyDef);

            shape = new PolygonShape();
            shape.setAsBox(R1.width/2, R1.height/2);

            fixtureDef.shape = shape;
            body.createFixture(fixtureDef);
        }




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
        pauseTexture = new Texture("Pause_menu.png");
        //stage.addActor(elements).width(2).height(4);
    }
    public void render(float delta) {
        camera.update();
        renderer.setView(camera);
        renderer.render();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.getBatch().setProjectionMatrix(camera.combined);
        stage.draw();
        Vector2 pos = body2.getPosition();
        if (Gdx.input.isKeyPressed(Input.Keys.W) && pos.y < 1080) {
            body2.setTransform(pos.x, pos.y + distance * Gdx.graphics.getDeltaTime(), 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && pos.y > 0) {
            body2.setTransform(pos.x, pos.y - distance * Gdx.graphics.getDeltaTime(), 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && pos.x > 0) {
            body2.setTransform(pos.x - distance * Gdx.graphics.getDeltaTime(), pos.y, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && pos.x < 1920 ) {
            body2.setTransform(pos.x + distance * Gdx.graphics.getDeltaTime(), pos.y, 0);
        }
        world.step(1/60f,6,2);
        batch.begin();

        if (x == 1) {
            stage.act(delta);
            stage.draw();
            lostStage.act(delta);
            lostStage.getBatch().begin();
            lostStage.getBatch().draw(retryTexture, (Gdx.graphics.getWidth() - retryTexture.getWidth()) / 2f, (Gdx.graphics.getHeight() - retryTexture.getHeight()) / 2f);
            lostStage.getBatch().end();
            lostStage.draw();
        }
        if (x == 2) {
            stage.act(delta);
            stage.draw();
            winStage.act(delta);
            winStage.getBatch().begin();
            winStage.getBatch().draw(winTexture, (Gdx.graphics.getWidth() - winTexture.getWidth()) / 2f, (Gdx.graphics.getHeight() - winTexture.getHeight()) / 2f);
            winStage.getBatch().end();
            winStage.draw();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            x = 1;
            Gdx.input.setInputProcessor(lostStage);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            x = 2;
            Gdx.input.setInputProcessor(winStage);
        }
        if (x == 0) {
            if (!isPaused) {
                stage.act(delta);
                stage.draw();
            }
            if (isPaused) {
                pause_render.render(delta);
//                pauseStage.act(delta);
//                pauseStage.getBatch().begin();
//                pauseStage.getBatch().draw(pauseTexture, (Gdx.graphics.getWidth() - pauseTexture.getWidth()) / 2f, (Gdx.graphics.getHeight() - pauseTexture.getHeight()) / 2f);
//                pauseStage.getBatch().end();
//                pauseStage.draw();
            }
        }
        batch.end();
        debugRenderer.render(world,camera.combined);
    }
}

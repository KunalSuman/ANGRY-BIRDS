package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.*;

public class Level4 extends ScreenAdapter {
    public Main main ;
    public SpriteBatch batch ;
    public Texture background;
    public Texture elements;
    public Stage stage ;
    public Stage pauseStage;
    public TiledMap map;
    public Texture pauseTexture;
    private boolean isPaused = false;
    public Texture closeButton;

    public Texture backButtonTexture;

    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer renderer ;
    public Stage lostStage;
    public Texture retryTexture ;

    public Stage winStage;
    public Texture winTexture ;
    public Texture MenuButtonTexture ;
    public Texture Nextlevel ;
    public Texture retryButtonTexture;
    public int x = 0 ;
    public Pause pause_render ;
    private Body body ;
    private PolygonShape shape ;
    private World world  = new World(new Vector2(0,-30),true);
    private Texture PauseButtonTexture ;
    BodyDef bodyDef = new BodyDef();
    Body body2 ;
    Body body3 ;
    private FixtureDef fixtureDef = new FixtureDef() ;
    private FixtureDef fixture2 =new FixtureDef() ;
    private ShapeRenderer shapeRenderer;
    public Level4(Main main){
        this.main = main ;
        camera = new OrthographicCamera();
        map = new TmxMapLoader().load("LEVEL4.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera.setToOrtho(false, 1920, 1080);
        this.main = new Main();
        this.batch = new SpriteBatch();
        lostStage = new Stage(new ScreenViewport());
        winStage = new Stage(new ScreenViewport());
        //this.background = new Texture("Level3.png");
        this.elements = new Texture("libgdx.png");
        stage = new Stage(new ScreenViewport());
        pauseStage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        pause_render = new Pause(main ,map ,5);
        MenuButtonTexture = new Texture("Menu_button.png");
        retryButtonTexture = new Texture("Retry_button.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        Nextlevel = new Texture("Next_level_button.png");
        PauseButtonTexture = new Texture("pauseButton.png");
        backButtonTexture = new Texture("backButton.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        pause_render = new Pause(main ,map ,3);
        closeButton = new Texture("closeButton.png");

        ImageButton PauseButton = Button.createButton(PauseButtonTexture,stage,100,100,0,0);
        ImageButton QuitButton = Button.createButton(backButtonTexture,stage,100,100,0,Gdx.graphics.getHeight()-backButtonTexture.getHeight());
        ImageButton CloseButton1 = Button.createButton(closeButton,pauseStage,100,100,Gdx.graphics.getWidth()- closeButton.getWidth(),Gdx.graphics.getHeight()- closeButton.getHeight());
        ImageButton CloseButton2 = Button.createButton(closeButton,lostStage,100,100,Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());
        ImageButton LostMenuButton = Button.createButton(MenuButtonTexture,lostStage,280,120,1000,175);
        ImageButton RetryButton = Button.createButton(retryButtonTexture,lostStage,260,120,700,175);
        ImageButton Menubutton = Button.createButton(MenuButtonTexture,winStage,390,170,550 ,170);
        ImageButton Nextbutton = Button.createButton(Nextlevel,winStage,400,180,1000 ,70);


        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(391 ,590);
        body2 = world.createBody(bodyDef);
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(20);
        fixture2.shape = circleShape ;
        fixture2.density = 0.5f ;
        fixture2.friction = 0.5f ;
        fixture2.restitution = 0.5f ;
        body2.createFixture(fixture2);


        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle R2 = ((RectangleMapObject) object).getRectangle();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set(R2.x + R2.width/2 , R2.y + R2.height/2);
            body3 = world.createBody(bodyDef);

            shape = new PolygonShape();
            shape.setAsBox(R2.width/2, R2.height/2);
            fixtureDef.shape = shape;
            fixtureDef.density = 0.0f ;
            fixtureDef.friction = 0.5f ;
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
            //rectangles.add(new Rectangle(R1.x, R1.y, R1.width, R1.height));
        }

        PauseButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isPaused = true;
                Gdx.input.setInputProcessor(pauseStage);
            }
        });
        QuitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level_selector(main));
            }
        });
        CloseButton1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isPaused = false;
                Gdx.input.setInputProcessor(stage);
            }
        });
        CloseButton2.addListener(new ClickListener(){
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
//        Menubutton.addListener(new ClickListener(){
//
//                main.setScreen(new Completed_Level(main , 5));
//        });
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

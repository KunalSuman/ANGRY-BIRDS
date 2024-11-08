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
import io.github.KunalSuman.Angry_Bird.Completed_Level;
import io.github.KunalSuman.Angry_Bird.Main;
import io.github.KunalSuman.Angry_Bird.Pause;

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
    public Stage lostStage;
    public Texture retryTexture ;
    public Stage winStage;
    public Texture winTexture ;
    public Texture Nextlevel;
    public Texture MenuButtonTexture ;
    public Texture retryButtonTexture ;
    public int x  =0 ;
    public Pause pause_render;
    private Body body ;
    private PolygonShape shape ;
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer() ;
    private World world  = new World(new Vector2(0,-30),true);
    BodyDef bodyDef = new BodyDef();
    Body body2 ;
    Body body3 ;
    private float distance = 100.0f ;
    private FixtureDef fixtureDef = new FixtureDef() ;
    private FixtureDef fixture2 =new FixtureDef() ;
    private Texture Red_bird ;
    private ShapeRenderer shapeRenderer;
    public Level3(Main main) {
        this.main = new Main();
        pause =0;
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        pauseStage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        pauseButton = new Texture("pauseButton.png");
        backButtonTexture = new Texture("backButton.png");
        //this.background = new Texture("Level3.png");
        lostStage = new Stage(new ScreenViewport());
        winStage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        map = new TmxMapLoader().load("LEVEL3.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        MenuButtonTexture = new Texture("Menu_button.png");
        retryButtonTexture = new Texture("Retry_button.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        Nextlevel = new Texture("Next_level_button.png");
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

        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        pause_render = new Pause(main ,map ,3);

        closeButton = new Texture("closeButton.png");
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

        pauseStage.addActor(closeButton);
        //lostStage.addActor(retryButton);
        closeButton.setSize(100,100);
        closeButton.setPosition(Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());

        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(391 ,590);
        body2 = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(20);

        fixture2.shape = circleShape ;
        fixtureDef.density = 0.0f ;
        fixtureDef.friction = 0.5f ;
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
    }
    public void render(float delta){
        camera.update();
        renderer.setView(camera);
        renderer.render();
        batch.begin();
        Vector2 pos = body2.getPosition();
        if (Gdx.input.isKeyPressed(Input.Keys.W) && pos.y < 1080) {
            body2.setLinearVelocity(pos.x, pos.y + distance * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && pos.y > 0) {
            body2.setLinearVelocity(pos.x, pos.y + distance * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && pos.x > 0) {
            body2.setLinearVelocity(pos.x + distance* Gdx.graphics.getDeltaTime(), pos.y );
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && pos.x < 1920 ) {
            body2.setLinearVelocity(pos.x - distance* Gdx.graphics.getDeltaTime(), pos.y );
        }
        world.step(1/60f,6,2);
        if(x==1){
            stage.act(delta);
            stage.draw();
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
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            x =1 ;
            Gdx.input.setInputProcessor(lostStage);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            x =2 ;
            Gdx.input.setInputProcessor(winStage);
        }
        if(x==0){
            if (!isPaused){
                stage.act(delta);
                stage.draw();
            }
            if (isPaused){
                pause_render.render(delta);
//                pauseStage.act(delta);
//                pauseStage.getBatch().begin();
//                pauseStage.getBatch().draw(pauseTexture,(Gdx.graphics.getWidth()-pauseTexture.getWidth())/2f,(Gdx.graphics.getHeight()-pauseTexture.getHeight())/2f);
//                pauseStage.getBatch().end();
//                pauseStage.draw();
            }
        }
        batch.end();
        renderer.render(new int[]{3});
        debugRenderer.render(world,camera.combined);
//        batch.begin();
//        batch.draw(background, 0, 0);
//        batch.end();
    }
}

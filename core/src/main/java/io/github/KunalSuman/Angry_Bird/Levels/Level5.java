package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.*;
import io.github.KunalSuman.Angry_Bird.Birds.Red_bird;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Level5 extends ScreenAdapter {
    private  InputMultiplexer multiplexer = new InputMultiplexer();
    private InputAdapter birdAdapter;
    public Main main ;
    public SpriteBatch batch ;
    public Texture background;
    public Stage stage ;
    public Stage pauseStage;
    public TiledMap map;
    public Texture pauseTexture;
    private boolean isPaused = false;
    public Texture closeButton;
    public Texture pauseButton;
    public Texture backButtonTexture;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera ;
    public Stage lostStage;
    public Texture retryTexture ;;
    public Stage winStage;
    public Texture winTexture ;
    public Texture MenuButtonTexture ;
    public Texture Nextlevel ;
    public Texture retryButtonTexture;
    public int x = 0 ;
    public Pause pause_render;
    private Body body ;
    private PolygonShape shape ;
    private World world  = new World(new Vector2(0,-50),true);
    BodyDef bodyDef = new BodyDef();
    Body body2 ;
    Body body3 ;
    private FixtureDef fixtureDef = new FixtureDef() ;
    private FixtureDef fixture2 =new FixtureDef() ;
    private Texture Red_bird ;
    private ShapeRenderer shapeRenderer;
    //private
    public Array<Body> rectangles1 = new Array<>() ;
    public Properties properties ;
    private ArrayList<Vector2> pointsOfTrajectory=new ArrayList<>();
    private boolean isDragging = false;
    private Vector3 startPosition = new Vector3();
    private Vector3 endPosition =new Vector3();
    private Collison collisonListener = new Collison();
    private Texture PauseButtonTexture;
    private Body currentBody;
    Red_bird red;
    public static boolean hasSaveFile=false;
    private float timeLapsed=0;

    public Level5(Main main){
        this.main = new Main();
        this.batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        pauseStage = new Stage(new ScreenViewport());
        lostStage = new Stage(new ScreenViewport());
        winStage = new Stage(new ScreenViewport());
        pauseButton = new Texture("pauseButton.png");
        closeButton = new Texture("closeButton.png");
        MenuButtonTexture = new Texture("Menu_button.png");
        retryButtonTexture = new Texture("Retry_button.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        Nextlevel = new Texture("Next_level_button.png");
        PauseButtonTexture = new Texture("pauseButton.png");
        backButtonTexture = new Texture("backButton.png");
        map = new TmxMapLoader().load("LEVEL5.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();

        Gdx.input.setInputProcessor(stage);
        world.setContactListener(collisonListener);

        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        pause_render = new Pause(main ,map ,5,null,null,null,null,this);
        Red_bird = new Texture("Red.png");

        ImageButton PauseButton = Button.createButton(PauseButtonTexture,stage,100,100,0,0);
        ImageButton QuitButton = Button.createButton(backButtonTexture,stage,100,100,0,Gdx.graphics.getHeight()-backButtonTexture.getHeight());
        ImageButton CloseButton1 = Button.createButton(closeButton,pauseStage,100,100,Gdx.graphics.getWidth()- closeButton.getWidth(),Gdx.graphics.getHeight()- closeButton.getHeight());
        ImageButton CloseButton2 = Button.createButton(closeButton,lostStage,100,100,Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());
        ImageButton LostMenuButton = Button.createButton(MenuButtonTexture,lostStage,280,120,1000,175);
        ImageButton RetryButton = Button.createButton(retryButtonTexture,lostStage,260,120,700,175);
        ImageButton Menubutton = Button.createButton(MenuButtonTexture,winStage,390,170,550 ,170);
        ImageButton Nextbutton = Button.createButton(Nextlevel,winStage,400,180,1000 ,70);

        red = new Red_bird(body2,world,Red_bird,10,1,10,"LMAO",0);
        Properties birdProperties = new Properties (Red_bird,46,46,100,true);
        red.createBirdBody(bodyDef,BodyDef.BodyType.DynamicBody,335,695,birdProperties);


        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(20);

        fixture2.shape = circleShape ;
        fixture2.density = 0.15f ;
        fixture2.restitution = 0.5f ;
        red.createBirdFixture(fixture2,20);
        currentBody = red.getBirdBody();

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


        int objectId = 0;
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle R1 = ((RectangleMapObject) object).getRectangle();
            bodyDef.type = BodyDef.BodyType.DynamicBody;
            bodyDef.position.set(R1.x + R1.width/2, R1.y +R1.height/2);
            body = world.createBody(bodyDef);

            shape = new PolygonShape();
            shape.setAsBox(R1.width/2, R1.height/2);

            fixtureDef.shape = shape;
            fixtureDef.density = 0.05f;
            fixtureDef.friction = 0.5f ;
            fixtureDef.restitution = 0.5f;
            body.createFixture(fixtureDef).setUserData("Obstacles");
            Texture stone_long_vertical = new Texture("stone_long_vertical.png") ;
            Texture stone_medium_horizontal = new Texture("stone_medium_horizontal.png") ;
            Texture stone_long_horizontal = new Texture("stone_long_horizontal.png") ;
            Texture stone_small_vertical = new Texture("stone_small_vertical.png");
            Texture wood_small_horizontal = new Texture("wood_small_horizontal.png");
            Texture wood_long_horizontal = new Texture("wood_long_horizontal.png");
            Texture wood_long_vertical = new Texture("wood_long_vertical.png");
            Texture glass_small_vertical = new Texture("glass_small_vertical.png");
            Texture glass_long_horizontal = new Texture("glass_long_horizontal.png");
            Texture wood_box = new Texture("wood_box.png");
            Texture TNT = new Texture("TNT.png");
            if(object.getProperties().get("texture") == null){
                System.out.println("false");
            }
            if(object.getProperties().get("texture").equals("S_L_V" )){
                properties = new Properties(stone_long_vertical,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("S_M_H")) {
                properties = new Properties(stone_medium_horizontal,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("S_L_H")) {
                properties = new Properties(stone_long_horizontal,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("S_S_V")) {
                properties = new Properties(stone_small_vertical,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("W_S_H")) {
                properties = new Properties(wood_small_horizontal,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if(object.getProperties().get("texture").equals("W_S_V")){
                properties = new Properties(glass_small_vertical,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("G_L_H")) {
                properties = new Properties(glass_long_horizontal,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("G_S_V")) {
                properties = new Properties(glass_small_vertical,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("TNT")) {
                properties = new Properties(TNT,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("W_B")) {
                properties = new Properties(wood_box,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if(object.getProperties().get("texture").equals("W_L_V" )){
                properties = new Properties(wood_long_vertical,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            }
            else if(object.getProperties().get("texture").equals("W_L_H" )){
                properties = new Properties(wood_long_horizontal,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            }
            else {
                properties = new Properties(stone_long_horizontal,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            }

            rectangles1.add(body);
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
        birdAdapter =new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (button == Input.Buttons.LEFT){
                    startPosition.set(screenX,screenY,0);
                    camera.unproject(startPosition);

                    isDragging = true;
                    return true;


                }
                return false;

            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if (button == Input.Buttons.LEFT){
                    endPosition.set(screenX,screenY,0);
                    camera.unproject(endPosition);

                    //for applying force
                    float launchMultiplier = 5.5f;
                    double distance = Math.sqrt(((startPosition.x - endPosition.x) * (startPosition.x - endPosition.x)) + ((startPosition.y - endPosition.y) * (startPosition.y - endPosition.y)));
                    Vector2 launchDirection = new Vector2((float) (((startPosition.x - endPosition.x))*launchMultiplier), (float) (((startPosition.y - endPosition.y)) *launchMultiplier));
                    System.out.println(launchDirection.x);
                    System.out.println(launchDirection.y);
                    currentBody.setLinearVelocity(launchDirection);
                    //body2.applyLinearImpulse(launchDirection.scl((float) distance*100f), body2.getWorldCenter(), true);
                    pointsOfTrajectory.clear();
                    isDragging = false;
                    multiplexer.removeProcessor(this);

                    return true;

                }
                return false;
            }
            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                if (isDragging){
                    endPosition.set(screenX,screenY,0);
                    camera.unproject(endPosition);



//                    Vector2 currentPosition = new Vector2(endPosition.x,endPosition.y);
//                    if (currentPosition.x>-100 && currentPosition.y>-100) {
//                        body2.setTransform(currentPosition, body2.getAngle());
//                    }

                    Vector2 launchDirection = new Vector2(startPosition.x-endPosition.x, startPosition.y-endPosition.y);
                    double distance = Math.sqrt(((startPosition.x-endPosition.x)*(startPosition.x-endPosition.x))+((startPosition.y-endPosition.y)*(startPosition.y-endPosition.y)));
                    Vector2 calculatedLinearVelocity=currentBody.getLinearVelocity().cpy().add(launchDirection.scl((float) distance*10f).scl(1/currentBody.getMass()));
                    calculatePath(pointsOfTrajectory,startPosition,calculatedLinearVelocity);
                    return true;
                }
                return false;
            }
        };

        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(birdAdapter);
        Gdx.input.setInputProcessor(multiplexer);
    }
    public Level5(Main main,GameSaver g1){
        this.main = new Main();
        this.batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        pauseStage = new Stage(new ScreenViewport());
        lostStage = new Stage(new ScreenViewport());
        winStage = new Stage(new ScreenViewport());
        pauseButton = new Texture("pauseButton.png");
        closeButton = new Texture("closeButton.png");
        MenuButtonTexture = new Texture("Menu_button.png");
        retryButtonTexture = new Texture("Retry_button.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        Nextlevel = new Texture("Next_level_button.png");
        PauseButtonTexture = new Texture("pauseButton.png");
        backButtonTexture = new Texture("backButton.png");
        map = new TmxMapLoader().load("Level5.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();

        Gdx.input.setInputProcessor(stage);
        world.setContactListener(collisonListener);

        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        pause_render = new Pause(main ,map ,5,null,null,null,null,this);
        Red_bird = new Texture("Red.png");

        ImageButton PauseButton = Button.createButton(PauseButtonTexture,stage,100,100,0,0);
        ImageButton QuitButton = Button.createButton(backButtonTexture,stage,100,100,0,Gdx.graphics.getHeight()-backButtonTexture.getHeight());
        ImageButton CloseButton1 = Button.createButton(closeButton,pauseStage,100,100,Gdx.graphics.getWidth()- closeButton.getWidth(),Gdx.graphics.getHeight()- closeButton.getHeight());
        ImageButton CloseButton2 = Button.createButton(closeButton,lostStage,100,100,Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());
        ImageButton LostMenuButton = Button.createButton(MenuButtonTexture,lostStage,280,120,1000,175);
        ImageButton RetryButton = Button.createButton(retryButtonTexture,lostStage,260,120,700,175);
        ImageButton Menubutton = Button.createButton(MenuButtonTexture,winStage,390,170,550 ,170);
        ImageButton Nextbutton = Button.createButton(Nextlevel,winStage,400,180,1000 ,70);

        red = new Red_bird(body2,world,Red_bird,10,1,10,"LMAO",0);
        Properties birdProperties = new Properties (Red_bird,46,46,g1.birdHealth,true);
        red.createBirdBody(bodyDef,BodyDef.BodyType.DynamicBody,g1.birdPositionX,g1.birdPositionY,birdProperties);



        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(20);

        fixture2.shape = circleShape ;
        fixture2.density = 0.15f ;
        fixture2.restitution = 0.5f ;
        red.createBirdFixture(fixture2,20);
        currentBody = red.getBirdBody();

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


        int objectId = -1;
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            int oid2=objectId+1;
            if (g1.p1.containsKey(oid2)) {
                Rectangle R1 = ((RectangleMapObject) object).getRectangle();
                bodyDef.type = BodyDef.BodyType.DynamicBody;
                bodyDef.position.set(g1.objectPositionsX.get(oid2) , g1.objectPositionsY.get(oid2));
                body = world.createBody(bodyDef);

                shape = new PolygonShape();
                shape.setAsBox(R1.width / 2, R1.height / 2);

                fixtureDef.shape = shape;
                fixtureDef.density = 0.05f;
                fixtureDef.friction = 0.5f;
                fixtureDef.restitution = 0.5f;
                body.createFixture(fixtureDef).setUserData("Obstacles");
            }
            Texture stone_long_vertical = new Texture("stone_long_vertical.png") ;
            Texture stone_medium_horizontal = new Texture("stone_medium_horizontal.png") ;
            Texture stone_long_horizontal = new Texture("stone_long_horizontal.png") ;
            Texture stone_small_vertical = new Texture("stone_small_vertical.png");
            Texture wood_small_horizontal = new Texture("wood_small_horizontal.png");
            Texture wood_long_horizontal = new Texture("wood_long_horizontal.png");
            Texture wood_long_vertical = new Texture("wood_long_vertical.png");
            Texture glass_small_vertical = new Texture("glass_small_vertical.png");
            Texture glass_long_horizontal = new Texture("glass_long_horizontal.png");
            Texture wood_box = new Texture("wood_box.png");
            Texture TNT = new Texture("TNT.png");
            if(object.getProperties().get("texture") == null){
                System.out.println("false");
            }
            if(object.getProperties().get("texture").equals("S_L_V" )){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_long_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            }
            else if (object.getProperties().get("texture").equals("S_M_H")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_medium_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if (object.getProperties().get("texture").equals("S_L_H")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_long_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if (object.getProperties().get("texture").equals("S_S_V")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_small_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if (object.getProperties().get("texture").equals("W_S_H")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(wood_small_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if(object.getProperties().get("texture").equals("W_S_V")){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(glass_small_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if (object.getProperties().get("texture").equals("G_L_H")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(glass_long_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if (object.getProperties().get("texture").equals("G_S_V")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(glass_small_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if (object.getProperties().get("texture").equals("TNT")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(TNT,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if (object.getProperties().get("texture").equals("W_B")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(wood_box,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            } else if(object.getProperties().get("texture").equals("W_L_V" )){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(wood_long_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            }
            else if(object.getProperties().get("texture").equals("W_L_H" )){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(wood_long_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            }
            else {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_long_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                }
            }
            if (g1.p1.containsKey(objectId)) {
                rectangles1.add(body);
                System.out.println(g1.p1.get(objectId).objectId);
            }

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
        birdAdapter =new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (button == Input.Buttons.LEFT){
                    startPosition.set(screenX,screenY,0);
                    camera.unproject(startPosition);

                    isDragging = true;
                    return true;


                }
                return false;

            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if (button == Input.Buttons.LEFT){
                    endPosition.set(screenX,screenY,0);
                    camera.unproject(endPosition);

                    //for applying force
                    float launchMultiplier = 10.5f;
                    double distance = Math.sqrt(((startPosition.x - endPosition.x) * (startPosition.x - endPosition.x)) + ((startPosition.y - endPosition.y) * (startPosition.y - endPosition.y)));
                    Vector2 launchDirection = new Vector2((float) (((startPosition.x - endPosition.x))*launchMultiplier), (float) (((startPosition.y - endPosition.y)) *launchMultiplier));
                    System.out.println(launchDirection.x);
                    System.out.println(launchDirection.y);
                    currentBody.setLinearVelocity(launchDirection);
                    //body2.applyLinearImpulse(launchDirection.scl((float) distance*100f), body2.getWorldCenter(), true);
                    pointsOfTrajectory.clear();
                    isDragging = false;
                    multiplexer.removeProcessor(this);

                    return true;

                }
                return false;
            }
            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                if (isDragging){
                    endPosition.set(screenX,screenY,0);
                    camera.unproject(endPosition);



//                    Vector2 currentPosition = new Vector2(endPosition.x,endPosition.y);
//                    if (currentPosition.x>-100 && currentPosition.y>-100) {
//                        body2.setTransform(currentPosition, body2.getAngle());
//                    }

                    Vector2 launchDirection = new Vector2(startPosition.x-endPosition.x, startPosition.y-endPosition.y);
                    double distance = Math.sqrt(((startPosition.x-endPosition.x)*(startPosition.x-endPosition.x))+((startPosition.y-endPosition.y)*(startPosition.y-endPosition.y)));
                    Vector2 calculatedLinearVelocity=currentBody.getLinearVelocity().cpy().add(launchDirection.scl((float) distance*10f).scl(1/currentBody.getMass()));
                    calculatePath(pointsOfTrajectory,startPosition,calculatedLinearVelocity);
                    return true;
                }
                return false;
            }
        };

        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(birdAdapter);
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void render(float delta) {

        camera.update();
        renderer.setView(camera);
        renderer.render();

        if (!isPaused) {
            Gdx.input.setInputProcessor(multiplexer);
            stage.act(delta);
            stage.draw();
            timeLapsed+=delta;
            world.step(1/120f,12,4);
        }
        if (isPaused) {
            //Gdx.input.setInputProcessor(pauseStage);
            pause_render.render(delta);
//                pauseStage.act(delta);
//                pauseStage.getBatch().begin();
//                pauseStage.getBatch().draw(pauseTexture, (Gdx.graphics.getWidth() - pauseTexture.getWidth()) / 2f, (Gdx.graphics.getHeight() - pauseTexture.getHeight()) / 2f);
//                pauseStage.getBatch().end();
//                pauseStage.draw();
            return;
        }

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.setProjectionMatrix(camera.combined);
        for (Vector2 p: pointsOfTrajectory){
            shapeRenderer.circle(p.x, p.y, 5);
        }
        shapeRenderer.end();

        Vector2 pos = red.getPosition();
        world.step(1/120f,12,4);
        renderer.render(new int[]{3});
        batch.begin();

        for (Body b: collisonListener.getBodiesToRemove()){
            if (b!=null) {
                world.destroyBody(b);
                rectangles1.removeValue(b,true);
            }
        }
        collisonListener.getBodiesToRemove().clear();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.getBatch().setProjectionMatrix(camera.combined);
        stage.getBatch().begin();
        stage.getBatch().draw(Red_bird , pos.x-23 ,pos.y-23 , 46 , 46);
        for(Body body : rectangles1){
            Properties properties1 = (Properties) body.getUserData();
            stage.getBatch().draw(properties1.texture, body.getPosition().x -properties1.width/2, body.getPosition().y-properties1.height/2, properties1.width/2 ,properties1.height/2 ,properties1.width ,properties1.height,1.0f ,1.0f, (float) Math.toDegrees(body.getAngle()));
        }
        stage.getBatch().end();
        stage.draw();
        batch.end();



        //debugRenderer.render(world,camera.combined);
    }
    public void calculatePath(ArrayList<Vector2> pointsOfTrajectory, Vector3 startPosition, Vector2 Velocity){
        pointsOfTrajectory.clear();
        for (int i=0;i<=10;i++){
            if (Velocity.x<200 && Velocity.x>-200 && Velocity.y<200 && Velocity.y>-200) {
                float simulatedTime = i * 0.3f;
                float x = startPosition.x + Velocity.x * simulatedTime / 2;
                float y = startPosition.y + Velocity.y * simulatedTime / 2 - 0.5f * simulatedTime * simulatedTime * 9.8f;
                pointsOfTrajectory.add(new Vector2(x, y));
            }else{
                float simulatedTime = i * 0.3f;
                float directionModulus = (float) Math.sqrt((Velocity.x*Velocity.x)+(Velocity.y*Velocity.y));
                float x = startPosition.x + (Velocity.x/directionModulus)*200 * simulatedTime;
                float y = startPosition.y + (Velocity.y/directionModulus)*200 * simulatedTime  - 0.5f * simulatedTime * simulatedTime * 9.8f;
                pointsOfTrajectory.add(new Vector2(x, y));
            }
        }
    }

    public void saveGame() throws IOException {
        int score = 0;
        float birdPositionX = currentBody.getPosition().x;
        float birdPositionY = currentBody.getPosition().y;
        savedGamesList s = new savedGamesList();
        s.setLevel5();
        Properties redProperty = (Properties) red.getBirdBody().getUserData();
        int currentBird = 0;
        HashMap<Integer,Float> objectPositionsX = new HashMap<>();
        HashMap<Integer,Float> objectPositionsY = new HashMap<>();
        HashMap<Integer,Properties> properties = new HashMap<>();
        for (Body b: rectangles1){
            Properties p = (Properties) b.getUserData();
            objectPositionsX.put(p.objectId,b.getPosition().x);
            objectPositionsY.put(p.objectId,b.getPosition().y);
            properties.put(p.objectId,p);
            System.out.println(properties.get(p.objectId).objectId);
        }
        GameSaver g1 = new GameSaver(score,birdPositionX,birdPositionY,(int)redProperty.health,currentBird,objectPositionsX,objectPositionsY,properties);
        g1.saveGame();
        s.saveArray();
        GameSaver.level5Saved=true;

    }
    public static Level5 loadGame(Main main) throws IOException, ClassNotFoundException {
        GameSaver g1;
        FileInputStream fileIn = new FileInputStream("SaveData.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        g1 = (GameSaver) in.readObject();
        in.close();
        fileIn.close();
        Level5 l2=new Level5(main,g1);
        System.out.println(g1.birdPositionX);

        return l2;
    }

    public void setPauseStageTrue() {
        isPaused = false;
    }
}

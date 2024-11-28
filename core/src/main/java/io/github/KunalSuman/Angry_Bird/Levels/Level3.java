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
import io.github.KunalSuman.Angry_Bird.Birds.Birds;
import io.github.KunalSuman.Angry_Bird.Birds.Red_bird;
import io.github.KunalSuman.Angry_Bird.Create_Bodies.*;
import io.github.KunalSuman.Angry_Bird.Create_body_Seralize.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Level3 extends ScreenAdapter {
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
    public Texture retryTexture ;
    public Stage winStage;
    public Texture winTexture ;
    public Texture MenuButtonTexture ;
    public Texture Nextlevel ;
    public Texture retryButtonTexture;
    public int x = 0 ;
    public boolean gameCompleted = false;
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
    private Texture king_pig ;
    private Texture small_pig ;
    private Texture helmet_pig ;
    private Body pig_body ;
    private BodyDef pig_body_def = new BodyDef() ;
    private FixtureDef pig_fixture_def = new FixtureDef() ;
    private PolygonShape pig_shape;
    public ArrayList<Body> pigs_array = new ArrayList<>();
    public Body body4 ;
    public Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    public ArrayList<Body> birds_array = new ArrayList<>();
    public int currentBird=0;
    public int CBI = 0 ;
    public boolean BL = false ;
    public float TSL = 0;
    int count_bids0 = 0 ;
    public Texture empty ;
    public Level3(Main main){
        this.main = main;
        this.batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        pauseStage = new Stage(new ScreenViewport());
        lostStage = new Stage(new ScreenViewport());
        winStage = new Stage(new ScreenViewport());
        king_pig = new Texture("king_pig.png");
        small_pig = new Texture("small_pig.png");
        helmet_pig = new Texture("helmet_pig.png");
        pauseButton = new Texture("pauseButton.png");
        closeButton = new Texture("closeButton.png");
        MenuButtonTexture = new Texture("Menu_button.png");
        retryButtonTexture = new Texture("Retry_button.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        Nextlevel = new Texture("Next_level_button.png");
        PauseButtonTexture = new Texture("pauseButton.png");
        backButtonTexture = new Texture("backButton.png");
        map = new TmxMapLoader().load("LEVEL3.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();

        Gdx.input.setInputProcessor(stage);
        world.setContactListener(collisonListener);

        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        pause_render = new Pause(main ,map ,3,null,null,this,null,null);
        Red_bird = new Texture("Red.png");
        empty = new Texture("empty_png.png");

        ImageButton PauseButton = Button.createButton(PauseButtonTexture,stage,100,100,0,0);
        ImageButton QuitButton = Button.createButton(backButtonTexture,stage,100,100,0,Gdx.graphics.getHeight()-backButtonTexture.getHeight());
        ImageButton CloseButton1 = Button.createButton(closeButton,pauseStage,100,100,Gdx.graphics.getWidth()- closeButton.getWidth(),Gdx.graphics.getHeight()- closeButton.getHeight());
        ImageButton CloseButton2 = Button.createButton(closeButton,lostStage,100,100,Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());
        ImageButton LostMenuButton = Button.createButton(MenuButtonTexture,lostStage,280,120,1000,175);
        ImageButton RetryButton = Button.createButton(retryButtonTexture,lostStage,260,120,700,175);
        ImageButton Menubutton = Button.createButton(MenuButtonTexture,winStage,390,170,550 ,170);
        ImageButton Nextbutton = Button.createButton(Nextlevel,winStage,400,180,1000 ,70);

        Birds_body B1 = new Birds_body(world,500,650);
        birds_array = B1.return_array();
        Structure_body STB1 = new Structure_body(world , map);
        rectangles1 = STB1.return_array();
        Pigs_body PB1 = new Pigs_body(world,map);
        pigs_array= PB1.getPigs_array();

        Border_body BB1 = new Border_body(world,map);
        Objects_body OB1 = new Objects_body(world,map);

        if (!birds_array.isEmpty()) {
            body2 = birds_array.get(0);
        }
        if(!rectangles1.isEmpty()){
            body = birds_array.get(0);
        }
        if(!pigs_array.isEmpty()){
            pig_body = pigs_array.get(0);
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
                main.setScreen(new Completed_Level(main , 3));
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
                    System.out.println(CBI);
                    Body CB = birds_array.get(CBI);
                    CB.setLinearVelocity(launchDirection);

                    BL = true ;
                    //body2.applyLinearImpulse(launchDirection.scl((float) distance*100f), body2.getWorldCenter(), true);
                    pointsOfTrajectory.clear();
                    isDragging = false;
                    multiplexer.removeProcessor(this);
                    TSL = 0 ;
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
                    Vector2 calculatedLinearVelocity=birds_array.get(0).getLinearVelocity().cpy().add(launchDirection.scl((float) distance*10f).scl(1/birds_array.get(0).getMass()));
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
    public Level3(Main main,GameSaver g1,boolean isComplete){
        this.main = main;
        this.gameCompleted = isComplete;
        if(!isComplete) {
            this.batch = new SpriteBatch();
            stage = new Stage(new ScreenViewport());
            pauseStage = new Stage(new ScreenViewport());
            lostStage = new Stage(new ScreenViewport());
            winStage = new Stage(new ScreenViewport());
            king_pig = new Texture("king_pig.png");
            small_pig = new Texture("small_pig.png");
            helmet_pig = new Texture("helmet_pig.png");
            pauseButton = new Texture("pauseButton.png");
            closeButton = new Texture("closeButton.png");
            MenuButtonTexture = new Texture("Menu_button.png");
            retryButtonTexture = new Texture("Retry_button.png");
            retryTexture = new Texture("Level_failed.png");
            winTexture = new Texture("Level_complete.png");
            Nextlevel = new Texture("Next_level_button.png");
            PauseButtonTexture = new Texture("pauseButton.png");
            backButtonTexture = new Texture("backButton.png");
            map = new TmxMapLoader().load("LEVEL3.tmx");
            renderer = new OrthogonalTiledMapRenderer(map);
            camera = new OrthographicCamera();
            camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            shapeRenderer = new ShapeRenderer();

            Gdx.input.setInputProcessor(stage);
            world.setContactListener(collisonListener);

            retryTexture = new Texture("Level_failed.png");
            winTexture = new Texture("Level_complete.png");
            pause_render = new Pause(main, map, 3, null, null, this, null, null);
            Red_bird = new Texture("Red.png");
            empty = new Texture("empty_png.png");

            ImageButton PauseButton = Button.createButton(PauseButtonTexture, stage, 100, 100, 0, 0);
            ImageButton QuitButton = Button.createButton(backButtonTexture, stage, 100, 100, 0, Gdx.graphics.getHeight() - backButtonTexture.getHeight());
            ImageButton CloseButton1 = Button.createButton(closeButton, pauseStage, 100, 100, Gdx.graphics.getWidth() - closeButton.getWidth(), Gdx.graphics.getHeight() - closeButton.getHeight());
            ImageButton CloseButton2 = Button.createButton(closeButton, lostStage, 100, 100, Gdx.graphics.getWidth() - closeButton.getWidth(), Gdx.graphics.getHeight() - closeButton.getHeight());
            ImageButton LostMenuButton = Button.createButton(MenuButtonTexture, lostStage, 280, 120, 1000, 175);
            ImageButton RetryButton = Button.createButton(retryButtonTexture, lostStage, 260, 120, 700, 175);
            ImageButton Menubutton = Button.createButton(MenuButtonTexture, winStage, 390, 170, 550, 170);
            ImageButton Nextbutton = Button.createButton(Nextlevel, winStage, 400, 180, 1000, 70);

            Structure_body_serilizable S1 = new Structure_body_serilizable(world, map, g1);
            Border_body_serilizable BBS1 = new Border_body_serilizable(world, map, g1);
            Bird_body_serilizable BBS = new Bird_body_serilizable(world, g1);
            birds_array = BBS.getBirds_array();
            Object_body_seiralize OBS1 = new Object_body_seiralize(world, map, g1);
            rectangles1 = OBS1.return_array();
            Pigs_body_serilizable PBS1 = new Pigs_body_serilizable(world, map, g1);
            pigs_array = PBS1.getPigs_array();
            if (!birds_array.isEmpty()) {
                body2 = birds_array.get(0);
            }
            if (!rectangles1.isEmpty()) {
                body = birds_array.get(0);
            }
            if (!pigs_array.isEmpty()) {
                pig_body = pigs_array.get(0);
            }
            PauseButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    isPaused = true;
                    Gdx.input.setInputProcessor(pauseStage);
                }
            });
            QuitButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    main.setScreen(new Level_selector(main));
                }
            });
            CloseButton1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    isPaused = false;
                    Gdx.input.setInputProcessor(stage);
                }
            });
            CloseButton2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    isPaused = false;
                    Gdx.input.setInputProcessor(stage);
                }
            });

            Menubutton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    main.setScreen(new Level_selector(main));
                }
            });
            Nextbutton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    main.setScreen(new Completed_Level(main, 3));
                }
            });
            pauseTexture = new Texture("Pause_menu.png");
            birdAdapter = new InputAdapter() {
                @Override
                public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                    if (button == Input.Buttons.LEFT) {
                        startPosition.set(screenX, screenY, 0);
                        camera.unproject(startPosition);
                        isDragging = true;
                        return true;
                    }
                    return false;

                }

                @Override
                public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                    if (button == Input.Buttons.LEFT) {
                        endPosition.set(screenX, screenY, 0);
                        camera.unproject(endPosition);
                        float launchMultiplier = 5.5f;
                        double distance = Math.sqrt(((startPosition.x - endPosition.x) * (startPosition.x - endPosition.x)) + ((startPosition.y - endPosition.y) * (startPosition.y - endPosition.y)));
                        Vector2 launchDirection = new Vector2((float) (((startPosition.x - endPosition.x)) * launchMultiplier), (float) (((startPosition.y - endPosition.y)) * launchMultiplier));
                        System.out.println(launchDirection.x);
                        System.out.println(launchDirection.y);
                        System.out.println(CBI);
                        Body CB = birds_array.get(CBI);
                        CB.setLinearVelocity(launchDirection);
                        BL = true;
                        pointsOfTrajectory.clear();
                        isDragging = false;
                        multiplexer.removeProcessor(this);
                        TSL = 0;
                        return true;
                    }
                    return false;
                }

                @Override
                public boolean touchDragged(int screenX, int screenY, int pointer) {
                    if (isDragging) {
                        endPosition.set(screenX, screenY, 0);
                        camera.unproject(endPosition);
                        Vector2 launchDirection = new Vector2(startPosition.x - endPosition.x, startPosition.y - endPosition.y);
                        double distance = Math.sqrt(((startPosition.x - endPosition.x) * (startPosition.x - endPosition.x)) + ((startPosition.y - endPosition.y) * (startPosition.y - endPosition.y)));
                        Vector2 calculatedLinearVelocity = birds_array.get(0).getLinearVelocity().cpy().add(launchDirection.scl((float) distance * 10f).scl(1 / birds_array.get(0).getMass()));
                        calculatePath(pointsOfTrajectory, startPosition, calculatedLinearVelocity);
                        return true;
                    }
                    return false;
                }
            };
            multiplexer.addProcessor(stage);
            multiplexer.addProcessor(birdAdapter);
            Gdx.input.setInputProcessor(multiplexer);
        }else{
            main.setScreen(new Completed_Level(main, 3));
        }
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
            pause_render.render(delta);
            return;
        }

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.setProjectionMatrix(camera.combined);
        for (Vector2 p: pointsOfTrajectory){
            shapeRenderer.circle(p.x, p.y, 5);
        }
        shapeRenderer.end();
        ShapeRenderer shapeRenderer2 = new ShapeRenderer();
        shapeRenderer2.end();
        Vector2 pos = body2.getPosition();
        world.step(1/120f,12,4);
        renderer.render(new int[]{3});
        batch.begin();

        for (Body b: collisonListener.getBodiesToRemove()){
            if (b!=null) {
                if (rectangles1.contains(b,true)) {
                    world.destroyBody(b);
                    rectangles1.removeValue(b, true);
                }

            }if (b!=null){
                if (pigs_array.contains(b)) {
                    world.destroyBody(b);
                    pigs_array.remove(b);
                }
            }if(b!= null){
                if(birds_array.contains(b)){
                    world.destroyBody(b);
                    birds_array.remove(b);
                    CBI++;
                    count_bids0 ++ ;
                    BL = false ;
                    if(CBI < birds_array.size()){
                        Body NB = birds_array.get(CBI);

                        NB.setActive(true);
                        multiplexer.addProcessor(birdAdapter);
                    }else{
                        if (pigs_array.isEmpty()){
                            main.setScreen(new Completed_Level(main,3));
                            gameCompleted = true;
                            try {
                                this.saveGame();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            main.setScreen(new LostLevel(main,3));
                        }
                    }
                }
            }
        }
        collisonListener.getBodiesToRemove().clear();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.getBatch().setProjectionMatrix(camera.combined);
        stage.getBatch().begin();
        //stage.getBatch().draw(Red_bird , pos.x-23 ,pos.y-23 , 46 , 46);
        for(Body body : rectangles1){
            Properties properties1 = (Properties) body.getUserData();
            stage.getBatch().draw(properties1.texture, body.getPosition().x -properties1.width/2, body.getPosition().y-properties1.height/2, properties1.width/2 ,properties1.height/2 ,properties1.width ,properties1.height,1.0f ,1.0f, (float) Math.toDegrees(body.getAngle()));
        }
        for (Body body : pigs_array) {
            Properties pigg = (Properties) body.getUserData();
            stage.getBatch().draw(pigg.texture, body.getPosition().x - pigg.width / 2, body.getPosition().y - pigg.height / 2, pigg.width / 2, pigg.height / 2, pigg.width, pigg.height, 1.0f, 1.0f, (float) Math.toDegrees(body.getAngle()));

        }
        if(pigs_array.isEmpty()){
            main.setScreen(new Completed_Level(main,3));
            gameCompleted = true;
        }
        if(birds_array.isEmpty()){
            if (pigs_array.isEmpty()){
                main.setScreen(new Completed_Level(main,3));
            }
            else {
                main.setScreen(new LostLevel(main,3));
            }
        }
        else{
            int counter_pig = 0 ;
            for(Body body2 : birds_array){
                Properties bird = (Properties) body2.getUserData();
                stage.getBatch().draw(bird.texture,body2.getPosition().x-bird.width/2,body2.getPosition().y-bird.width/2,bird.width,bird.height,50,50,1.0f,1.0f,(float) Math.toDegrees(body2.getAngle()));
            }
        }
        stage.getBatch().end();
        stage.draw();
        batch.end();
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
        ArrayList<Float> birdPositionX = new ArrayList<>();
        ArrayList<Float> birdPositionY = new ArrayList<>();
        ArrayList<Float> birdSpeedX = new ArrayList<>();
        ArrayList<Float> birdSpeedY = new ArrayList<>();
        HashMap<Integer,Float> piggyPositionX = new HashMap<>();
        HashMap<Integer,Float> piggyPositionY = new HashMap<>();
        ArrayList<Integer> birdHealth = new ArrayList<>();
        HashMap<Integer,Properties> propertiesPiggies = new HashMap<>();
        HashMap<Integer,ArrayList<Float>> piggySpeed = new HashMap<>();
        HashMap<Integer,Integer> piggyHealth = new HashMap<>();
        Properties redProperty;
        for (Body b: birds_array){
            birdPositionY.add(b.getPosition().y);
            birdPositionX.add(b.getPosition().x);
            birdSpeedX.add(b.getLinearVelocity().x);
            birdSpeedY.add(b.getLinearVelocity().y);
            redProperty = (Properties) b.getUserData();
            birdHealth.add(redProperty.health);
        }
        for (Body b : pigs_array){
            Properties pigProperty = (Properties) b.getUserData();
            int oid = pigProperty.objectId;
            piggyHealth.put(oid,pigProperty.health);
            System.out.println(piggyHealth.get(oid)+"mmmvhfuyfk");
            ArrayList<Float> speed = new ArrayList<>();
            speed.add(b.getLinearVelocity().x);
            speed.add(b.getLinearVelocity().y);

            piggyPositionX.put(oid, b.getPosition().x);
            piggyPositionY.put(oid, b.getPosition().y);
            propertiesPiggies.put(oid, pigProperty);
            piggySpeed.put(oid, speed);
        }
        savedGamesList s = new savedGamesList();
        s.setLevel3();
        int currentBird = 0;
        HashMap<Integer,Float> objectPositionsX = new HashMap<>();
        HashMap<Integer,Float> objectPositionsY = new HashMap<>();
        HashMap<Integer,Properties> properties = new HashMap<>();
        HashMap<Integer,ArrayList<Float>> objectSpeed = new HashMap<>();
        for (Body b: rectangles1){
            Properties p = (Properties) b.getUserData();
            ArrayList<Float> speed = new ArrayList<>();
            speed.add(b.getLinearVelocity().x);
            speed.add(b.getLinearVelocity().y);
            objectPositionsX.put(p.objectId,b.getPosition().x);
            objectPositionsY.put(p.objectId,b.getPosition().y);
            properties.put(p.objectId,p);
            objectSpeed.put(p.objectId,speed);
        }
        GameSaver g1 = new GameSaver(score,piggyHealth,birdSpeedX,birdSpeedY,birdPositionX,birdPositionY,piggySpeed,objectSpeed,piggyPositionX,piggyPositionY,birdHealth,currentBird,objectPositionsX,objectPositionsY,properties,propertiesPiggies,3,gameCompleted);
        g1.saveGame();
        s.saveArray();
        GameSaver.level3Saved=true;
    }
    public static Level3 loadGame(Main main) throws IOException, ClassNotFoundException {
        GameSaver g1;
        savedGamesList s1;
        FileInputStream fileIn = new FileInputStream("SaveData3.ser");
        FileInputStream fileIn2 = new FileInputStream("SaveArray.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        g1 = (GameSaver) in.readObject();
        in.close();
        fileIn.close();
        Level3 l2=new Level3(main,g1, g1.gameCompleted);
        return l2;
    }
    public void setPauseStageTrue() {
        isPaused = false;
    }
}

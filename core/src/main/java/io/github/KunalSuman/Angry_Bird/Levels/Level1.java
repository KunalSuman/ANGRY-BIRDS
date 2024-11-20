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
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.*;
import io.github.KunalSuman.Angry_Bird.Birds.Red_bird;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Level1 extends ScreenAdapter implements Serializable {
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
    public Texture pauseButtonTexture;
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
    private World world  = new World(new Vector2(0,-50),true);
    BodyDef bodyDef = new BodyDef();
    Body body2 ;
    Body body3 ;
    private float multiplyer = 1000.0f ;
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
    private float timeLapsed=0;
    boolean bird1done=false;
    Body currentBird;
    InputAdapter birdAdapter;


    public static GameSaver g1;


    InputMultiplexer multiplexer = new InputMultiplexer();
    ShapeRenderer shapeRenderer2 = new ShapeRenderer();
    Body body4;
    Red_bird secondBird;
    //    private ArrayList<Body> rectangles = new ArrayList<Body>();
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
        pauseButtonTexture = new Texture("pauseButton.png");
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
        shapeRenderer = new ShapeRenderer();

        world.setContactListener(collisonListener);


        ImageButton pauseButton = Button.createButton(pauseButtonTexture,stage,100,100,0,0);
        backButtonTexture = new Texture("backButton.png");
        ImageButton backButton = Button.createButton(backButtonTexture,stage,100,100,0,Gdx.graphics.getHeight()-backButtonTexture.getHeight());


        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        pause_render = new Pause(main ,map ,1,this, null,null,null,null);
        Red_bird = new Texture("Red.png");
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
        ImageButton Menubutton = Button.createButton(MenuButtonTexture,winStage,390,170,550 ,170);

        ImageButton Nextbutton = Button.createButton(Nextlevel,winStage,400,180,1000 ,70);


//        pauseStage.addActor(closeButton);
//        //lostStage.addActor(retryButton);
//        closeButton.setSize(100,100);
//        closeButton.setPosition(Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());

        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(325 ,690);
        Properties propertyBird= new Properties(Red_bird,46,46,100);
        body2 = world.createBody(bodyDef);
        body2.setUserData(propertyBird);
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(20);

        fixture2.shape = circleShape ;
        fixture2.density = 0.0005f ;
        fixture2.restitution = 0.4f ;

        body2.createFixture(fixture2).setUserData("Bird");
        currentBird = body2;
        Properties propertyBird2= new Properties(Red_bird,46,46,100);
        secondBird = new Red_bird(body4,world,Red_bird,10,1,1,"Gigachad",0);
        secondBird.createBirdBody(bodyDef,bodyDef.type,225 ,690,propertyBird2);
        secondBird.createBirdFixture(fixture2,20);


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
            fixtureDef.density = 0.00005f;
            fixtureDef.friction = 0.5f ;
            fixtureDef.restitution = 0.8f;
            body.createFixture(fixtureDef).setUserData("Obstacles");
            Texture stone_long_vertical = new Texture("stone_long_vertical.png") ;
            Texture stone_medium_horizontal = new Texture("stone_medium_horizontal.png") ;
            Texture stone_long_horizontal = new Texture("stone_long_horizontal.png") ;
            Texture stone_small_vertical = new Texture("stone_small_vertical.png");
            Texture wood_small_horizontal = new Texture("wood_small_horizontal.png");
            Texture glass_small_vertical = new Texture("glass_small_vertical.png");
            Texture glass_long_horizontal = new Texture("glass_long_horizontal.png");
            Texture wood_box = new Texture("wood_box.png");
            Texture TNT = new Texture("TNT.png");
            if(object.getProperties().get("texture") == null){
                System.out.println("false");
            }
            if(object.getProperties().get("texture").equals("S_L_V" )){
                properties = new Properties(stone_long_vertical,R1.height,R1.width,30);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("S_M_H")) {
                properties = new Properties(stone_medium_horizontal,R1.height,R1.width,30);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("S_L_H")) {
                properties = new Properties(stone_long_horizontal,R1.height,R1.width,30);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("S_S_V")) {
                properties = new Properties(stone_small_vertical,R1.height,R1.width,30);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("W_S_H")) {
                properties = new Properties(wood_small_horizontal,R1.height,R1.width,20);
                body.setUserData(properties);
            }
            else if(object.getProperties().get("texture").equals("W_S_V")){
                properties = new Properties(glass_small_vertical,R1.height,R1.width,20);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("G_L_H")) {
                properties = new Properties(glass_long_horizontal,R1.height,R1.width,10);
                body.setUserData(properties);

            } else if (object.getProperties().get("texture").equals("G_S_V")) {
                properties = new Properties(glass_small_vertical,R1.height,R1.width,10);
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("TNT")) {
                properties = new Properties(TNT,R1.height,R1.width,10);
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("W_B")) {
                properties = new Properties(wood_box,R1.height,R1.width,10);
                body.setUserData(properties);
            } else {
                properties = new Properties(stone_long_horizontal,R1.height,R1.width,10);
                body.setUserData(properties);
            }
            rectangles1.add(body);
        }
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
                    if (currentBird!=secondBird.getBirdBody()) {
                        bird1done = true;
                    }
                    //for applying force
                    float launchMultiplier = 10.5f;
                    double distance = Math.sqrt(((startPosition.x - endPosition.x) * (startPosition.x - endPosition.x)) + ((startPosition.y - endPosition.y) * (startPosition.y - endPosition.y)));
                    Vector2 launchDirection = new Vector2((float) (((startPosition.x - endPosition.x))*launchMultiplier), (float) (((startPosition.y - endPosition.y)) *launchMultiplier));
                    System.out.println(launchDirection.x);
                    System.out.println(launchDirection.y);
                    currentBird.setLinearVelocity(launchDirection);
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

                    shapeRenderer2.setProjectionMatrix(camera.combined);

                    shapeRenderer2.begin(ShapeRenderer.ShapeType.Line);
                    shapeRenderer2.setColor(Color.BLACK);
                    shapeRenderer2.line(startPosition.x,startPosition.y,endPosition.x,endPosition.y);
                    shapeRenderer2.end();

//                    Vector2 currentPosition = new Vector2(endPosition.x,endPosition.y);
//                    if (currentPosition.x>-100 && currentPosition.y>-100) {
//                        body2.setTransform(currentPosition, body2.getAngle());
//                    }

                    Vector2 launchDirection = new Vector2(startPosition.x-endPosition.x, startPosition.y-endPosition.y);
                    double distance = Math.sqrt(((startPosition.x-endPosition.x)*(startPosition.x-endPosition.x))+((startPosition.y-endPosition.y)*(startPosition.y-endPosition.y)));
                    Vector2 calculatedLinearVelocity=currentBird.getLinearVelocity().cpy().add(launchDirection.scl((float) distance*10f).scl(1/body2.getMass()));
                    calculatePath(pointsOfTrajectory,startPosition,calculatedLinearVelocity);
                    return true;
                }
                return false;
            }
        };

        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(birdAdapter);
        Gdx.input.setInputProcessor(multiplexer);
        retryButtons.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level4((main)));
            }
        });

        lostMenubutton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level_selector(main));
            }
        });
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

    private boolean birdGettingClicked(Vector3 startPosition) {
        if (startPosition.x>body2.getPosition().x && startPosition.x<body2.getPosition().x+20 && startPosition.y>body2.getPosition().y && startPosition.y<body2.getPosition().y+20 ){
            return true;
        }
        return false;
    }

    public void render(float delta) {

        camera.update();
        renderer.setView(camera);
        renderer.render();

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
        System.out.println(body2.getPosition().y);
        if (bird1done && body2.getPosition().y<-30){
            secondBird.relocateBirdBody();
            currentBird = secondBird.getBirdBody();
            multiplexer.addProcessor(birdAdapter);
            world.destroyBody(body2);
            bird1done =false;
        }
        if (bird1done && body2.getLinearVelocity().x<=1 && body2.getLinearVelocity().x>=-1 && body2.getLinearVelocity().y<=1 &&body2.getLinearVelocity().y>=-1){
            secondBird.relocateBirdBody();
            currentBird = secondBird.getBirdBody();
            multiplexer.addProcessor(birdAdapter);
            world.destroyBody(body2);
            bird1done = false;
        }
        if(x==0) {
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
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            x =1 ;

            Gdx.input.setInputProcessor(lostStage);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            x =2 ;
            Gdx.input.setInputProcessor(winStage);
        }

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.setProjectionMatrix(camera.combined);
        for (Vector2 p: pointsOfTrajectory){
            shapeRenderer.circle(p.x, p.y, 5);
        }
        shapeRenderer.end();
        Vector2 pos2 = secondBird.getPosition();
        Vector2 pos = body2.getPosition();


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
        stage.getBatch().draw(Red_bird,pos2.x-23, pos2.y-23 , 46 , 46);
        //world.getBodies(rectangle);
        for(Body body : rectangles1){
            Properties properties1 = (Properties) body.getUserData();
            stage.getBatch().draw(properties1.texture, body.getPosition().x -properties1.width/2, body.getPosition().y-properties1.height/2, properties1.width/2 ,properties1.height/2 ,properties1.width ,properties1.height,1.0f ,1.0f, (float) Math.toDegrees(body.getAngle()));
        }

        stage.getBatch().end();
        stage.draw();
        batch.end();

        //shapeRenderer.end();

        debugRenderer.render(world,camera.combined);
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
                float y = startPosition.y + (Velocity.y/directionModulus)*200 * simulatedTime  - 0.5f * simulatedTime * simulatedTime * 25f;
                pointsOfTrajectory.add(new Vector2(x, y));
            }
        }
    }
    public void setPauseStageTrue(){
        this.isPaused=false;
    }
    public void saveGame() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("SaveData.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
        System.out.println("Saved Game");
    }
}

package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.*;
import io.github.KunalSuman.Angry_Bird.Birds.Red_bird;

import java.util.ArrayList;

import java.util.ArrayList;

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
    private boolean isDragging = false;
    private Vector3 startPosition = new Vector3();
    private Vector3 endPosition = new Vector3();
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
    private World world  = new World(new Vector2(0,-30),true);
    BodyDef bodyDef = new BodyDef();
    Body body2 ;
    Body body3 ;
    private float multiplyer = 1000.0f ;
    private World world  = new World(new Vector2(0,-38.98f),true);
    BodyDef bodyDef = new BodyDef();
    Body body2 ;
    Body body3 ;
    private float distance = 100.0f ;
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
    private Collison collisonListener = new Collison() ;
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
        pauseButton = new Texture("pauseButton.png");
        closeButton = new Texture("closeButton.png");
        MenuButtonTexture = new Texture("Menu_button.png");
        retryButtonTexture = new Texture("Retry_button.png");
        retryTexture = new Texture("Level_failed.png");
        winTexture = new Texture("Level_complete.png");
        Nextlevel = new Texture("Next_level_button.png");

        Texture stone_long = new Texture("long_horizontal_stone.png") ;
        map = new TmxMapLoader().load("LEVEL1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();
        world.setContactListener(collisonListener);

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


        pauseStage.addActor(closeButton);
        //lostStage.addActor(retryButton);
        closeButton.setSize(100,100);
        closeButton.setPosition(Gdx.graphics.getWidth()-closeButton.getWidth(),Gdx.graphics.getHeight()-closeButton.getHeight());

        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(325 ,690);
        body2 = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(20);

        fixture2.shape = circleShape ;
        fixture2.density = 0.15f ;
        fixture2.restitution = 0.5f ;
        body2.createFixture(fixture2);
        fixtureDef.density = 0.0f ;
        fixtureDef.friction = 0.5f ;
        fixture2.density = 0.5f ;
        fixture2.friction = 0.5f ;
        fixture2.restitution = 0.5f ;
        body2.createFixture(fixture2).setUserData("bird");



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
            fixtureDef.density = 0.05f;
            fixtureDef.friction = 0.5f ;
            body.createFixture(fixtureDef);
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
                properties = new Properties(stone_long_vertical,R1.height,R1.width,10);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("S_M_H")) {
                properties = new Properties(stone_medium_horizontal,R1.height,R1.width,10);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("S_L_H")) {
                properties = new Properties(stone_long_horizontal,R1.height,R1.width,10);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("S_S_V")) {
                properties = new Properties(stone_small_vertical,R1.height,R1.width,10);
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("W_S_H")) {
                properties = new Properties(wood_small_horizontal,R1.height,R1.width,10);
                body.setUserData(properties);
            }
            else if(object.getProperties().get("texture").equals("W_S_V")){
                properties = new Properties(glass_small_vertical,R1.height,R1.width,10);
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
            body.createFixture(fixtureDef).setUserData("Obstacles");
            properties = new Properties(stone_long,R1.height,R1.width,10);
            //if(object.getProperties().get("texture") == "S_L_V" ){
                body.setUserData(properties);
//                body.setUserData(R1.height);
//                body.setUserData(R1.width);
            //}
            rectangles1.add(body);
        }
        Gdx.input.setInputProcessor(new InputAdapter(){
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
                    Vector2 launchDirection = new Vector2( startPosition.x -endPosition.x ,   startPosition.y -endPosition.y);
                    launchDirection.nor();

                    double distance = Math.sqrt(((startPosition.x-endPosition.x)*(startPosition.x-endPosition.x))+((startPosition.y-endPosition.y)*(startPosition.y-endPosition.y)));
                    float IMPULSE_SCALE = 500000f;
                    body2.applyLinearImpulse(launchDirection.scl((float) distance*100f), body2.getWorldCenter(), true);
                    System.out.println("Lmao gods!!!!");
                    //for applying force
                    Vector2 launchDirection = new Vector2(startPosition.x-endPosition.x, startPosition.y-endPosition.y);
                    double distance = Math.sqrt(((startPosition.x-endPosition.x)*(startPosition.x-endPosition.x))+((startPosition.y-endPosition.y)*(startPosition.y-endPosition.y)));
                    body2.applyLinearImpulse(launchDirection.scl((float) distance*10f), body2.getWorldCenter(), true);
                    pointsOfTrajectory.clear();
                    isDragging = false;
                    return true;
                }
                return false;
            }
            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                if (isDragging){
                    endPosition.set(screenX,screenY,0);
                    camera.unproject(endPosition);
                    Vector2 launchDirection = new Vector2(startPosition.x-endPosition.x, startPosition.y-endPosition.y);
                    double distance = Math.sqrt(((startPosition.x-endPosition.x)*(startPosition.x-endPosition.x))+((startPosition.y-endPosition.y)*(startPosition.y-endPosition.y)));
                    Vector2 calculatedLinearVelocity=body2.getLinearVelocity().cpy().add(launchDirection.scl((float) distance*10f).scl(1/body2.getMass()));
                    calculatePath(pointsOfTrajectory,startPosition,calculatedLinearVelocity);
                    return true;
                }
                return false;
            }
        });

        //stage.addActor(elements).width(2).height(4);
    }
    public void render(float delta) {

        camera.update();
        renderer.setView(camera);
        renderer.render();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.setProjectionMatrix(camera.combined);
        for (Vector2 p: pointsOfTrajectory){
            shapeRenderer.circle(p.x, p.y, 5);
        }
        shapeRenderer.end();

       Vector2 pos = body2.getPosition();
//        if (Gdx.input.isKeyPressed(Input.Keys.W) && pos.y < 1080) {
//            body2.setLinearVelocity(pos.x, pos.y + distance * Gdx.graphics.getDeltaTime());
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.S) && pos.y > 0) {
//            body2.setLinearVelocity(pos.x, pos.y + distance * Gdx.graphics.getDeltaTime());
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.A) && pos.x > 0) {
//            body2.setLinearVelocity(pos.x + distance* Gdx.graphics.getDeltaTime(), pos.y );
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.D) && pos.x < 1920 ) {
//            body2.setLinearVelocity(pos.x - distance* Gdx.graphics.getDeltaTime(), pos.y );
//        }
        world.step(1/120f,12,4);
        }
        shapeRenderer.end();
        for (Body b: collisonListener.getBodiesToRemove()){
            if (b!=null) {
                world.destroyBody(b);
                rectangles1.removeValue(b,true);
            }
        }
        collisonListener.bodiesToRemove.clear();
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
        world.step(1/120f,12,2);
        renderer.render(new int[]{3});
        batch.begin();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.getBatch().setProjectionMatrix(camera.combined);
        stage.getBatch().begin();
        stage.getBatch().draw(Red_bird , pos.x-23 ,pos.y-23 , 46 , 46);
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
            float simulatedTime = i*0.3f;

    public void calculatePath(ArrayList<Vector2> pointsOfTrajectory, Vector3 startPosition, Vector2 Velocity){
        pointsOfTrajectory.clear();
        for (int i=0;i<=10;i++){
            float simulatedTime = i*0.1f;
            float x = startPosition.x + Velocity.x *simulatedTime;
            float y = startPosition.y + Velocity.y *simulatedTime - 0.5f*simulatedTime*simulatedTime*9.8f;
            pointsOfTrajectory.add(new Vector2(x, y));
        }
    }
}

package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.Main;
import io.github.KunalSuman.Angry_Bird.Menu_page;
import io.github.KunalSuman.Angry_Bird.Settings_page;

import java.awt.*;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.table;

public class Level_selector extends ScreenAdapter {
    public Main main ;
    public Texture levels_page ;
    public SpriteBatch batch ;
    public Texture backButtonTexture;
    private float bbX,bbY,bbW,bbH;
    private float l1X,l1Y,l1W,l1H;
    private float l2X,l2Y,l2W,l2H;
    private float l3X,l3Y,l3W,l3H;
    private float l4X,l4Y,l4W,l4H;
    private float l5X,l5Y,l5W,l5H;
    public Stage stage;
    public Table t1 ;
    public Texture Load_button1 ;
    public Texture Load_button2 ;
    public TextButton b2 ;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer renderer ;

    public Level_selector(Main main) {
        this.main = main;
        this.batch = new SpriteBatch();
        this.levels_page = new Texture("Levels_page.png");
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        backButtonTexture = new Texture("backButton.png");
        Load_button1 = new Texture("Load_button.png");
        Load_button2 = new Texture("Load_button.png");
        this.t1 = new Table();
        camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("LEVEL_SELECTOR.tmx"));
        camera.setToOrtho(false, 1920, 1080);


        TextureRegionDrawable drawable_load1 = new TextureRegionDrawable(new TextureRegion(Load_button1));
        ImageButton.ImageButtonStyle Load_button1Style = new ImageButton.ImageButtonStyle();
        Load_button1Style.up = drawable_load1;
        ImageButton Load_button1 = new ImageButton(Load_button1Style);
        stage.addActor(Load_button1);
        Load_button1.setSize(300,132);
        Load_button1.setPosition((Gdx.graphics.getWidth()*0.72f - Load_button1.getWidth()*0.05f), (Gdx.graphics.getHeight()/0.94f - Load_button1.getHeight()*0.69f) / 2f);

        TextureRegionDrawable drawable_load2 = new TextureRegionDrawable(new TextureRegion(Load_button2));
        ImageButton.ImageButtonStyle Load_button2Style = new ImageButton.ImageButtonStyle();
        Load_button2Style.up = drawable_load2;
        ImageButton Load_button2 = new ImageButton(Load_button2Style);
        stage.addActor(Load_button2);
        Load_button2.setSize(300,132);
        Load_button2.setPosition((Gdx.graphics.getWidth()*0.72f - Load_button2.getWidth()*0.05f), Gdx.graphics.getHeight()*0.10f);

        Load_button1.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level3(main));
            }
        });
        Load_button2.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level5(main));
            }
        });

        stage.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                float adjustedY = Gdx.graphics.getHeight() - y;
                if (x>=bbX && x<=bbX+bbW && adjustedY>=bbY && adjustedY<=bbY+bbH){
                    main.setScreen(new Menu_page(main));
                }else if (x>=l1X && x<=l1X+l1W && adjustedY>=l1Y && adjustedY<=l1Y+l1H){
                    main.setScreen(new Level1(main));
                }else if (x>=l2X && x<=l2X+l2W && adjustedY>=l2Y && adjustedY<=l2Y+l2H){
                    main.setScreen(new Level2(main));
                }else if (x>=l3X && x<=l3X+l3W && adjustedY>=l3Y && adjustedY<=l3Y+l3H){
                    main.setScreen(new Level3(main));
                }
                else if (x>=l4X && x<=l4X+l4W && adjustedY>=l4Y && adjustedY<=l4Y+l4H){
                    main.setScreen(new Level4(main));
                }
                else if (x>=l5X && x<=l5X+l5W && adjustedY>=l5Y && adjustedY<=l5Y+l5H){
                    main.setScreen(new Level5(main));
                }
            }
        });
//       Gdx.input.setInputProcessor(stage);
//        Skin mySkin = new Skin("BACKGROUNDS_GE_1.png");
//        Skin skin = null ;
//        b1 = new TextButton("abc" , mySkin);
//        b2 = new TextButton("abc" , mySkin);
//        b3 = new TextButton("abc" , mySkin);
//        t1.setFillParent(true);
//        t1.add(b1).width(200).height(50).pad(10);
//        t1.add(b2).width(200).height(100).pad(10);
//        t1.add(b3).width(200).height(150).pad(10);
//        stage.addActor(t1);
    }
    public void render(float delta){
        camera.update();
        renderer.setView(camera);
        renderer.render();
        batch.begin();
        stage.act(delta);
        stage.draw();
        ///batch.draw(levels_page,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(backButtonTexture, bbX, bbY, bbW, bbH);
        batch.end();


    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        bbW = 100;
        bbH = 100;
        bbX= 0;
        bbY = 0;
        System.out.println((int)(Gdx.graphics.getWidth()/19.2));
        System.out.println((int)(Gdx.graphics.getHeight()/1.96363636364));
        l1X=(int)(Gdx.graphics.getWidth()/26.8);l1Y=(int)(Gdx.graphics.getHeight()/1.86363636364);l1W=100;l1H=100;
        l2X=(int)(Gdx.graphics.getWidth()/5.94705882353);l2Y=(int)(Gdx.graphics.getHeight()/1.76363636364);l2W=100;l2H=100;
        l3X=(int)(Gdx.graphics.getWidth()/3.49090909091);l3Y=(int)(Gdx.graphics.getHeight()/2.16);l3W=100;l3H=100;
        l4X=(int)(Gdx.graphics.getWidth()/2.72631578947);l4Y=(int)(Gdx.graphics.getHeight()/2.84210526316);l4W=100;l4H=100;
        l5X=(int)(Gdx.graphics.getWidth()/2.13333333333);l5Y=(int)(Gdx.graphics.getHeight()/1.74210526316);l5W=100;l5H=100;
}
}

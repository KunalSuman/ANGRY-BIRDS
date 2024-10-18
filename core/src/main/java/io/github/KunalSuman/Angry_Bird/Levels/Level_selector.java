package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
    public TextButton b1 ;
    public TextButton b2 ;
    public TextButton b3 ;
    public Level_selector(Main main) {
        this.main = main;
        this.batch = new SpriteBatch();
        this.levels_page = new Texture("Levels_page.png");
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        backButtonTexture = new Texture("backButton.png");
        this.t1 = new Table();
        bbW = 100;
        bbH = 100;
        bbX= 0;
        bbY = 0;
        l1X=100;l1Y=550;l1W=50;l1H=50;
        l2X=340;l2Y=550;l2W=50;l2H=50;
        l3X=550;l3Y=500;l3W=50;l3H=50;
        l4X=760;l4Y=500;l4W=70;l4H=70;
        l5X=970;l5Y=500;l5W=70;l5H=70;
        stage.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                float adjustedY = Gdx.graphics.getHeight() - y;
//                if (x>=pbX && x<=pbX+pW && y>=pbY && y<=pbY+pH){
//                    main.setScreen(new Level_selector(main));}
                if (x>=bbX && x<=bbX+bbW && adjustedY>=bbY && y<=bbY+bbH){
                    main.setScreen(new Menu_page(main));
                }else if (x>=l1X && x<=l1X+l1W && adjustedY>=l1Y && y<=l1Y+l1H){
                    main.setScreen(new Level1(main));
                }else if (x>=l2X && x<=l2X+l2W && adjustedY>=l2Y && y<=l2Y+l2H){
                    main.setScreen(new Level2(main));
                }else if (x>=l3X && x<=l3X+l3W && adjustedY>=l3Y && y<=l3Y+l3H){
                    main.setScreen(new Level3(main));
                }
                else if (x>=l4X && x<=l4X+l4W && adjustedY>=l4Y && y<=l4Y+l4H){
                    main.setScreen(new Level4(main));
                }
                else if (x>=l5X && x<=l5X+l5W && adjustedY>=l5Y && y<=l5Y+l5H){
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
        batch.begin();
        batch.draw(levels_page,0,0);
        batch.draw(backButtonTexture, bbX, bbY, bbW, bbH);
        batch.draw(backButtonTexture, l4X, l4Y, l4W,l4H);
        batch.draw(backButtonTexture, l5X, l5Y, l5W,l5H);
        batch.end();

        stage.act(delta);
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}

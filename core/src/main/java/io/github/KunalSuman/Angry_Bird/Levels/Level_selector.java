package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import io.github.KunalSuman.Angry_Bird.Main;

import java.awt.*;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.table;

public class Level_selector extends ScreenAdapter {
    public Main main ;
    public Texture levels_page ;
    public SpriteBatch batch ;
    public Stage stage;
    public Table t1 ;
    public TextButton b1 ;
    public TextButton b2 ;
    public TextButton b3 ;
    public Level_selector(Main main) {
        this.main = main;
        this.batch = new SpriteBatch();
        this.levels_page = new Texture("levels_page.png");
        this.stage = new Stage();
        this.t1 = new Table();
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
//        stage.act(delta);
//        stage.draw();
        batch.end();
    }
}

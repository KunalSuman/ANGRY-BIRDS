package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Loading_page extends ScreenAdapter{
    Texture Loading_page;
    public SpriteBatch Batch;
    public Main main;
    public int x  ;
    public Loading_page(Main main) {
        Loading_page = new Texture("Loading_screen.jpg");
        this.Batch = new SpriteBatch();
        this.main = main;
        x = 0;
    }
    public void show() {

    }
    public void render(float delta) {
        Batch.begin();
        if(x==1){
            main.setScreen(new Menu_page(main));
        }
        else {
            Batch.draw(Loading_page, 0, 0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            x =1 ;
        }
        Batch.end();
    }

}

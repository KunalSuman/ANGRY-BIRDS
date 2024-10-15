package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Loading_page extends ScreenAdapter{
    Texture Loading_page;
    public SpriteBatch Batch;
    public int x ;
    public Loading_page(Main main) {
        Loading_page = new Texture("Loading_screen.jpg");
        this.Batch = new SpriteBatch();
    }
    public void show() {

    }
    public void render(float delta) {
        Batch.begin();
        Batch.draw(Loading_page,0,0);
        Batch.end();
    }

}

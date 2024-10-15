package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.Gdx.input;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private SpriteBatch batch;
    private Texture Loading_page;
    private Texture Main_menu_page ;
    int page_number ;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new Loading_page(this));
        page_number = 0;
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        super.render();
        batch.begin();
//        if(page_number == 1){
//            batch.draw(Main_menu_page, 0 ,0);
//        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            System.exit(0) ;
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.Gdx.input;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public static Music music;
    private SpriteBatch batch;
    private Texture Loading_page;
    private Texture Main_menu_page ;
    int page_number ;
//    public Pixmap mouse_cursor;

//    public ImageButton createButton(Texture Play_button, int x, int y, int w, int h) {
//        TextureRegion PlaybuttonRegion = new TextureRegion(Play_button);
//        Skin skin=new Skin();
//        //inner class is being called here for Imagebuttonstyle
//        ImageButton.ImageButtonStyle playButtonStyle = new ImageButton.ImageButtonStyle();
//        playButtonStyle.imageUp = new TextureRegionDrawable(PlaybuttonRegion);
//        ImageButton clickPlayButton = new ImageButton(playButtonStyle);
//        clickPlayButton.setPosition(x,y);
//        clickPlayButton.setSize(w,h);
//        return clickPlayButton;
//    }
    @Override
    public void create() {
        batch = new SpriteBatch();
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("CURSORS_SHEET_1.png")), 0, 0));
        setScreen(new Loading_page(this));

        music = Gdx.audio.newMusic(Gdx.files.internal("Background_music.mp3"));
        page_number = 0;
        music.setVolume(1f);
        music.setLooping(true);
        music.play();
//        music.setVolume(1f);
//        music.setLooping(true);
//        music.play();
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

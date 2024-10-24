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
    public Pixmap pm;

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
        music = Gdx.audio.newMusic(Gdx.files.internal("title_theme.mp3"));
        pm = new Pixmap(Gdx.files.internal("CURSORS_SHEET_1.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0));
        setScreen(new Loading_page(this));

        page_number = 0;
        music.setVolume(1f);
        music.setLooping(true);
        music.play();

    }
    public static ImageButton createButton(Texture toMenu, Stage stage,int w,int h,float x,float y) {
        TextureRegionDrawable drawable_to_menue = new TextureRegionDrawable(new TextureRegion(toMenu));
        ImageButton.ImageButtonStyle to_menuStyle = new ImageButton.ImageButtonStyle();
        to_menuStyle.up = drawable_to_menue;
        ImageButton to_menu = new ImageButton(to_menuStyle);
        float menuX1 = (Gdx.graphics.getWidth() - to_menu.getWidth()) / 2;  // Center horizontally
        float menuY1 = (Gdx.graphics.getHeight() - to_menu.getHeight()) / 2; // Center vertically
        stage.addActor(to_menu);
        to_menu.setSize(w,h);
        to_menu.setPosition(x, y);
        return to_menu;
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
        pm.dispose();
    }
}

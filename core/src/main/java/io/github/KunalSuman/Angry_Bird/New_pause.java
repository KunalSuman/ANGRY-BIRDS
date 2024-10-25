package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class New_pause {
    public static Texture to_menu ;
    public static Texture retry_button;
    public static Texture Save_quit;
    public static Texture quit_button;
    public static Texture settings ;
    public Main main ;
    public static Stage stage;
    public static SpriteBatch batch;
    public static OrthographicCamera camera ;
    public static OrthogonalTiledMapRenderer renderer ;
    public static Texture pause_menu ;
    public static TiledMap T1 ;
    public static Texture pause_button ;
    public static ImageButton pause(Stage pauseStage, Stage stage) {

        pause_menu = new Texture(Gdx.files.internal("Pause_menu.png"));
        to_menu = new Texture("Menu_button.png");
        retry_button = new Texture("Restart_button.png");
        Save_quit = new Texture("SaveandExit_button.png");
        quit_button = new Texture("Quit_button.png");
        settings = new Texture("Settings_button_text.png");
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(T1);
        camera.setToOrtho(false, 1920, 1080);
        TextureRegionDrawable drawablePauseButton = new TextureRegionDrawable(new TextureRegion(pause_button));
        ImageButton.ImageButtonStyle pauseButtonStyle = new ImageButton.ImageButtonStyle();
        pauseButtonStyle.up = drawablePauseButton;
        ImageButton fpauseButton = new ImageButton(pauseButtonStyle);
        stage.addActor(fpauseButton);

        TextureRegionDrawable drawable_to_menue = new TextureRegionDrawable(new TextureRegion(to_menu));
        ImageButton.ImageButtonStyle to_menuStyle = new ImageButton.ImageButtonStyle();
        to_menuStyle.up = drawable_to_menue;
        ImageButton to_menu = new ImageButton(to_menuStyle);
        float menuX1 = (Gdx.graphics.getWidth() - to_menu.getWidth()) / 2;  // Center horizontally
        float menuY1 = (Gdx.graphics.getHeight() - to_menu.getHeight()) / 2; // Center vertically
        pauseStage.addActor(to_menu);
        to_menu.setSize(100, 100);
        to_menu.setPosition(0, 0);

        TextureRegionDrawable draweble_retry_button = new TextureRegionDrawable(new TextureRegion(retry_button));
        ImageButton.ImageButtonStyle retry_buttonStyle = new ImageButton.ImageButtonStyle();
        retry_buttonStyle.up = draweble_retry_button;
        ImageButton retry_button = new ImageButton(retry_buttonStyle);
        float menuX2 = (Gdx.graphics.getWidth() - retry_button.getWidth()) / 2;  // Center horizontally
        float menuY2 = (Gdx.graphics.getHeight() - retry_button.getHeight()) / 2; // Center vertically
        pauseStage.addActor(retry_button);
        retry_button.setSize(100, 100);
        retry_button.setPosition(0, 0);

        TextureRegionDrawable drawablequit_button = new TextureRegionDrawable(new TextureRegion(Save_quit));
        ImageButton.ImageButtonStyle Save_quitStyle = new ImageButton.ImageButtonStyle();
        Save_quitStyle.up = drawablequit_button;
        ImageButton Save_quit = new ImageButton(Save_quitStyle);
        float menuX3 = (Gdx.graphics.getWidth() - Save_quit.getWidth()) / 2;  // Center horizontally
        float menuY3 = (Gdx.graphics.getHeight() - Save_quit.getHeight()) / 2; // Center vertically
        pauseStage.addActor(Save_quit);
        Save_quit.setSize(100, 100);
        Save_quit.setPosition(0, 0);

        TextureRegionDrawable draweble_quit_button = new TextureRegionDrawable(new TextureRegion(quit_button));
        ImageButton.ImageButtonStyle quit_buttonStyle = new ImageButton.ImageButtonStyle();
        quit_buttonStyle.up = draweble_quit_button;
        ImageButton quit_button = new ImageButton(quit_buttonStyle);
        float menuX4 = (Gdx.graphics.getWidth() - quit_button.getWidth()) / 2;  // Center horizontally
        float menuY4 = (Gdx.graphics.getHeight() - quit_button.getHeight()) / 2; // Center vertically
        pauseStage.addActor(quit_button);
        quit_button.setSize(100, 100);
        quit_button.setPosition(0, 0);

        TextureRegionDrawable drawable_settings = new TextureRegionDrawable(new TextureRegion(settings));
        ImageButton.ImageButtonStyle settingsStyle = new ImageButton.ImageButtonStyle();
        settingsStyle.up = drawable_settings;
        ImageButton settings = new ImageButton(settingsStyle);
        float menuX5 = (Gdx.graphics.getWidth() - settings.getWidth()) / 2;  // Center horizontally
        float menuY5 = (Gdx.graphics.getHeight() - settings.getHeight()) / 2; // Center vertically
        pauseStage.addActor(settings);
        settings.setSize(100, 100);
        settings.setPosition(0, 0);
        return fpauseButton ;
    }
    public void dispose(){
        stage.dispose();
        batch.dispose();
        T1.dispose();
        to_menu.dispose();
        retry_button.dispose();
        Save_quit.dispose();
        quit_button.dispose();
        settings.dispose();
    }
}

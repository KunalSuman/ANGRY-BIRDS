package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.Levels.*;

public class Pause extends ScreenAdapter {
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
    public static OrthogonalTiledMapRenderer new_renderer ;
    public static Texture pause_menu ;
    public static Texture return_button ;
    public static TiledMap T1 ;
    public static TiledMap T2 ;

    public Pause(Main main ,TiledMap T1,int return_number){
        System.out.println("done") ;
        stage = new Stage(new ScreenViewport());

        pause_menu = new Texture(Gdx.files.internal("Pause_menu.png"));
        to_menu = new Texture("Menu_button.png");
        retry_button = new Texture("Restart_button.png");
        Save_quit = new Texture("SaveandExit_button.png");
        quit_button = new Texture("Quit_button.png");
        settings = new Texture("Settings_button_text.png");
        return_button = new Texture("Return.png");

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(T1);
        new_renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("PausePage.tmx"));
        camera.setToOrtho(false, 1920, 1080);



        TextureRegionDrawable drawable_to_menue = new TextureRegionDrawable(new TextureRegion(to_menu));
        ImageButton.ImageButtonStyle to_menuStyle = new ImageButton.ImageButtonStyle();
        to_menuStyle.up = drawable_to_menue;
        ImageButton to_menu = new ImageButton(to_menuStyle);
        float menuX1 = (Gdx.graphics.getWidth() - to_menu.getWidth()) / 2;  // Center horizontally
        float menuY1 = (Gdx.graphics.getHeight() - to_menu.getHeight()) / 2; // Center vertically
        stage.addActor(to_menu);
        to_menu.setSize(200,100);
        to_menu.setPosition((Gdx.graphics.getWidth() - pause_menu.getWidth()*0.05f) / 2f, 725);

        TextureRegionDrawable draweble_retry_button = new TextureRegionDrawable(new TextureRegion(retry_button));
        ImageButton.ImageButtonStyle retry_buttonStyle = new ImageButton.ImageButtonStyle();
        retry_buttonStyle.up = draweble_retry_button;
        ImageButton retry_button = new ImageButton(retry_buttonStyle);
        float menuX2 = (Gdx.graphics.getWidth() - retry_button.getWidth()) / 2;  // Center horizontally
        float menuY2 = (Gdx.graphics.getHeight() - retry_button.getHeight()) / 2; // Center vertically
        stage.addActor(retry_button);
        retry_button.setSize(200,100);
        retry_button.setPosition((Gdx.graphics.getWidth() - pause_menu.getWidth()*0.05f) / 2f, 625);

        TextureRegionDrawable drawablequit_button = new TextureRegionDrawable(new TextureRegion(Save_quit));
        ImageButton.ImageButtonStyle Save_quitStyle = new ImageButton.ImageButtonStyle();
        Save_quitStyle.up = drawablequit_button;
        ImageButton Save_quit = new ImageButton(Save_quitStyle);
        float menuX3 = (Gdx.graphics.getWidth() - Save_quit.getWidth()) / 2;  // Center horizontally
        float menuY3 = (Gdx.graphics.getHeight() - Save_quit.getHeight()) / 2; // Center vertically
        stage.addActor(Save_quit);
        Save_quit.setSize(200,100);
        Save_quit.setPosition((Gdx.graphics.getWidth() - pause_menu.getWidth()*0.05f) / 2f, 525);

        TextureRegionDrawable draweble_quit_button = new TextureRegionDrawable(new TextureRegion(quit_button));
        ImageButton.ImageButtonStyle quit_buttonStyle = new ImageButton.ImageButtonStyle();
        quit_buttonStyle.up = draweble_quit_button;
        ImageButton quit_button = new ImageButton(quit_buttonStyle);
        float menuX4 = (Gdx.graphics.getWidth() - quit_button.getWidth()) / 2;  // Center horizontally
        float menuY4 = (Gdx.graphics.getHeight() - quit_button.getHeight()) / 2; // Center vertically
        stage.addActor(quit_button);
        quit_button.setSize(200,100);
        quit_button.setPosition((Gdx.graphics.getWidth() - pause_menu.getWidth()*0.05f) / 2f, 425 );

        TextureRegionDrawable drawable_settings = new TextureRegionDrawable(new TextureRegion(settings));
        ImageButton.ImageButtonStyle settingsStyle = new ImageButton.ImageButtonStyle();
        settingsStyle.up = drawable_settings;
        ImageButton settings = new ImageButton(settingsStyle);
        float menuX5 = (Gdx.graphics.getWidth() - settings.getWidth()) / 2;  // Center horizontally
        float menuY5 = (Gdx.graphics.getHeight() - settings.getHeight()) / 2; // Center vertically
        stage.addActor(settings);
        settings.setSize(200,100);
        settings.setPosition((Gdx.graphics.getWidth() - pause_menu.getWidth()*0.05f) / 2f, 325);

        TextureRegionDrawable drawable_return = new TextureRegionDrawable(new TextureRegion(return_button));
        ImageButton.ImageButtonStyle return_buttonStyle = new ImageButton.ImageButtonStyle();
        return_buttonStyle.up = drawable_return;
        ImageButton return_button = new ImageButton(return_buttonStyle);
        float menuX6 = (Gdx.graphics.getWidth() - return_button.getWidth()) / 2;  // Center horizontally
        float menuY6 = (Gdx.graphics.getHeight() - return_button.getHeight()) / 2; // Center vertically
        stage.addActor(return_button);
        return_button.setSize(200,100);
        return_button.setPosition((Gdx.graphics.getWidth() - pause_menu.getWidth()*0.05f) / 2f, (Gdx.graphics.getHeight() - pause_menu.getHeight()*0.85f) / 2f);
        System.out.println("hello");

        settings.addListener(new ClickListener() {
           public void clicked(InputEvent event, float x, float y) {
               main.setScreen(new Settings_page(main , renderer));
           }
        });

        quit_button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Quit(main , renderer));
            }
        });

        to_menu.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Menu_page(main));
            }
        });

        Save_quit.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Save_quit(main , return_number ,0, T1));
            }
        });

        retry_button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(return_number == 1){
                    main.setScreen(new Level1(main));
                }
                if(return_number == 2){
                    main.setScreen(new Level2(main));
                }
                if(return_number == 3){
                    main.setScreen(new Level3(main));
                }
                if(return_number == 4){
                    main.setScreen(new Level4(main));
                }
                if(return_number == 5){
                    main.setScreen(new Level5(main));
                }
            }
        });

        return_button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("done");
                if(return_number == 1){
                    main.setScreen(new Level1(main));
                }
                if(return_number == 2){
                    main.setScreen(new Level2(main));
                }
                if(return_number == 3){
                    main.setScreen(new Level3(main));
                }
                if(return_number == 4){
                    main.setScreen(new Level4(main));
                }
                if(return_number == 5){
                    main.setScreen(new Level5(main));
                }
            }
        });

    }
        public void render(float delta) {
        super.render(delta);
        camera.update();
        renderer.setView(camera);
        new_renderer.setView(camera);

        renderer.render();
        new_renderer.render();
        batch.begin();
        //batch.draw(pause_menu, (Gdx.graphics.getWidth() - pause_menu.getWidth()) / 2f, (Gdx.graphics.getHeight() - pause_menu.getHeight()) / 2f);
        batch.end();
        //stage.getBatch().begin();
        stage.act(delta);
        Gdx.input.setInputProcessor(stage);
        //stage.getBatch().draw(pause_menu, (Gdx.graphics.getWidth() - pause_menu.getWidth()) / 2f, (Gdx.graphics.getHeight() - pause_menu.getHeight()) / 2f);
        stage.draw();
    }
    public void dispose(){
        stage.dispose();
    }
}

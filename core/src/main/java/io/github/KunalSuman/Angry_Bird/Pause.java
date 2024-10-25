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
    public static Texture to_menu_texture ;
    public static Texture retry_button_texture;
    public static Texture Save_quit_texture;
    public static Texture quit_button_texture;
    public static Texture settings_texture ;
    public Main main ;
    public static Stage stage;
    public static SpriteBatch batch;
    public static OrthographicCamera camera ;
    public static OrthogonalTiledMapRenderer renderer ;
    public static OrthogonalTiledMapRenderer new_renderer ;
    public static Texture pause_menu ;
    public static Texture return_button_texture ;
    public static TiledMap T1 ;
    public static TiledMap T2 ;

    public Pause(Main main ,TiledMap T1,int return_number){
        System.out.println("done") ;
        stage = new Stage(new ScreenViewport());

        pause_menu = new Texture(Gdx.files.internal("Pause_menu.png"));
        to_menu_texture = new Texture("Menu_button.png");
        retry_button_texture = new Texture("Restart_button.png");
        Save_quit_texture = new Texture("SaveandExit_button.png");
        quit_button_texture = new Texture("Quit_button.png");
        settings_texture = new Texture("Settings_button_text.png");
        return_button_texture = new Texture("Return.png");

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(T1);
        new_renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("PausePage.tmx"));
        camera.setToOrtho(false, 1920, 1080);

        ImageButton to_menu = Main.createButton(to_menu_texture,stage,300,160,(Gdx.graphics.getWidth() - pause_menu.getWidth()*0.1f) / 2f,760);

        ImageButton retry_button = Main.createButton(retry_button_texture,stage,300,150,(Gdx.graphics.getWidth() - pause_menu.getWidth()*0.1f) / 2f,625);

        ImageButton Save_quit = Main.createButton(Save_quit_texture,stage,300,140,(Gdx.graphics.getWidth() - pause_menu.getWidth()*0.1f) / 2f,500);

        ImageButton quit_button = Main.createButton(quit_button_texture,stage,300,140,(Gdx.graphics.getWidth() - pause_menu.getWidth()*0.1f) / 2f,370);

        ImageButton settings = Main.createButton(settings_texture,stage,300,160,(Gdx.graphics.getWidth() - pause_menu.getWidth()*0.1f) / 2f,220);

        ImageButton return_button = Main.createButton(return_button_texture,stage,300,160,(Gdx.graphics.getWidth() - pause_menu.getWidth()*0.1f) / 2f,60);


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
        batch.dispose();
        stage.dispose();
        to_menu_texture.dispose();
        retry_button_texture.dispose();
        Save_quit_texture.dispose();
        return_button_texture.dispose();
    }
}

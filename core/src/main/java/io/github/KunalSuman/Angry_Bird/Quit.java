package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import javax.swing.event.ChangeListener;

public class Quit extends ScreenAdapter {
    public Texture T1 ;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer renderer ;
    public Stage stage;
    public Texture quitButtonTexture;
    public Texture backButtonTexture;
    public OrthogonalTiledMapRenderer new_renderer ;
    Quit(Main main , OrthogonalTiledMapRenderer new_renderer,TiledMap T1,int level ) {
        camera = new OrthographicCamera();
        quitButtonTexture = new Texture(Gdx.files.internal("Quit_button.png"));
        backButtonTexture = new Texture(Gdx.files.internal("BACK_button.png"));
        stage = new Stage();
        this.new_renderer = new_renderer;
        camera.setToOrtho(false, 1920, 1080);
        renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("Exit.tmx"));

        ImageButton quitButton = Button.createButton(quitButtonTexture,stage,200,100, Gdx.graphics.getWidth()/1.95f,Gdx.graphics.getHeight()/3.49f);
        stage.addActor(quitButton);
        ImageButton backButton = Button.createButton(backButtonTexture,stage,200,100,Gdx.graphics.getWidth()/2.6f,Gdx.graphics.getHeight()/3.49f);
        stage.addActor(backButton);
        quitButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
        backButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Pause(main,T1,level));
            }
        });
       // new_renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load(""));
    }
    public void render(float delta) {
        Gdx.input.setInputProcessor(stage);
        camera.update();
        renderer.setView(camera);
        new_renderer.setView(camera);
        new_renderer.render();
        renderer.render();

        stage.act(delta);
        stage.draw();

    }
}

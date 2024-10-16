package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import io.github.KunalSuman.Angry_Bird.Main;

public class Level2 extends ScreenAdapter {
    public Main main ;
    public SpriteBatch batch ;
    public Texture background;
    public OrthographicCamera camera ;
    public TiledMap tiledMap ;
    public OrthogonalTiledMapRenderer renderer ;
    public Level2(Main main){
        this.main = new Main();
        //this.background = new Texture("Level3.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        tiledMap = new TmxMapLoader().load("LEVEL2.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
    }
    public void render(float delta){
        camera.update();
        renderer.setView(camera);
        renderer.render();
        //batch.begin();
//        batch.draw(background, 0, 0);
        //batch.end();
    }
}

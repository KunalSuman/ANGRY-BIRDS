package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Quit extends ScreenAdapter {
    public Texture T1 ;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer renderer ;
    public OrthogonalTiledMapRenderer new_renderer ;
    Quit(Main main , OrthogonalTiledMapRenderer new_renderer ) {
        camera = new OrthographicCamera();
        this.new_renderer = new_renderer;
        camera.setToOrtho(false, 1920, 1080);
        renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("Exit.tmx"));
       // new_renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load(""));
    }
    public void render(float delta) {
        camera.update();
        renderer.setView(camera);
        new_renderer.setView(camera);
        new_renderer.render();
        renderer.render();

    }
}

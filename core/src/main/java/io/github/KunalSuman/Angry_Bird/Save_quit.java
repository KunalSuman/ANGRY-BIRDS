package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Save_quit extends ScreenAdapter {
    public Texture to_menu ;
    public Texture Return ;
    public TiledMap t1 ;
    public Stage stage;
    public Texture settings_page ;
    public OrthographicCamera camera ;
    public OrthogonalTiledMapRenderer renderer ;
    public OrthogonalTiledMapRenderer new_renderer ;

    Save_quit(Main main , int level_return , int page_return) {
        to_menu = new Texture("Quit_button.png");
        Return = new Texture("Return.png");
        settings_page = new Texture("Settings_page.png");
        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera();
        camera.setToOrtho(false,1920,1080);
        renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("SaveAndExit.tmx"));

        TextureRegionDrawable drawable_to_menue = new TextureRegionDrawable(new TextureRegion(to_menu));
        ImageButton.ImageButtonStyle to_menuStyle = new ImageButton.ImageButtonStyle();
        to_menuStyle.up = drawable_to_menue;
        ImageButton to_menu = new ImageButton(to_menuStyle);
        float menuX1 = (Gdx.graphics.getWidth() - to_menu.getWidth()) / 2;  // Center horizontally
        float menuY1 = (Gdx.graphics.getHeight() - to_menu.getHeight()) / 2; // Center vertically
        stage.addActor(to_menu);
        to_menu.setSize(200,100);
        to_menu.setPosition((Gdx.graphics.getWidth() - settings_page.getWidth()*0.42f) / 2f, 725);

    }
    public void render(float delta) {
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }
}

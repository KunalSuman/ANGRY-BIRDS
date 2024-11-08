package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
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
import io.github.KunalSuman.Angry_Bird.Main;
import io.github.KunalSuman.Angry_Bird.Menu_page;

public class Settings_page extends ScreenAdapter {
    public Texture background;
    public AssetManager assetManager;
    private Stage stage;
    public SpriteBatch batch;
    private Texture settings_page_texture;
    public Texture backButtonTexture;
    private float bbX,bbY,bbW,bbH;
    private float spX,spY,spW,spH;
    public Main main;
    public OrthographicCamera camera;
    public OrthogonalTiledMapRenderer renderer;
    public OrthogonalTiledMapRenderer renderer2;
    public Texture Return_button ;
    public Texture Quit_button ;
    public Texture settings_button;
    public float qb_X,qb_Y,qb_W,qb_H;
    public ImageButton quit_button;
    public ImageButton return_button;
    public Settings_page(Main main , OrthogonalTiledMapRenderer renderer2 , int return_page , TiledMap T1, int return_number ) {
        this.renderer2 = renderer2;
        this.main = main;
        this.stage = new Stage(new ScreenViewport());
        assetManager = new AssetManager();
        camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("SETTINGS.tmx"));
        Return_button = new Texture("BACK_button.png");
        Quit_button = new Texture("Quit_button.png");
        settings_button = new Texture("SETTINGS.png");
        camera.setToOrtho(false, 1920, 1080);

        TextureRegionDrawable drawable_return = new TextureRegionDrawable(new TextureRegion(Return_button));
        ImageButton.ImageButtonStyle return_buttonStyle = new ImageButton.ImageButtonStyle();
        return_buttonStyle.up = drawable_return;
        return_button = new ImageButton(return_buttonStyle);
        float menuX6 = (Gdx.graphics.getWidth() - return_button.getWidth()) / 2;  // Center horizontally
        float menuY6 = (Gdx.graphics.getHeight() - return_button.getHeight()) / 2; // Center vertically
        stage.addActor(return_button);
        return_button.setSize(400,200);
        return_button.setPosition(((Gdx.graphics.getWidth() - settings_button.getWidth()*0.05f) / 2.35f), (Gdx.graphics.getHeight() - settings_button.getHeight()*0.85f) / 0.7f);

        TextureRegionDrawable drawable_quit = new TextureRegionDrawable(new TextureRegion(Quit_button));
        ImageButton.ImageButtonStyle Quit_buttonStyle = new ImageButton.ImageButtonStyle();
        Quit_buttonStyle.up = drawable_quit;
        ImageButton Quit_button = new ImageButton(Quit_buttonStyle);
        stage.addActor(Quit_button);
        Quit_button.setSize(400,200);
        Quit_button.setPosition((Gdx.graphics.getWidth() - settings_button.getWidth()*0.05f) / 2.35f, (Gdx.graphics.getHeight() - settings_button.getHeight()*0.85f) / 0.37f);
        quit_button = new ImageButton(Quit_buttonStyle);
        stage.addActor(quit_button);


        return_button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(return_page == 0){
                    main.setScreen(new Menu_page(main));
                }
                if(return_page == 1){
                    main.setScreen(new Pause(main , T1 ,return_number ));
                }

            }
        });
        quit_button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });
//        background = new Texture("BACKGROUNDS_GE_1.png");
//        settings_page_texture = new Texture("Settings_page.png");
//        backButtonTexture = new Texture("backButton.png");
//        batch = new SpriteBatch();
//        stage = new Stage();
//        Gdx.input.setInputProcessor(stage);
//        bbW = 100;
//        bbH = 100;
//        bbX= 0;
//        bbY = 0;
//        spW = 1000;
//        spH = 800;
//        spX = (Gdx.graphics.getWidth() - spW) / 2f;
//        spY = (Gdx.graphics.getHeight() - spH) / 2f;
//        stage.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                float adjustedY = Gdx.graphics.getHeight() - y;
////                if (x>=pbX && x<=pbX+pW && y>=pbY && y<=pbY+pH){
////                    main.setScreen(new Level_selector(main));}
//                if (x>=bbX && x<=bbX+bbW && adjustedY>=bbY && y<=bbY+bbH){
//                    main.setScreen(new Menu_page(main));
//                }
//            }
//        });

    }
    public void render(float delta) {
        camera.update();
        renderer.setView(camera);
        renderer2.setView(camera);
        renderer2.render();
        renderer.render();
//        batch.begin();
//        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());// Draw the button
//        batch.draw(settings_page_texture, spX, spY, spW, spH);
//        batch.draw(backButtonTexture, bbX, bbY, bbW, bbH);
//        batch.end();
//        // Render the stage (buttons, if any)
        stage.act(delta);
        stage.draw();
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        quit_button.setSize(Gdx.graphics.getWidth()/4.8f,Gdx.graphics.getHeight()/5.4f);
        quit_button.setPosition(((Gdx.graphics.getWidth() - settings_button.getWidth()*0.05f) / 2.35f), Gdx.graphics.getHeight()/2.4f);
        return_button.setSize(Gdx.graphics.getWidth()/4.8f,Gdx.graphics.getHeight()/5.4f);
        return_button.setPosition(((Gdx.graphics.getWidth() - settings_button.getWidth()*0.05f) / 2.35f), Gdx.graphics.getHeight()/4.9f);

    }
    public void dispose() {
        stage.dispose();
        background.dispose();
        settings_page_texture.dispose(); // Dispose the button texture
        batch.dispose();
    }

}

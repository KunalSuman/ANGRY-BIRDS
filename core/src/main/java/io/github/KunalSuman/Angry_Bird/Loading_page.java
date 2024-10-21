package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Loading_page extends ScreenAdapter{
    Texture Loading_page;
    public SpriteBatch Batch;
    public Main main;
    public AssetManager assetManager;
    public int x ;
    private Stage stage;
    private TextureRegionDrawable textureProgressBar;
    private ProgressBar progressBar;
    public Loading_page(Main main) {
        Loading_page = new Texture("Loading_screen.jpg");
        this.Batch = new SpriteBatch();
        this.main = main;
        x = 0;
        this.assetManager = new AssetManager();
        assetManager.load("Loading_screen.jpg", Texture.class);
        stage =new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        assetManager.finishLoading(); // Wait until assets are loaded
        Loading_page = assetManager.get("Loading_screen.jpg", Texture.class); // Initialize the texture
        assetManager.load("Loading_screen.jpg", Texture.class);
        assetManager.load("level5.png", Texture.class);
        assetManager.load("level3.png", Texture.class);
        assetManager.load("level2.png", Texture.class);
        assetManager.load("level1.png", Texture.class);
        assetManager.load("level4.png", Texture.class);
        assetManager.load("Level_failed.png", Texture.class);
        assetManager.load("SETTINGS.png", Texture.class);
        assetManager.load("SAVEandEXIT.png", Texture.class);
        assetManager.load("Loading_screen.jpg", Texture.class);
        
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("backButton.png"))));
        TextureRegionDrawable fillDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("pauseButton.png"))));
        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();
        progressBarStyle.background = backgroundDrawable;
        progressBarStyle.knobBefore = fillDrawable;
        progressBar = new ProgressBar(0f, 1f, 0.01f, false, progressBarStyle);  // false = horizontal progress bar
        progressBar.setWidth(Gdx.graphics.getWidth() * 0.8f);
        progressBar.setHeight(Gdx.graphics.getHeight()*(0.009f));// Set the size of the progress bar
        progressBar.setPosition(Gdx.graphics.getWidth() / 2f - progressBar.getWidth() / 2f, Gdx.graphics.getHeight() / 4f - progressBar.getHeight() / 2f);  // Center it horizontally

        stage.addActor(progressBar);
    }
    public void show() {

    }
    public void render(float delta) {
        Batch.begin();
        float progress =assetManager.getProgress();
        progressBar.setValue(progress);
        if(x==1){
            main.setScreen(new Menu_page(main));
        }
        else {
            Batch.draw(Loading_page, 0, 0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            x =1 ;
        }
        if (assetManager.update() && progress == 1f) {
            main.setScreen(new Menu_page(main));
        }
        Batch.end();
        stage.act(delta);
        stage.draw();
    }

}

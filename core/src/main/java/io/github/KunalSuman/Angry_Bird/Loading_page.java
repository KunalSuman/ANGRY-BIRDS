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
    public Texture Loading_text ;
    public Texture progresabarsa ;
    public Texture Loadingbar1 ;
    public Texture Loadingbar2 ;
    public Loading_page(Main main) {
        Loading_page = new Texture("Loading_screen.jpg");
        Loading_text = new Texture("loading_text.png");
        progresabarsa = new Texture("Loadingbar1.png");
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
        Loadingbar1 = new Texture("Loadingbar1.png");
        Loadingbar2 = new Texture("loadingbar2.png");
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(Loadingbar1));
        TextureRegionDrawable fillDrawable = new TextureRegionDrawable(new TextureRegion(Loadingbar2));
        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();
        progressBarStyle.background = backgroundDrawable;
        progressBarStyle.knobBefore = fillDrawable;
        progressBar = new ProgressBar(0f, 1f, 0.01f, false, progressBarStyle);  // false = horizontal progress bar
        progressBar.setWidth(Gdx.graphics.getWidth());
        progressBar.setHeight(Gdx.graphics.getHeight()/8f);// Set the size of the progress bar
        progressBar.setPosition(Gdx.graphics.getWidth()/48f , Gdx.graphics.getHeight()/3.25f);  // Center it horizontally
        stage.addActor(progressBar);
    }
    public void render(float delta) {
        Batch.begin();
        float progress =assetManager.getProgress();
        progressBar.setValue(progress);

        if(x==1){
            main.setScreen(new StoryPage(main));
        }
        else {
            Batch.draw(Loading_page,0, 0);
            Batch.draw(Loading_text,Gdx.graphics.getWidth()*1.25f/3f,Gdx.graphics.getHeight()/8f,progressBar.getWidth()/4f,Loading_text.getHeight()/2f);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            x =1 ;
        }
        if (assetManager.update() && progress == 1f) {
            main.setScreen(new StoryPage(main));
        }
        stage.act(delta);
        stage.draw();
        System.out.println(delta);
        Batch.end();
    }
    public void dispose() {
        Batch.dispose();
        assetManager.dispose();
        stage.dispose();
        Loading_page.dispose();
        Loading_text.dispose();
        progresabarsa.dispose();
        Loadingbar1.dispose();
        Loadingbar2.dispose();
    }


}

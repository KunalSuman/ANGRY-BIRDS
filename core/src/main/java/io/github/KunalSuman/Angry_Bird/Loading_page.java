package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Loading_page extends ScreenAdapter{
    Texture Loading_page;
    public SpriteBatch Batch;
    public Main main;
    public AssetManager assetManager;
    public int x ;
    private Stage stage;
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

    }
    public void show() {

    }
    public void render(float delta) {
        Batch.begin();
        if(x==1){
            main.setScreen(new Menu_page(main));
        }
        else {
            Batch.draw(Loading_page, 0, 0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            x =1 ;
        }
        Batch.end();
    }

}

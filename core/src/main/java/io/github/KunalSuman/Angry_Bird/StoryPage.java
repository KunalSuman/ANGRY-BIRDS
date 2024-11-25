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
import io.github.KunalSuman.Angry_Bird.Levels.Level_selector;

public class StoryPage extends ScreenAdapter{
    Texture Loading_page;
    public SpriteBatch Batch;
    public Main main;
    public AssetManager assetManager;
    public int x ;
    private TextureRegionDrawable textureProgressBar;
    private ProgressBar progressBar;
    public Texture Loading_text ;
    public Texture progresabarsa ;
    public Texture Loadingbar1 ;
    public Texture Loadingbar2 ;
    Texture firstPage;
    Texture secondPage;
    public int time=0;

    public StoryPage(Main main) {
        this.main = main;
        firstPage = new Texture(("BOMB.png"));
        secondPage = new Texture(("Loading_screen.jpg"));
        Batch = new SpriteBatch();
        assetManager = new AssetManager();
        assetManager.load(("Loading_screen.jpg"), Texture.class);
        assetManager.load(("Levels_page.png"), Texture.class);
    }
    public void render(float delta) {
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        if (time<=50){
            Batch.begin();
            Batch.draw(firstPage,0,0);
            Batch.end();
        }else if (time >50 && time<=100){
            Batch.begin();
            Batch.draw(secondPage,0,0);
            Batch.end();
        }else{
            main.setScreen(new Level_selector(main));
        }
        System.out.println(time);

        time++;
    }
    public void dispose() {
        Batch.dispose();
        assetManager.dispose();
        Loading_page.dispose();
        Loading_text.dispose();
        progresabarsa.dispose();
        Loadingbar1.dispose();
        Loadingbar2.dispose();
    }


}


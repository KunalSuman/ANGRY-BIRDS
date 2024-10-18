package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
    public Settings_page(Main main) {
        this.main = main;
        this.stage = new Stage(new ScreenViewport());
        assetManager = new AssetManager();
        background = new Texture("BACKGROUNDS_GE_1.png");
        settings_page_texture = new Texture("SETTINGS.png");
        backButtonTexture = new Texture("backButton.png");
        batch = new SpriteBatch();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        bbW = 100;
        bbH = 100;
        bbX= 0;
        bbY = 0;
        spW = 1000;
        spH = 800;
        spX = (Gdx.graphics.getWidth() - spW) / 2f;
        spY = (Gdx.graphics.getHeight() - spH) / 2f;
        stage.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                float adjustedY = Gdx.graphics.getHeight() - y;
//                if (x>=pbX && x<=pbX+pW && y>=pbY && y<=pbY+pH){
//                    main.setScreen(new Level_selector(main));}
                if (x>=bbX && x<=bbX+bbW && adjustedY>=bbY && y<=bbY+bbH){
                    main.setScreen(new Menu_page(main));
                }
            }
        });

    }
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());// Draw the button
        batch.draw(settings_page_texture, spX, spY, spW, spH);
        batch.draw(backButtonTexture, bbX, bbY, bbW, bbH);
        batch.end();
        // Render the stage (buttons, if any)
        stage.act(delta);
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
    public void dispose() {
        stage.dispose();
        background.dispose();
        settings_page_texture.dispose(); // Dispose the button texture
        batch.dispose();
    }

}

package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.Levels.Level_selector;

import static com.badlogic.gdx.graphics.g3d.particles.ParticleShader.AlignMode.Screen;

public class Menu_page extends ScreenAdapter {
    public Texture background;
    public AssetManager assetManager;
    private Stage stage;
    public SpriteBatch batch;
    private Texture playButtonTexture;
    private Texture settingsButtonTexture;
    private float sW,sH,sX,sY;
    private float pbW, pbH, pbX, pbY;  // Variables for Play button size and position

    public Main main;
    public Menu_page(Main main) {
        this.main = main;
        this.assetManager = new AssetManager();
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        background = new Texture("BACKGROUNDS_GE_1.png");
        this.batch = new SpriteBatch();
        settingsButtonTexture = new Texture("settings_button.png");
        sW = Gdx.graphics.getWidth() * 0.1f;  // Settings button width is 10% of screen width
        sH = Gdx.graphics.getHeight() * 0.1f; // Settings button height is 10% of screen height
        sX = 0;  // Position at bottom-left corner
        sY = 0;
        pbW = Gdx.graphics.getWidth() * 0.2f;  // Play button width is 20% of screen width
        pbH = Gdx.graphics.getHeight() * 0.2f; // Play button height is 20% of screen height
        pbX = (Gdx.graphics.getWidth() - pbW) / 2f; // Center Play button horizontally
        pbY = (Gdx.graphics.getHeight() - pbH) / 2f; // Center Play button vertically
        playButtonTexture = new Texture("BUTTONS_SHEET_1.png");
        TextureRegionDrawable playButtonDrawable = new TextureRegionDrawable(new TextureRegion(playButtonTexture));
        TextureRegionDrawable playButtonClickedDrawable = new TextureRegionDrawable(new TextureRegion(settingsButtonTexture));
        ImageButton.ImageButtonStyle playButtonStyle = new ImageButton.ImageButtonStyle();
        playButtonStyle.up = playButtonDrawable;
        ImageButton playButton = new ImageButton(playButtonStyle);
        stage.addActor(playButton);
        playButton.setSize(pbW, pbH);
        playButton.setPosition(pbX, pbY);
//        pW =700;
//        pH = 400;
//        pbX = (Gdx.graphics.getWidth() - pW) / 2f; // Center horizontally
//        pbY = (Gdx.graphics.getHeight() - pH) / 2f; // Center vertically

        stage.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                float adjustedY = Gdx.graphics.getHeight() - y;
//                if (x>=pbX && x<=pbX+pW && y>=pbY && y<=pbY+pH){
//                    main.setScreen(new Level_selector(main));}
                if (x>=sX && x<=sX+sW && adjustedY>=sY && y<=sY+sH){
                    main.setScreen(new Settings_page(main));
                }
            }
        });
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Level_selector(main));
            }
        });
    }
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        batch.draw(playButtonTexture, pbX, pbY, pW, pH);// Draw the button
        batch.draw(settingsButtonTexture, sX, sY, sW, sH);
        batch.end();

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
        playButtonTexture.dispose(); // Dispose the button texture
        batch.dispose();
    }

}

package io.github.KunalSuman.Angry_Bird;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.Levels.Level2;
import io.github.KunalSuman.Angry_Bird.Levels.Level3;
import io.github.KunalSuman.Angry_Bird.Levels.Level4;
import io.github.KunalSuman.Angry_Bird.Levels.Level5;
import io.github.KunalSuman.Angry_Bird.Main;
import io.github.KunalSuman.Angry_Bird.Menu_page;

public class Completed_Level extends ScreenAdapter {
    public Texture background;
    public AssetManager assetManager;
    private Stage stage;
    public SpriteBatch batch;
    private Texture next_Level_texture;
    public Texture backButtonTexture;
    private float bbX,bbY,bbW,bbH;
    private float nbX,nbY,nbW,nbH;
    public Main main;
    public OrthographicCamera camera;
    public int currentLevel ;

    public Completed_Level(Main main,int currentLevel) {
        this.main = main;
        this.currentLevel = currentLevel;
        this.stage = new Stage(new ScreenViewport());
        assetManager = new AssetManager();
        //background = new Texture("BACKGROUNDS_GE_1.png");
        //next_Level_texture = new Texture("next_level_button.png");
        //backButtonTexture = new Texture("backButton.png");
        batch = new SpriteBatch();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        bbW = 100;
        bbH = 100;
        bbX= 0;
        bbY = 0;
        nbW = 100;
        nbH = 100;
        nbX = Gdx.graphics.getWidth()-nbW;
        nbY = 0;

//        stage.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                float adjustedY = Gdx.graphics.getHeight() - y;
////                if (x>=pbX && x<=pbX+pW && y>=pbY && y<=pbY+pH){
////                    main.setScreen(new Level_selector(main));}
//                if (x>=bbX && x<=bbX+bbW && adjustedY>=bbY && y<=bbY+bbH){
//                    main.setScreen(new Menu_page(main));
//                }else if (x>=nbX && x<=nbX+nbW && adjustedY>=nbY && y<=nbY+nbH){
//                    if (currentLevel == 1){
//                        main.setScreen(new Level2(main));
//                    }else if (currentLevel == 2){
//                        main.setScreen(new Level3(main));
//                    }else if (currentLevel == 3){
//                        main.setScreen(new Level4(main));
//                    } else if (currentLevel == 4) {
//                        main.setScreen(new Level5(main));
//                    }else if (currentLevel == 5){
//                        main.setScreen(new Level4(main));
//                    }
//                }
//            }
//        });

    }
    public void render(float delta) {
        camera.update();
        if (currentLevel == 1){
            main.setScreen(new Level2(main));
        }else if (currentLevel == 2){
            main.setScreen(new Level3(main));
        }else if (currentLevel == 3){
            main.setScreen(new Level4(main));
        } else if (currentLevel == 4) {
            main.setScreen(new Level5(main));
        }else if (currentLevel == 5){
            main.setScreen(new Level4(main));
        }
        batch.begin();
        //batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());// Draw the button
        //batch.draw(next_Level_texture, nbX, nbY, nbW, nbH);
        //batch.draw(backButtonTexture, bbX, bbY, bbW, bbH);
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
        next_Level_texture.dispose();
        batch.dispose();
        assetManager.dispose();
        next_Level_texture.dispose();
        backButtonTexture.dispose();
    }

}

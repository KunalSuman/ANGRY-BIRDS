package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;



import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.KunalSuman.Angry_Bird.Levels.*;
import io.github.KunalSuman.Angry_Bird.Main;
import io.github.KunalSuman.Angry_Bird.Menu_page;

public class LostLevel extends ScreenAdapter{


        public Texture background;
        public AssetManager assetManager;
        private Stage stage;
        public SpriteBatch batch;
        private Texture next_Level_texture;
        private Texture lost_level_texture;
        public Texture backButtonTexture;
        private float bbX,bbY,bbW,bbH;
        private float nbX,nbY,nbW,nbH;
        public Main main;
        public int currentLevel = 0;
        public OrthographicCamera camera ;
        public OrthogonalTiledMapRenderer renderer ;
        public LostLevel(Main main,int currentLevel) {
            this.main = main;
            this.stage = new Stage(new ScreenViewport());
            this.currentLevel = currentLevel;
            assetManager = new AssetManager();
            System.out.println(currentLevel);
            camera = new OrthographicCamera();
            camera.setToOrtho(false, 1920, 1080);
            this.lost_level_texture=new Texture("Level failed.png");
            if (currentLevel==1){

                renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("LEVEL1.tmx"));

            }else if (currentLevel==2){

                renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("LEVEL2.tmx"));

            }else if (currentLevel==3){

                renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("LEVEL3.tmx"));

            }else if (currentLevel==4){

                renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("LEVEL4.tmx"));

            }else if (currentLevel==5){

                renderer = new OrthogonalTiledMapRenderer(new TmxMapLoader().load("LEVEL5.tmx"));

            }
            //background = new Texture("BACKGROUNDS_GE_1.png");
            next_Level_texture = new Texture("next_level_button.png");
            backButtonTexture = new Texture("backButton.png");
            batch = new SpriteBatch();
            stage = new Stage();
            Gdx.input.setInputProcessor(stage);

            stage.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    float adjustedY = Gdx.graphics.getHeight() - y;
//                if (x>=pbX && x<=pbX+pW && y>=pbY && y<=pbY+pH){
//                    main.setScreen(new Level_selector(main));}
                    if (x>=bbX && x<=bbX+bbW && adjustedY>=bbY && y<=bbY+bbH){
                        main.setScreen(new Menu_page(main));
                    }else if (x>=nbX && x<=nbX+nbW && adjustedY>=nbY && y<=nbY+nbH){
                        main.setScreen(new Level1(main));
                    }
                }
            });
        }
        public void render(float delta) {
            camera.update();
            renderer.setView(camera);
            renderer.render();
            batch.begin();

            batch.draw(lost_level_texture,400,200,1100,800);
            batch.draw(next_Level_texture, nbX, nbY, nbW, nbH);
            batch.draw(backButtonTexture, bbX, bbY, bbW, bbH);
            batch.end();
            // Render the stage (buttons, if any)
            stage.act(delta);
            stage.draw();
        }
        @Override
        public void resize(int width, int height) {
            stage.getViewport().update(width, height, true);
            bbW = 100;
            bbH = 100;
            bbX= 0;
            bbY = 0;
            nbW = 400;
            nbH = 100;
            nbX = Gdx.graphics.getWidth()-nbW;
            nbY = 0;
        }
        public void dispose() {
            stage.dispose();
            background.dispose();
            next_Level_texture.dispose();
            batch.dispose();
        }
}



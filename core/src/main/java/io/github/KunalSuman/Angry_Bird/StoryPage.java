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

import java.awt.*;
import java.util.ArrayList;

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
    ArrayList<Texture> storypagesarray = new ArrayList<>();
    public int time=0;
    public int loadedframes =0;
    int framesLoaded = 0;

    public StoryPage(Main main) {
        this.main = main;

        Texture firstPage = new Texture(("cut1.png"));
        storypagesarray.add(firstPage);
        loadedframes++;
        Texture secondPage = new Texture(("cut2.png"));
        storypagesarray.add(secondPage);
        loadedframes++;
        Texture thirdPage = new Texture(("cut3.png"));
        storypagesarray.add(thirdPage);
        loadedframes++;
        Texture fourthPage = new Texture(("cut4.png"));
        storypagesarray.add(fourthPage);
        loadedframes++;
        Texture fifthPage = new Texture(("cut5.png"));
        storypagesarray.add(fifthPage);
        loadedframes++;
        Texture sixthPage = new Texture(("cut6.png"));
        storypagesarray.add(sixthPage);
        loadedframes++;
        Texture seventhPage = new Texture(("cut7.png"));
        storypagesarray.add(seventhPage);
        loadedframes++;
        Texture eightPage = new Texture(("cut8.png"));
        storypagesarray.add(eightPage);
        loadedframes++;
        Texture ninePage = new Texture("cut9.png");
        storypagesarray.add(ninePage);
        loadedframes++;
        Batch = new SpriteBatch();
        assetManager = new AssetManager();
        assetManager.load(("Loading_screen.jpg"), Texture.class);
        assetManager.load(("Levels_page.png"), Texture.class);
    }
    public static boolean numberOfFramesLoaded(int frames1,int frames2){
        if (frames1 == frames2){
            return true;
        }else {
            return false;
        }
    }
    public void render(float delta) {
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        if (time<=50){
            Batch.begin();
            Batch.draw(storypagesarray.get(0),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==0){
                framesLoaded++;
            }
        }else if (time >50 && time<=100){
            Batch.begin();
            Batch.draw(storypagesarray.get(1),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==1){
                framesLoaded++;
            }
        }else if(time>100 && time<=150) {
            Batch.begin();
            Batch.draw(storypagesarray.get(2),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==2){
                framesLoaded++;
            }
        }else if(time>150 && time<=200) {
            Batch.begin();
            Batch.draw(storypagesarray.get(3),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==3){
                framesLoaded++;
            }
        }
        else if(time>200 && time<=250) {
            Batch.begin();
            Batch.draw(storypagesarray.get(4),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==4){
                framesLoaded++;
            }
        }
        else if(time>250 && time<=300) {
            Batch.begin();
            Batch.draw(storypagesarray.get(5),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==5){
                framesLoaded++;
            }
        }
        else if(time>300 && time<=350) {
            Batch.begin();
            Batch.draw(storypagesarray.get(6),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==6){
                framesLoaded++;
            }
        }
        else if(time>350 && time<=400) {
            Batch.begin();
            Batch.draw(storypagesarray.get(7),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==7){
                framesLoaded++;
            }
        }else if (time>400 && time<=500) {
            Batch.begin();
            Batch.draw(storypagesarray.get(8),0,0,1920,1080);
            Batch.end();
            if (framesLoaded ==8){
                framesLoaded++;
            }
        }
        else{
            if (numberOfFramesLoaded(framesLoaded,loadedframes)) {
                System.out.println(framesLoaded + "loaded lmao gods");
                System.out.println(loadedframes + "frames godspeed");
                main.setScreen(new Menu_page(main));
            }else{
                main.setScreen(new Loading_page(main));
            }



        }
        System.out.println(framesLoaded);

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


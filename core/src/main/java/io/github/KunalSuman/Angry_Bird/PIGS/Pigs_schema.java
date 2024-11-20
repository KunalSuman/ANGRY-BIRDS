package io.github.KunalSuman.Angry_Bird.PIGS;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Pigs_schema {
    protected int aromur ;
    protected int hitpoints ;
    public TextureRegion texture ;
    protected int dead ;
    public float height ;
    public float width ;
    public Pigs_schema(int aromur, int hitpoints, Texture texture, int dead, float height, float width) {
        this.aromur = aromur;
        this.hitpoints = hitpoints;
        this.texture = new TextureRegion(texture);
        this.dead = dead;
        this.height = height ;
        this.width = width ;
    }
}

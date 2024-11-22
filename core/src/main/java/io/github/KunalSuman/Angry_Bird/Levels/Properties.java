package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.Serializable;

public class Properties implements Serializable {
    public transient TextureRegion texture;
    public float height ;
    public float width ;
    public float health ;
    public int objectId;
    public float dead ;

    public Properties(Texture texture, float height, float width, float health) {
        this.texture = new TextureRegion(texture);
        this.height = height;
        this.width = width;
        this.health = health;
    }
    public Properties(Texture texture, float height, float width, float health,int objectId) {
        this.texture = new TextureRegion(texture);
        this.height = height;
        this.objectId = objectId;
        this.width = width;
        this.health = health;
    }
    public Properties(TextureRegion texture, float height, float width, float health , float dead) {
        this.texture = new TextureRegion(texture);
        this.height = height;
        this.width = width;
        this.health = health;
        this.dead = dead;
    }
}

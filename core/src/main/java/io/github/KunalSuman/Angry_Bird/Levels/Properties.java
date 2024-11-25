package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.Serializable;

public class Properties implements Serializable {
    public transient TextureRegion texture;
    public float height;
    public float width ;
    public Integer health ;
    public int objectId;
    public boolean dead ;
    public int type;
    public int damage;
    public boolean isBird;
    public int val ;
    public Properties(Texture texture,int damage, float height, float width, int health,boolean isBird) {
        this.texture = new TextureRegion(texture);
        this.height = height;
        this.isBird = isBird;
        this.width = width;
        this.health = health;
        this.damage = damage;
        this.type = 1 ;
    }
    public Properties(Texture texture, float height, float width, int health,int objectId) {
        this.texture = new TextureRegion(texture);
        this.height = height;
        this.objectId = objectId;
        this.width = width;
        this.health = health;
        this.type = 0;
    }
    public Properties(Texture texture, float height, float width, int health , boolean dead) {
        this.texture = new TextureRegion(texture);
        this.height = height;
        this.width = width;
        this.health = health;
        this.dead = dead;
        this.type = 2;
    }
    public Properties(int val){
        this.type = 3;
        this.val = val;
        this.health = 10000000;
    }
    public Properties(int val,boolean isStatic){
        this.health = 10000;
        this.type = 4;
    }

}

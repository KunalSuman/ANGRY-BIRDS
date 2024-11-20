package io.github.KunalSuman.Angry_Bird.Levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Properties {
    public TextureRegion texture;
    public float height ;
    public float width ;
    public float health ;

    public Properties(Texture texture, float height, float width, float health) {
        this.texture = new TextureRegion(texture);
        this.height = height;
        this.width = width;
        this.health = health;
    }
}

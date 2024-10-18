package io.github.KunalSuman.Angry_Bird.PIGS;

import com.badlogic.gdx.graphics.Texture;

public class Pigs_schema {
    protected int aromur ;
    protected int hitpoints ;
    protected Texture texture ;
    Pigs_schema(int aromur, int hitpoints, Texture texture) {
        this.aromur = aromur;
        this.hitpoints = hitpoints;
        this.texture = texture;
    }
}

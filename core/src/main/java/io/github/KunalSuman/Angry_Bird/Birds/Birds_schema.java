package io.github.KunalSuman.Angry_Bird.Birds;

import com.badlogic.gdx.graphics.Texture;

public class Birds_schema {
    protected Texture texture ;
    protected int hitpoints ;
    protected int velocity ;
    protected int ability ;
    protected String name ;

    Birds_schema(Texture texture, int hitpoints, int velocity, int ability ,String name) {
        this.texture = texture ;
        this.hitpoints = hitpoints ;
        this.velocity = velocity ;
        this.ability = ability ;
        this.name = name;
    }
}

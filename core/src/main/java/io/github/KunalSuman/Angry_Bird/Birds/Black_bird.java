package io.github.KunalSuman.Angry_Bird.Birds;

import com.badlogic.gdx.graphics.Texture;

public class Black_bird extends Birds_schema implements Birds{
    Black_bird(Texture texture, int hitpoints, int velocity, int ability , String name) {
        super(texture, hitpoints, velocity, ability , name);
    }

    @Override
    public void bird_ability() {
        this.ability =  1 ;
    }

    @Override
    public void bird_hitpoints() {
        this.hitpoints = 5 ;
    }

    @Override
    public void bird_velocity() {
        this.velocity = 5 ;
    }

    @Override
    public void bird_texture() {
        this.texture = new Texture("Black_bird.png");
    }

    @Override
    public void bird_name() {
        this.name = "BOMB" ;
    }
}

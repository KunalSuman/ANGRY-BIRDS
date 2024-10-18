package io.github.KunalSuman.Angry_Bird.Birds;

import com.badlogic.gdx.graphics.Texture;

public class Blue_bird extends Birds_schema implements Birds{

    Blue_bird(Texture texture , int ability , int hitpoints , int velocity , String name){
        super(texture , ability , hitpoints , velocity , name);
    }

    public void bird_ability() {
        this.ability = 2;
    }

    @Override
    public void bird_hitpoints() {
        this.hitpoints = 1 ;
    }

    @Override
    public void bird_velocity() {
        this.velocity = 3 ;
    }

    @Override
    public void bird_texture() {
        this.texture = new Texture("Black_bird.png");
    }

    @Override
    public void bird_name() {
        this.name = "BLUES" ;
    }
}

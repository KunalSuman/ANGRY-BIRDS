package io.github.KunalSuman.Angry_Bird.Birds;

import com.badlogic.gdx.graphics.Texture;

public class Red_bird extends Birds_schema implements Birds{
    Red_bird(Texture texture , int velocity , int ability , int hitpoints , String name){
        super(texture , velocity , ability , hitpoints , name);

    }
    @Override
    public void bird_ability() {
        this.ability = 3;
    }

    @Override
    public void bird_hitpoints() {
        this.hitpoints = 2;
    }

    @Override
    public void bird_velocity() {
        this.velocity = 3;
    }

    @Override
    public void bird_texture() {
        this.texture = new Texture("red_bird.png");
    }

    @Override
    public void bird_name() {
        this.name = "RED";
    }
}

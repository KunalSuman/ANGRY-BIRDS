package io.github.KunalSuman.Angry_Bird.Birds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

public class Black_bird extends Birds_schema implements Birds{
    Black_bird(Body body, World world, Texture Red_bird , int velocity , int ability , int hitpoints , String name , int locked) {
        super(body, world ,Red_bird, hitpoints , velocity , ability , name ,locked);
    }

    @Override
    public void createBirdBody(BodyDef bodyDef, BodyDef.BodyType bodyType, float initialX, float initialY, Properties properties) {

    }

    @Override
    public void createBirdFixture(FixtureDef birdFixture, int radius) {

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

    @Override
    public void is_locked() {
        this.locked = 1 ;
    }
}

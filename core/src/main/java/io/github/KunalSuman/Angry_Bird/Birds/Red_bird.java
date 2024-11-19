package io.github.KunalSuman.Angry_Bird.Birds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

public class Red_bird extends Birds_schema implements Birds{
    BodyDef bodyDef;
    Properties propertyBird;
    private FixtureDef birdFixture;

    public Red_bird(Body body, World world, Texture Red_bird , int velocity , int ability , int hitpoints , String name , int locked){
        super(body, world ,Red_bird, hitpoints , velocity , ability , name ,locked);

    }

    @Override
    public void createBirdBody(BodyDef bodyDef, BodyDef.BodyType bodyType, float initialX, float initialY,Properties propertyBird) {
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(initialX ,initialY);
        this.bodyDef = bodyDef;
        this.propertyBird = propertyBird;
        this.birdBody = world.createBody(bodyDef);
        this.birdBody.setUserData(propertyBird);
    }
    public void relocateBirdBody(){
        world.destroyBody(birdBody);
        Vector2 newPosition = new Vector2(325,690);
        bodyDef.position.set(newPosition);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        this.birdBody = world.createBody(bodyDef);
        this.birdBody.setUserData(propertyBird);
        this.createBirdFixture(birdFixture,20);
    }
    public Body getBirdBody(){
        return birdBody;
    }
    @Override
    public void createBirdFixture(FixtureDef birdFixture, int radius) {
        this.birdFixture = birdFixture;
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(radius);
        birdFixture.shape = circleShape ;
        birdFixture.density = 0.15f ;
        birdFixture.restitution = 0.5f ;
        birdBody.createFixture(birdFixture).setUserData("Red_bird");
    }
    public Vector2 getPosition(){
        return birdBody.getPosition();
    }

    public void setPosition(Vector2 position){

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

    @Override
    public void is_locked() {
        this.locked = 0;
    }
}

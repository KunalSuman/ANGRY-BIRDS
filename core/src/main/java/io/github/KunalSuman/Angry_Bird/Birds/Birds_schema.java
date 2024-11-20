package io.github.KunalSuman.Angry_Bird.Birds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class Birds_schema {
    protected Texture texture ;
    protected Body birdBody;
    protected Vector3 startPosition = new Vector3();
    protected Vector3 endPosition =new Vector3();
    protected int hitpoints ;
    protected World world;
    protected int velocity ;
    protected int ability ;
    protected String name ;
    protected int locked ;

    Birds_schema(Body body, World world, Texture texture, int hitpoints, int velocity, int ability , String name , int locked) {
        this.texture = texture ;
        this.world = world ;
        this.birdBody = body ;
        this.hitpoints = hitpoints ;
        this.velocity = velocity ;
        this.ability = ability ;
        this.name = name;
        this.locked = locked ;
    }
}

package io.github.KunalSuman.Angry_Bird.Create_Bodies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.physics.box2d.*;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

import java.util.ArrayList;

public class Birds_body {
    Texture Red_bird = new Texture("Red.png");
    Texture empty = new Texture("empty_png.png");
    Texture Bomb_bird = new Texture("bomb_bird.png");
    Texture Fat_bird = new Texture("blue_fat_bird.png");
    BodyDef bodyDef = new BodyDef();
    Body body2;
    World world;
    FixtureDef fixture2 = new FixtureDef();
    ArrayList<Body> birds_array = new ArrayList<>();

    public Birds_body(World world) {
        this.world = world;
        for(int i = 0 ; i < 6 ; i ++){
            bodyDef.type = BodyDef.BodyType.DynamicBody;
            if(i==0){
                bodyDef.position.set(500 ,690);
            }else{
                bodyDef.position.set(400,490);
            }

            body2 = world.createBody(bodyDef);

            CircleShape circleShape = new CircleShape();
            circleShape.setRadius(30);

            fixture2.shape = circleShape ;
            fixture2.density = 0.15f ;
            fixture2.restitution = 0.5f ;
            body2.createFixture(fixture2).setUserData("Bird");
            Properties birdBodyProperty = null;
            if(i ==  0){
                birdBodyProperty = new Properties(Red_bird,400,30,30,100,true);
            }else if(i ==  1){
                birdBodyProperty = new Properties(empty,400,30,30,100,true);
            }else if(i ==  2){
                birdBodyProperty = new Properties(Bomb_bird,400,30,30,100,true);
            }else if(i == 3){
                birdBodyProperty = new Properties(empty,400,30,30,100,true);
            }else if(i ==  4){
                birdBodyProperty = new Properties(Fat_bird,400,30,30,100,true);
            } else if(i == 5){
                birdBodyProperty = new Properties(empty,400,30,30,100,true);
            }
            body2.setUserData(birdBodyProperty);
            if(i>0){
                body2.setActive(false);
            }
            birds_array.add(body2);
        }
    }
    public ArrayList<Body> return_array() {
        return birds_array;
    }

}

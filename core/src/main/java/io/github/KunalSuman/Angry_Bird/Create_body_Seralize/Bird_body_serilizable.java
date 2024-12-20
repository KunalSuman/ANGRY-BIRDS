package io.github.KunalSuman.Angry_Bird.Create_body_Seralize;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;
import io.github.KunalSuman.Angry_Bird.GameSaver;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

import java.util.ArrayList;

public class Bird_body_serilizable {
    BodyDef bodyDef = new BodyDef();
    Body body2;
    FixtureDef fixture2 = new FixtureDef();
    Texture Red_bird = new Texture("Red.png");
    Texture empty = new Texture("empty_png.png");
    Texture Bomb_bird = new Texture("bomb_bird.png");
    Texture Fat_bird = new Texture("blue_fat_bird.png");
    ArrayList<Body> birds_array = new ArrayList<>();
    public Bird_body_serilizable(World world, GameSaver g1) {
        int n = g1.birdPositionX.size();
        if (g1.birdPositionX.size() == 5) {
            n = 3;
        }else if (g1.birdPositionX.size() == 3) {
            n = 2;
        } else if (g1.birdPositionX.size() == 2) {
            n=1;
        }else if (g1.birdPositionX.size() == 4) {
            n= 1;
        }
        for(int i = 0 ; i < n ; i ++){
            bodyDef.type = BodyDef.BodyType.DynamicBody;
            bodyDef.position.set(g1.birdPositionX.get(i) ,g1.birdPositionY.get(i));
            body2 = world.createBody(bodyDef);
            CircleShape circleShape = new CircleShape();
            circleShape.setRadius(30);

            fixture2.shape = circleShape ;
            fixture2.density = 0.15f ;
            fixture2.restitution = 0.5f ;
            body2.createFixture(fixture2).setUserData("Bird");
            Properties birdBodyProperty = null;
            if(i ==  0){
                birdBodyProperty = new Properties(Red_bird,400,30,30,g1.birdHealth.get(i),true);
                body2.setLinearVelocity(g1.birdSpeedX.get(i),g1.birdSpeedY.get(i));
            }else if(i ==  1){
                birdBodyProperty = new Properties(empty,400,30,30,g1.birdHealth.get(i),true);
                body2.setLinearVelocity(g1.birdSpeedX.get(i),g1.birdSpeedY.get(i));
            }else if(i ==  2){
                birdBodyProperty = new Properties(Bomb_bird,400,30,30,g1.birdHealth.get(i),true);
                body2.setLinearVelocity(g1.birdSpeedX.get(i),g1.birdSpeedY.get(i));
            }else if(i == 3){
                birdBodyProperty = new Properties(empty,400,30,30,g1.birdHealth.get(i),true);
                body2.setLinearVelocity(g1.birdSpeedX.get(i),g1.birdSpeedY.get(i));
            }else if(i ==  4){
                birdBodyProperty = new Properties(Fat_bird,400,30,30,g1.birdHealth.get(i),true);
                body2.setLinearVelocity(g1.birdSpeedX.get(i),g1.birdSpeedY.get(i));
            }
            else if(i == 5){
                birdBodyProperty = new Properties(empty,400,30,30,g1.birdHealth.get(i),true);
                body2.setLinearVelocity(g1.birdSpeedX.get(i),g1.birdSpeedY.get(i));
            }
            body2.setUserData(birdBodyProperty);
            if(i>0){
                body2.setActive(false);
            }
            birds_array.add(body2);
        }
    }
    public ArrayList<Body> getBirds_array() {
        return birds_array;
    }
}

package io.github.KunalSuman.Angry_Bird.Create_Bodies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

import java.util.ArrayList;

public class Pigs_body {
    World world;
    BodyDef pig_body_def =new BodyDef();
    Body pig_body;
    PolygonShape pig_shape ;
    FixtureDef pig_fixture_def = new FixtureDef();
    Properties properties;
    Texture king_pig;
    Texture small_pig;
    Texture helmet_pig;
    ArrayList<Body> pigs_array = new ArrayList<>();
    public Pigs_body(World world , TiledMap map) {
        this.world = world;
        int objectIdpigs = 0;
        king_pig = new Texture("king_pig.png");
        small_pig = new Texture("small_pig.png");
        helmet_pig = new Texture("helmet_pig.png");
        for(MapObject object1 : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle pigs = ((RectangleMapObject) object1).getRectangle();
            pig_body_def.type = BodyDef.BodyType.DynamicBody;
            pig_body_def.position.set(pigs.x + pigs.width/2, pigs.y + pigs.height/2);
            pig_body = world.createBody(pig_body_def);
            pig_shape = new PolygonShape();
            pig_shape.setAsBox(pigs.width/2, pigs.height/2);
            pig_fixture_def.shape = pig_shape;
            pig_body.createFixture(pig_fixture_def).setUserData("Pig");
            if(object1.getProperties().get("pig").equals("king_pig" )) {
                properties = new Properties(king_pig, pigs.height, pigs.width ,15,false,objectIdpigs);
                objectIdpigs++;
                pig_body.setUserData(properties);
            } else if (object1.getProperties().get("pig").equals("small_pig")) {
                properties = new Properties( small_pig, pigs.height, pigs.width , 10,false,objectIdpigs);
                objectIdpigs++;
                pig_body.setUserData(properties);
            }else if (object1.getProperties().get("pig").equals("helmet_pig" )) {
                properties = new Properties( helmet_pig,  pigs.height, pigs.width , 10,false,objectIdpigs);
                objectIdpigs++;
                pig_body.setUserData(properties);
            }
            pigs_array.add(pig_body);
        }
    }
    public ArrayList<Body> getPigs_array() {
        return pigs_array;
    }
}

package io.github.KunalSuman.Angry_Bird.Create_body_Seralize;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import io.github.KunalSuman.Angry_Bird.GameSaver;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

import java.util.ArrayList;

public class Pigs_body_serilizable {
    World world;
    Body pig_body;
    BodyDef pig_body_def = new BodyDef();
    PolygonShape pig_shape ;
    FixtureDef pig_fixture_def = new FixtureDef();
    Properties properties ;
    ArrayList<Body> pigs_array = new ArrayList<>();
    Texture king_pig ;
    Texture small_pig;
    Texture helmet_pig;
    public Pigs_body_serilizable(World world , TiledMap map , GameSaver g1) {
        this.world = world;
        int objectIdpiggy = -1;
        for(int i : g1.p2.keySet()){
            System.out.println(i);
            System.out.println(g1.p2.containsKey(i));
        }
        king_pig = new Texture("king_pig.png");
        small_pig = new Texture("small_pig.png");
        helmet_pig = new Texture("helmet_pig.png");
        for(MapObject object1 : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){

            Rectangle pigs = ((RectangleMapObject) object1).getRectangle();
            if (g1.p2.containsKey(objectIdpiggy)) {
                pig_body_def.type = BodyDef.BodyType.DynamicBody;
                pig_body_def.position.set(g1.piggyPositionX.get(objectIdpiggy), g1.piggyPositionY.get(objectIdpiggy));
                pig_body = world.createBody(pig_body_def);
                pig_shape = new PolygonShape();
                pig_shape.setAsBox(pigs.width / 2, pigs.height / 2);
                pig_fixture_def.shape = pig_shape;
                pig_body.createFixture(pig_fixture_def).setUserData("Pig");
            }
            if(object1.getProperties().get("pig").equals("king_pig" )) {
                if (g1.p2.containsKey(objectIdpiggy)) {
                    properties = new Properties(king_pig, pigs.height, pigs.width, g1.piggyHealth.get(objectIdpiggy), false,objectIdpiggy);
                    pig_body.setUserData(properties);
                    System.out.println("piggy health: "+g1.piggyHealth.get(objectIdpiggy));
                    pigs_array.add(pig_body);
                }
            } else if (object1.getProperties().get("pig").equals("small_pig")) {
                if (g1.p2.containsKey(objectIdpiggy)) {
                    properties = new Properties(small_pig, pigs.height, pigs.width, g1.piggyHealth.get(objectIdpiggy), false,objectIdpiggy);
                    pig_body.setUserData(properties);
                    pigs_array.add(pig_body);
                    System.out.println("piggy health: "+g1.piggyHealth.get(objectIdpiggy));
                }
            }else if (object1.getProperties().get("pig").equals("helmet_pig" )) {
                if (g1.p2.containsKey(objectIdpiggy)) {
                    properties = new Properties(helmet_pig, pigs.height, pigs.width, g1.piggyHealth.get(objectIdpiggy), false,objectIdpiggy);
                    pig_body.setUserData(properties);
                    pigs_array.add(pig_body);
                    System.out.println("piggy health: "+g1.piggyHealth.get(objectIdpiggy));
                }
            }
            objectIdpiggy++;
        }
    }
    public ArrayList<Body> getPigs_array() {
        return pigs_array;
    }
}

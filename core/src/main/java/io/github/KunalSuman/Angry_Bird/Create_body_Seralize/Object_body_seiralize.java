package io.github.KunalSuman.Angry_Bird.Create_body_Seralize;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import io.github.KunalSuman.Angry_Bird.GameSaver;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

import java.util.ArrayList;

public class Object_body_seiralize {
    World world ;
    TiledMap map;
    BodyDef bodyDef = new BodyDef();
    Body body ;
    PolygonShape shape;
    FixtureDef fixtureDef = new FixtureDef();
    Properties properties ;
    GameSaver g1 ;
    Array<Body> rectangles1 = new Array<>() ;
    public Object_body_seiralize(World world , TiledMap map , GameSaver g1) {
        this.g1 = g1 ;
        this.world = world;
        int objectId = -1;
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            int oid2=objectId+1;
            if (g1.p1.containsKey(oid2)) {
                Rectangle R1 = ((RectangleMapObject) object).getRectangle();
                bodyDef.type = BodyDef.BodyType.DynamicBody;
                bodyDef.position.set(g1.objectPositionsX.get(oid2) , g1.objectPositionsY.get(oid2));
                body = world.createBody(bodyDef);

                shape = new PolygonShape();
                shape.setAsBox(R1.width / 2, R1.height / 2);

                fixtureDef.shape = shape;
                fixtureDef.density = 0.05f;
                fixtureDef.friction = 0.5f;
                fixtureDef.restitution = 0.5f;
                body.createFixture(fixtureDef).setUserData("Obstacles");
            }
            Texture stone_long_vertical = new Texture("stone_long_vertical.png") ;
            Texture stone_medium_horizontal = new Texture("stone_medium_horizontal.png") ;
            Texture stone_long_horizontal = new Texture("stone_long_horizontal.png") ;
            Texture stone_small_vertical = new Texture("stone_small_vertical.png");
            Texture wood_small_horizontal = new Texture("wood_small_horizontal.png");
            Texture wood_long_horizontal = new Texture("wood_long_horizontal.png");
            Texture wood_long_vertical = new Texture("wood_long_vertical.png");
            Texture glass_small_vertical = new Texture("glass_small_vertical.png");
            Texture glass_long_horizontal = new Texture("glass_long_horizontal.png");
            Texture glass_long_vertical = new Texture("glass_long_vertical.png");
            Texture wood_box = new Texture("wood_box.png");
            Texture TNT = new Texture("TNT.png");
            if(object.getProperties().get("texture") == null){
            }
            if(object.getProperties().get("texture").equals("S_L_V" )){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_long_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            }
            else if (object.getProperties().get("texture").equals("S_M_H")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_medium_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if (object.getProperties().get("texture").equals("S_L_H")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_long_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if (object.getProperties().get("texture").equals("S_S_V")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_small_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if (object.getProperties().get("texture").equals("W_S_H")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(wood_small_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if(object.getProperties().get("texture").equals("W_S_V")){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(glass_small_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if (object.getProperties().get("texture").equals("G_L_H")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(glass_long_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if (object.getProperties().get("texture").equals("G_S_V")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(glass_small_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if (object.getProperties().get("texture").equals("TNT")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(TNT,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if (object.getProperties().get("texture").equals("W_B")) {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(wood_box,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            } else if(object.getProperties().get("texture").equals("W_L_V" )){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(wood_long_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            }
            else if(object.getProperties().get("texture").equals("W_L_H" )){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(wood_long_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            }
            else if(object.getProperties().get("texture").equals("G_L_V" )){
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(glass_long_vertical,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            }
            else {
                objectId++;
                if (g1.p1.containsKey(objectId)) {
                    properties = new Properties(stone_long_horizontal,g1.p1.get(objectId).height,g1.p1.get(objectId).width,g1.p1.get(objectId).health,g1.p1.get(objectId).objectId);
                    body.setUserData(properties);
                    body.setLinearVelocity(g1.objectSpeed.get(objectId).get(0),g1.objectSpeed.get(objectId).get(1));
                }
            }
            if (g1.p1.containsKey(objectId)) {
                rectangles1.add(body);

            }

        }

    }
    public Array<Body> return_array(){
        return rectangles1 ;
    }
}

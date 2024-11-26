package io.github.KunalSuman.Angry_Bird.Create_Bodies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

public class Structure_body {
    World world;
    Properties properties ;
    Array<Body> rectangles1 = new Array<>() ;
    BodyDef bodyDef = new BodyDef();
    Body body;
    PolygonShape shape ;
    FixtureDef fixtureDef = new FixtureDef();
    int objectId = 0;
    public Structure_body(World world , TiledMap map) {
        this.world = world;
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle R1 = ((RectangleMapObject) object).getRectangle();
            bodyDef.type = BodyDef.BodyType.DynamicBody;
            bodyDef.position.set(R1.x + R1.width/2, R1.y +R1.height/2);
            body = world.createBody(bodyDef);

            shape = new PolygonShape();
            shape.setAsBox(R1.width/2, R1.height/2);

            fixtureDef.shape = shape;
            fixtureDef.density = 0.05f;
            fixtureDef.friction = 0.5f ;
            fixtureDef.restitution = 0.5f;
            body.createFixture(fixtureDef).setUserData("Obstacles");
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
                System.out.println("false");
            }
            if(object.getProperties().get("texture").equals("S_L_V" )){
                properties = new Properties(stone_long_vertical,R1.height,R1.width,30,objectId);
                objectId++;
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("S_M_H")) {
                properties = new Properties(stone_medium_horizontal,R1.height,R1.width,30,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("S_L_H")) {
                properties = new Properties(stone_long_horizontal,R1.height,R1.width,30,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("S_S_V")) {
                properties = new Properties(stone_small_vertical,R1.height,R1.width,30,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("W_S_H")) {
                properties = new Properties(wood_small_horizontal,R1.height,R1.width,20,objectId);
                objectId++;
                body.setUserData(properties);
            } else if(object.getProperties().get("texture").equals("W_S_V")){
                properties = new Properties(glass_small_vertical,R1.height,R1.width,20,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("G_L_H")) {
                properties = new Properties(glass_long_horizontal,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("G_S_V")) {
                properties = new Properties(glass_small_vertical,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("TNT")) {
                properties = new Properties(TNT,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            } else if (object.getProperties().get("texture").equals("W_B")) {
                properties = new Properties(wood_box,R1.height,R1.width,20,objectId);
                objectId++;
                body.setUserData(properties);
            } else if(object.getProperties().get("texture").equals("W_L_V" )){
                properties = new Properties(wood_long_vertical,R1.height,R1.width,20,objectId);
                objectId++;
                body.setUserData(properties);
            }
            else if(object.getProperties().get("texture").equals("W_L_H" )){
                properties = new Properties(wood_long_horizontal,R1.height,R1.width,20,objectId);
                objectId++;
                body.setUserData(properties);
            }
            else if (object.getProperties().get("texture").equals("G_L_V")) {
                properties = new Properties(glass_long_vertical,R1.height,R1.width,20,objectId);
                objectId++;
                body.setUserData(properties);
            }
            else {
                properties = new Properties(stone_long_horizontal,R1.height,R1.width,10,objectId);
                objectId++;
                body.setUserData(properties);
            }
            rectangles1.add(body);
        }
    }
    public Array<Body> return_array(){
        return rectangles1;
    }
    public int object_id(){
        return objectId++ ;
    }
}

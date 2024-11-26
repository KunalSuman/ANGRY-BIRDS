package io.github.KunalSuman.Angry_Bird.Create_body_Seralize;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import io.github.KunalSuman.Angry_Bird.GameSaver;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

public class Structure_body_serilizable {
    World world;
    Body body4;
    BodyDef bodyDef = new BodyDef();
    PolygonShape shape = new PolygonShape();
    FixtureDef fixtureDef = new FixtureDef();
    Properties properties ;
    public Structure_body_serilizable(World world , TiledMap map , GameSaver g1) {
        this.world = world;
        for(MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle R2 = ((RectangleMapObject) object).getRectangle();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set(R2.x + R2.width/2 , R2.y + R2.height/2);
            body4 = world.createBody(bodyDef);

            shape = new PolygonShape();
            shape.setAsBox(R2.width/2, R2.height/2);
            fixtureDef.shape = shape;
            body4.createFixture(fixtureDef).setUserData("Border");
            properties = new Properties(1);
            body4.setUserData(properties);
        }
    }
}

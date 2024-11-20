package io.github.KunalSuman.Angry_Bird.Birds;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import io.github.KunalSuman.Angry_Bird.Levels.Properties;

public interface Birds {
    void createBirdBody(BodyDef bodyDef, BodyDef.BodyType bodyType, float initialX, float initialY, Properties properties);
    void createBirdFixture(FixtureDef birdFixture,int radius);
    void bird_ability();
    void bird_hitpoints();
    void bird_velocity();
    void bird_texture();
    void bird_name();
    void is_locked();
}

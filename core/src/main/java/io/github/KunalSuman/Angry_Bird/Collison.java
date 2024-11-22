package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.physics.box2d.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

public class Collison implements ContactListener {
    public final ArrayList<Body> bodiesToRemove = new ArrayList<>();
    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        Object propertiesA =fixtureA.getBody().getUserData();
        io.github.KunalSuman.Angry_Bird.Levels.Properties pA = (io.github.KunalSuman.Angry_Bird.Levels.Properties) propertiesA;
        Object propertiesB =fixtureB.getBody().getUserData();
        io.github.KunalSuman.Angry_Bird.Levels.Properties pB = (io.github.KunalSuman.Angry_Bird.Levels.Properties) propertiesB;
        if (fixtureA.getUserData() == null || fixtureB.getUserData() == null) {
            return;
        }if (fixtureA == null || fixtureB == null) {
            return;
        }
        if (fixtureA.getUserData().equals(fixtureB.getUserData()) && fixtureA.getBody().getLinearVelocity().y<30 ) {
            return;
        }
        if(fixtureA.getUserData().equals(fixtureB.getUserData()) && fixtureA.getBody().getLinearVelocity().y<30 && fixtureA.getBody().getLinearVelocity().y>-30){
            pA.health = pA.health-1;
        }

        if (pB.health>0) {
            pB.health=pB.health-pA.health;
            bodiesToRemove.add(fixtureA.getBody());
        }if (fixtureA.getBody().getLinearVelocity().len()>fixtureB.getBody().getLinearVelocity().len()) {
            System.out.println("Lmao Lmao!!");
        }

        System.out.println("The objects colliding are: "+fixtureA.getUserData()+" and"+fixtureB.getUserData());
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {

    }
    public ArrayList<Body> getBodiesToRemove(){
        return bodiesToRemove;
    }
}

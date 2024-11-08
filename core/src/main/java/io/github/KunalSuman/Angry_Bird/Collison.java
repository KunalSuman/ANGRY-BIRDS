package io.github.KunalSuman.Angry_Bird;

import com.badlogic.gdx.physics.box2d.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Collison implements ContactListener {

    public final ArrayList<Body> bodiesToRemove = new ArrayList<>();
    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        if (fixtureA.getUserData() == null || fixtureB.getUserData() == null) {
            return;
        }if (fixtureA == null || fixtureB == null) {
            return;
        }
        if (fixtureA.getUserData().equals(fixtureB.getUserData())) {
            return;
        }
        if (fixtureA.getBody().getLinearVelocity().len()<fixtureB.getBody().getLinearVelocity().len()) {
            bodiesToRemove.add(fixtureA.getBody());
        }if (fixtureA.getBody().getLinearVelocity().len()>fixtureB.getBody().getLinearVelocity().len()) {
            bodiesToRemove.add(fixtureB.getBody());
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

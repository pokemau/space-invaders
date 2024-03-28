package com.mau.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends Entity{

    public final int bulletSpeed = 500;


    public Bullet(Texture texture, Vector2 position, Vector2 direction) {
        super(texture, position, direction);
    }

    @Override
    public void update() {

        if (position.y > 498) {
            Player.playerState = Player.STATE.IDLE;
            setDirection(0, 0);
        }

        position.add( direction );

    }

    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }
}

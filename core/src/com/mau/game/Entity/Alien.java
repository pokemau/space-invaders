package com.mau.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;


public class Alien extends Entity {
    public static DIR dir;
    public final int alienSpeed = 200;

    long startTime;

    public Alien(Texture texture, Vector2 position, Vector2 direction) {
        super(texture, position, direction);

        dir = DIR.RIGHT;

        startTime = TimeUtils.millis();
    }

    @Override
    public void update() {

        long currTime = TimeUtils.millis();
        long elapsedTime = currTime - startTime;

        if (elapsedTime >= 800) {

            if (dir == DIR.RIGHT) {
                position.x += 10;

                if (position.x > (795 - texture.getWidth())) {
                    dir = DIR.LEFT;
                    position.x -= 10;
                    moveDown();
                }

            } else {
                position.x -= 10;

                if (position.x < 5) {
                    dir = DIR.RIGHT;
                    position.x += 10;
                    moveDown();
                }
            }
            startTime = currTime;
        }

    }

    private void moveDown() {
        position.y -= 10;
    }

}

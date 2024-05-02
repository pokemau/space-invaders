package com.mau.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mau.game.SpaceInvaders;


public class Player extends Entity{
    public enum STATE { IDLE, SHOOTING }

    private final int playerSpeed = 300;
    public static STATE playerState;

    public static Bullet bullet;



    public Player(Texture texture, Vector2 position, Vector2 direction) {
        super(texture, position, direction);
        playerState = STATE.IDLE;
        bullet = new Bullet(
                SpaceInvaders.bulletTex,
                new Vector2(position.x + 7, -20),
                new Vector2(0, 0));
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);

        bullet.draw(batch);
    }


    @Override
    public void update() {

        if (Gdx.input.isKeyPressed(Input.Keys.A)
                && position.x > 4) {

            move(DIR.LEFT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)
                && position.x < (797 - texture.getWidth())) {

            move(DIR.RIGHT);
        } else  {
            move(DIR.STOP);
        }


        // SHOOT
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)
                && playerState != STATE.SHOOTING) {

            shoot();
        }

        bullet.update();
        position.add(direction);
    }

    private void move(DIR d) {
        if (d == DIR.LEFT) {
            setDirection(-playerSpeed, 0);
        } else if (d == DIR.RIGHT) {
            setDirection(playerSpeed, 0);
        } else {
            setDirection(0, 0);
        }
    }

    private void shoot() {
        playerState = STATE.SHOOTING;
        bullet.setPosition(position.x + 7, position.y + 10);
        bullet.setDirection(0, bullet.bulletSpeed);
    }
}

package com.mau.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity{
    public enum state { SHOOTING, IDLE }

    private final int PLAYER_SPEED = 200;

    public state playerState;

    public Bullet bullet;

    private Vector2 bulletPos;


    public Player(Texture texture, Texture bulletTex, Rectangle rect) {
        super(texture, new Vector2((float) Gdx.graphics.getWidth() / 2, 0), rect);

        bulletPos = new Vector2(0, -20);
        bullet = new Bullet(bulletTex, bulletPos, new Rectangle(0, -20, 12, 12), this);
    }

    @Override
    public void Draw(SpriteBatch batch) {
        ProcessInput();
//        sprite.setPosition(position.x, position.y);
//        sprite.draw(batch);

        batch.draw(tex, rect.x, rect.y, rect.width, rect.height);

        bullet.Draw(batch);
    }

    public void ProcessInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
            System.exit(0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            rect.x -= PLAYER_SPEED * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            rect.x += PLAYER_SPEED * Gdx.graphics.getDeltaTime();

        if (rect.x < 0) { rect.x = 0; }
        if (rect.x > 800-27) { rect.x = 800-27; }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) &&
                playerState != state.SHOOTING) {

            bullet.rect.x = rect.x + 7;
            bullet.rect.y = 0;
            playerState = state.SHOOTING;
        }
    }
}

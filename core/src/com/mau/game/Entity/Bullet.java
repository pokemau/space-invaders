package com.mau.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends Entity{
    Player player;
    private final int BULLET_SPEED = 400;

    public Bullet(Texture texture, Vector2 position, Rectangle rect, Player player) {
        super(texture, position, rect);
        this.player = player;
    }

    @Override
    public void Draw(SpriteBatch batch) {
        float deltaTime = Gdx.graphics.getDeltaTime();

//        sprite.setPosition(position.x, position.y);
//        sprite.draw(batch);

        batch.draw(tex, rect.x, rect.y);

        if (player.playerState == Player.state.SHOOTING) {
            rect.y += deltaTime * BULLET_SPEED;
        } else if (player.playerState == Player.state.IDLE) {
            rect.y = -20;
        }

        if (rect.y >= 500)
            player.playerState = Player.state.IDLE;

    }
}

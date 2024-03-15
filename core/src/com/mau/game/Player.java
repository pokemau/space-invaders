package com.mau.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    private final Sprite sprite;
    private final int speed = 200;

    public Player(Texture img) {
        sprite = new Sprite(img);
        position = new Vector2((float) Gdx.graphics.getWidth() / 2, 10);
    }

    public void Draw(SpriteBatch batch) {
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }


    public void ProcessInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= speed * Gdx.graphics.getDeltaTime();
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += speed * Gdx.graphics.getDeltaTime();
        }

        if (position.x < 0) position.x = 0;
        if (position.x > (800-27)) position.x = 800-27;
    }
}

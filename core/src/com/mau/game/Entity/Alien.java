package com.mau.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Alien extends Entity{

    public Alien(Texture texture, Vector2 position, Rectangle rect) {
        super(texture, position, rect);

    }

    @Override
    public void Draw(SpriteBatch batch) {
        sprite.setPosition(position.x, position.y);

        sprite.draw(batch);

    }
}

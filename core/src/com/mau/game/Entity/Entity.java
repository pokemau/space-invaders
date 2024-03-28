package com.mau.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
    public Vector2 position;
    public Vector2 direction;
    public Texture texture;


    public Entity(Texture texture, Vector2 position, Vector2 direction) {
        this.texture = texture;
        this.position = position;
        this.direction = direction;
    }

    public abstract void update();

    public Rectangle getBounds() {
        return new Rectangle(
                position.x,
                position.y,
                texture.getWidth(),
                texture.getHeight());
    }

    public void setDirection(float x, float y) {
        direction.add(x, y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
}

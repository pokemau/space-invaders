package com.mau.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
    public Vector2 position;
    public Sprite sprite;
    public Texture tex;
    public Rectangle rect;


    public Entity(Texture texture, Vector2 position, Rectangle rect) {
        this.tex = texture;
        sprite = new Sprite(texture);
        this.position = position;
        this.rect = rect;
    }

    public abstract void Draw(SpriteBatch batch);
}

package com.mau.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mau.game.Entity.Alien;
import com.mau.game.Entity.Player;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.Iterator;

public class SpaceInvaders extends ApplicationAdapter {
	final int SCR_W = 800;
	final int SCR_H = 500;

	SpriteBatch batch;
	OrthographicCamera camera;

	public static Texture playerTex;
	public static Texture alienTex;
	public static Texture bulletTex;

	Player player;
	Alien alien;


	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_W, SCR_H);

		batch = new SpriteBatch();

		alienTex = new Texture("AlienSprite.png");
		playerTex = new Texture("PlayerSprite.png");
		bulletTex = new Texture("bullet.png");


		player = new Player(
				playerTex,
				new Vector2((float)Gdx.graphics.getWidth()/2, 10),
				new Vector2(0, 0));

		alien = new Alien(
				alienTex,
				new Vector2((float)Gdx.graphics.getWidth()/2, 450),
				new Vector2(0, 0));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		/////////////////////// DRAW ///////////////////////

		player.draw(batch);
		alien.draw(batch);


		/////////////////////// DRAW ///////////////////////
		batch.end();

		player.update();
		alien.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerTex.dispose();
		alienTex.dispose();
	}
}

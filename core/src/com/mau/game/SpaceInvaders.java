package com.mau.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceInvaders extends ApplicationAdapter {
	final int SCR_W = 800;
	final int SCR_H = 500;
	SpriteBatch batch;
	Texture playerTex;
	Texture alienTex;

	Player player;
	Alien alien;

	OrthographicCamera camera;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_W, SCR_H);
		batch = new SpriteBatch();

		alienTex = new Texture("AlienSprite.png");
		playerTex = new Texture("PlayerSprite.png");

		player = new Player(playerTex);
		alien = new Alien(alienTex);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		alien.Draw(batch);
		player.Draw(batch);

		batch.end();

		player.ProcessInput();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerTex.dispose();
		alienTex.dispose();
	}

	@Override
	public void resize(int width, int height) {
//		batch.getProjectionMatrix().setToOrtho2D(0, 0,  width, height);
	}
}

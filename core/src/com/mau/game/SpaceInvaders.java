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

	Texture playerTex;
	Texture alienTex;
	Texture bulletTex;

	Player player;

	OrthographicCamera camera;

	ArrayList<Alien> aliens;

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
				bulletTex,
				new Rectangle((float) Gdx.graphics.getWidth() / 2, 0,
			26, 26));

		aliens = new ArrayList<>();

		generateAliens();
	}

	private void generateAliens() {

		Vector2 alienPos = new Vector2(((float) Gdx.graphics.getWidth() / 2) - (27*5), 450);

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 5; j++) {
				aliens.add(new Alien(
						alienTex,
						new Vector2(alienPos.x, alienPos.y),
						new Rectangle(alienPos.x, alienPos.y, 22, 22)));

				alienPos.y -= 30;
			}
			alienPos.x += 30;
			alienPos.y = 450;
		}
	}


	/*
	 * at start of game, create 10x5 grid of aliens in a grid
	 *
	 */

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		for (Alien a : aliens) {
			a.Draw(batch);
		}

		player.Draw(batch);

		batch.end();


		Iterator<Alien> iter = aliens.iterator();

		while (iter.hasNext()) {
			Rectangle alien = iter.next().rect;

			if (alien.overlaps(player.bullet.rect)) {
				player.playerState = Player.state.IDLE;
				iter.remove();
				break;
			}
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerTex.dispose();
		alienTex.dispose();
	}
}

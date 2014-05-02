package com.stevebough.gravity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class MainMenuScreen implements Screen
{

	final Gravity game;

	OrthographicCamera camera;

	public MainMenuScreen(final Gravity game)
	{
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1080, 1920);

	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		game.getBatch().begin();
		BitmapFont font = game.font;
		font.setScale(5);
		game.font.draw(game.getBatch(), "Welcome to Gravity!!! ", 100, 150);
		game.font.draw(game.getBatch(), "Tap anywhere to begin!", 100, 100);
		game.getBatch().end();

		if (Gdx.input.isTouched())
		{
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

}

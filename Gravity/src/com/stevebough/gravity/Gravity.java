package com.stevebough.gravity;

import java.util.List;
import java.util.Vector;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stevebough.gravity.game.GameBoard;

public class Gravity extends Game
{
	private SpriteBatch batch;
	public BitmapFont font;
	private final List<GameBoard> boards = new Vector<GameBoard>();

	@Override
	public void create()
	{
		setBatch(new SpriteBatch());
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
		GameBoard board = new GameBoard(5, 5, 0, 0, 540, 540);
		board.initialiseBoard();
		boards.add(board);

		board = new GameBoard(5, 5, 540, 108 * 3, 540, 540);
		board.initialiseBoard();
		boards.add(board);

		board = new GameBoard(5, 5, 0, 540 + 108, 540, 540);
		board.initialiseBoard();
		boards.add(board);

		board = new GameBoard(9, 5, 0, 1920 - 540, 972, 540);
		board.initialiseBoard();
		boards.add(board);
		GLTexture.setEnforcePotImages(false);
	}

	@Override
	public void render()
	{
		super.render(); // important!
	}

	@Override
	public void dispose()
	{
		getBatch().dispose();
		font.dispose();
	}

	public SpriteBatch getBatch()
	{
		return batch;
	}

	public void setBatch(SpriteBatch batch)
	{
		this.batch = batch;
	}

	public List<GameBoard> getBoards()
	{
		return boards;
	}
}
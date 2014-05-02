package com.stevebough.gravity;

import java.util.List;

import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.stevebough.gravity.game.GameBoard;

public class InputHandler implements GestureListener
{
	private final GameScreen screen;

	public InputHandler(GameScreen screen)
	{
		this.screen = screen;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button)
	{
		Vector3 worldCoordinates = new Vector3(x, y, 0);
		screen.getCamera().unproject(worldCoordinates);
		List<GameBoard> boards = screen.getGame().getBoards();
		for (GameBoard gameBoard : boards)
		{
			if (gameBoard.isLocationOnBoard((int)worldCoordinates.x, (int)worldCoordinates.y))
				gameBoard.initialiseBoard();
//				gameBoard.changePieceAt((int) x, (int) y);
		}
		return false;
	}

	@Override
	public boolean longPress(float x, float y)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2)
	{
		// TODO Auto-generated method stub
		return false;
	}

}

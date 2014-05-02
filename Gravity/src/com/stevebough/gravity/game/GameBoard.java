package com.stevebough.gravity.game;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.stevebough.gravity.game.GamePiece.Colour;

public class GameBoard extends Group
{
	public final static int HEIGHT = 9;
	public final static int WIDTH = 9;
	private final GamePiece[][] board;
	private final int piecesAcross;
	private final int piecesHigh;
	private final int boardWidth;
	private final int boardHeight;
	private final int boardLeft;
	private final int boardTop;
	
	public GameBoard(final int piecesAcross, final int piecesHigh, final int boardLeft, final int boardTop, final int boardWidth, final int boardHeight)
	{
		this.piecesAcross = piecesAcross;
		this.piecesHigh = piecesHigh;
		this.boardLeft = boardLeft;
		this.boardTop = boardTop;
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		board = new GamePiece[piecesHigh][piecesAcross];
	}
	
	public void initialiseBoard()
	{
		for (int y = 0 ; y < piecesHigh ; ++y)
		{
			for (int x = 0 ; x < piecesAcross ; ++x)
			{
				int random = (int) (Math.random() * 6);
				Colour colour = null;
				switch (random)
				{
					case 0:
						colour = Colour.Blue;
						break;
					case 1:
						colour = Colour.Green;
						break;
					case 2:
						colour = Colour.Orange;
						break;
					case 3:
						colour = Colour.Purple;
						break;
					case 4:
						colour = Colour.Red;
						break;
					case 5:
						colour = Colour.Yellow;
						break;
				}
				board[y][x] = new GamePiece(colour, x, y);
			}
		}
	}
	
	public GamePiece getPiece(int x, int y)
	{
		return board[y][x];
	}

	public int getPiecesAcross()
	{
		return piecesAcross;
	}
	public int getPiecesHigh()
	{
		return piecesHigh;
	}

	public int getBoardWidth()
	{
		return boardWidth;
	}
	public int getBoardHeight()
	{
		return boardHeight;
	}

	public int getBoardLeft()
	{
		return boardLeft;
	}

	public int getBoardTop()
	{
		return boardTop;
	}
	
	public boolean isLocationOnBoard(int x, int y)
	{
		if (x > boardLeft && x < (boardLeft + boardWidth) && y > boardTop && y < (boardTop + boardHeight))
			return true;
		return false;
	}

	public void changePieceAt(int x, int y)
	{
		int pieceX = (x - boardLeft) / boardWidth;
		int pieceY = (boardTop - y) / boardHeight;
		
		board[pieceX][pieceY] = new GamePiece(Colour.Red, x, y);
	}
}

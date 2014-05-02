package com.stevebough.gravity.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class GamePiece extends Actor
{
	public enum Colour { Red, Blue, Green, Yellow, Purple, Orange }
	
	private final Colour colour;
	private final int x;
	private final int y;
	
	public GamePiece(Colour colour, int x, int y)
	{
		this.colour = colour;
		this.x = x;
		this.y = y;
		this.addListener(new InputListener()
		{
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				// TODO Auto-generated method stub
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	public Colour getColour()
	{
		return colour;
	}
	
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha)
	{
		super.draw(batch, parentAlpha);
	}
}

package com.stevebough.gravity;

import com.badlogic.gdx.graphics.Texture;

public class MovablePiece 
{
	private final Texture texture;
	private float x;
	private float y;


	public MovablePiece(Texture texture, float x, float y)
	{
		this.texture = texture;
		this.x = x;
		this.y = y;
	}
	
	public Texture getTexture()
	{
		return texture;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

}

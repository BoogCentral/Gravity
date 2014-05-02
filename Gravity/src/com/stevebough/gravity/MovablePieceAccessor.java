package com.stevebough.gravity;

import aurelienribon.tweenengine.TweenAccessor;

public class MovablePieceAccessor  implements TweenAccessor<MovablePiece>
{
	public static final int POSITION_X = 1;
	public static final int POSITION_Y = 2;

	@Override
	public int getValues(MovablePiece target, int tweenType, float[] returnValues)
	{
		switch (tweenType)
		{
			case POSITION_X:
				returnValues[0] = target.getX();
				return 1;
			case POSITION_Y:
				returnValues[0] = target.getY();
				return 1;
		}
		return -1;
	}

	@Override
	public void setValues(MovablePiece target, int tweenType, float[] newValues)
	{
		switch (tweenType)
		{
			case POSITION_X:
				target.setX(newValues[0]);
				break;
			case POSITION_Y:
				target.setY(newValues[0]);
				break;
		}
	}

}

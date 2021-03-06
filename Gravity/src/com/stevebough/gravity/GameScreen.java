package com.stevebough.gravity;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Bounce;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.stevebough.gravity.game.GameBoard;
import com.stevebough.gravity.game.GamePiece;

public class GameScreen implements Screen
{
	private final Gravity game;

	OrthographicCamera camera;
	Texture blueStarImage;
	Texture greenStarImage;
	Texture orangeStarImage;
	Texture purpleStarImage;
	Texture redStarImage;
	Texture yellowStarImage;
	Texture yellowStarImage2;
	private final Texture backgroundImage;
	TweenManager manager;
	MovablePiece mPiece;
	private final TextureAtlas textureAtlas;
	private final Animation animation;

	private float elapsedTime = 0;

	public GameScreen(final Gravity game)
	{
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1080, 1920);
		blueStarImage = new Texture(Gdx.files.internal("BlueStar2.png"));
		greenStarImage = new Texture(Gdx.files.internal("GreenStar2.png"));
		orangeStarImage = new Texture(Gdx.files.internal("OrangeStar2.png"));
		purpleStarImage = new Texture(Gdx.files.internal("PurpleStar2.png"));
		redStarImage = new Texture(Gdx.files.internal("RedStar2.png"));
		yellowStarImage = new Texture(Gdx.files.internal("YellowStar2.png"));
		yellowStarImage2 = new Texture(Gdx.files.internal("YellowStar2.png"));
		backgroundImage = new Texture(Gdx.files.internal("Backdrop1.png"));
		Gdx.input.setInputProcessor(new GestureDetector(new InputHandler(this)));
		manager = new TweenManager();
		Tween.registerAccessor(MovablePiece.class, new MovablePieceAccessor());
		mPiece = new MovablePiece(yellowStarImage, 0, 1860);
		Tween
				.to(mPiece, MovablePieceAccessor.POSITION_Y, 10.0f)
				.target(0)
				.ease(Bounce.OUT)
				.delay(1)
				.repeat(Tween.INFINITY, 2.5f)
				.start(manager);
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/spritesheet.atlas"));
		animation = new Animation(1 / 15f, textureAtlas.getRegions());
	}

	@Override
	public void dispose()
	{
		getGame().getBatch().dispose();
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();

		getGame().getBatch().setProjectionMatrix(camera.combined);
		getGame().getBatch().begin();
		getGame().getBatch().draw(backgroundImage, 0, 0);

		for (GameBoard board : getGame().getBoards())
		{
			// GameBoard board = game.getBoard();
			// int pieceHeight = 1080 / GameBoard.HEIGHT;
			int pieceWidth = board.getBoardWidth() / board.getPiecesAcross();
			int pieceHeight = board.getBoardHeight() / board.getPiecesHigh();
			for (int y = 0; y < board.getPiecesHigh(); ++y)
			{
				for (int x = 0; x < board.getPiecesAcross(); ++x)
				{
					GamePiece piece = board.getPiece(x, y);
					Texture t = null;
					switch (piece.getColour())
					{
						case Blue:
							t = blueStarImage;
							break;
						case Green:
							t = greenStarImage;
							break;
						case Orange:
							t = orangeStarImage;
							break;
						case Purple:
							t = purpleStarImage;
							break;
						case Red:
							t = redStarImage;
							break;
						case Yellow:
							t = yellowStarImage;
							break;
					}
					getGame().getBatch().draw(
							t,
							board.getBoardLeft() + x * pieceWidth,
							board.getBoardTop() + y * pieceHeight,
							pieceWidth,
							pieceHeight);
				}
			}
			getGame().getBatch().draw(mPiece.getTexture(), mPiece.getX(), mPiece.getY(), pieceWidth, pieceHeight);
			manager.update(delta);
		}

		elapsedTime += Gdx.graphics.getDeltaTime();
		getGame().getBatch().draw(animation.getKeyFrame(elapsedTime, true), 500, 0, 600, 400);
		getGame().getBatch().draw(animation.getKeyFrame(elapsedTime, true), 500, 400, 600, 400);

		getGame().getBatch().end();
	}

	@Override
	public void resize(int width, int height)
	{
		//
	}

	@Override
	public void pause()
	{
		//
	}

	@Override
	public void resume()
	{
		//
	}
	@Override
	public void show()
	{
		//
	}
	@Override
	public void hide()
	{
		//
	}
	public Gravity getGame()
	{
		return game;
	}
	public OrthographicCamera getCamera()
	{
		return camera;
	}
}

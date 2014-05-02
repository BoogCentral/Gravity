package com.stevebough.gravity;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Gravity";
		cfg.useGL20 = false;
		cfg.width = 650;
		cfg.height = 1200;

		new LwjglApplication(new Gravity(), cfg);
	}
}

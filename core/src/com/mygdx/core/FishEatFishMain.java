package com.mygdx.core;

import com.badlogic.gdx.Game;

public class FishEatFishMain extends Game {

	@Override
	public void create() {
		System.out.println("ZBGame Created!");
		AssetStation.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetStation.dispose();
		System.out.println("Help!!");
	}




}

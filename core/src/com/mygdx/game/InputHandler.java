package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;

/**
 * Created by Can Atay on 11/11/2015.
 */
public class InputHandler implements InputProcessor {
    private PlayerFish playerFish;

    // Ask for a reference to the Bird when InputHandler is created.
    public InputHandler(PlayerFish bird) {
        // myBird now represents the gameWorld's bird.
        playerFish = bird;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if(GameWorld.getGameState().equals("MainScreen")){

            if(screenX>300 && screenX<900 && screenY>713 && screenY<1300){

                GameWorld.updateGameState("PlayingGame");

            }





        }else if(GameWorld.getGameState().equals("PlayingGame")) {
            playerFish.onClick();
        }


        return true; // Return true to say we handled the touch.
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}

package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;

/**
 * Created by Can Atay on 11/11/2015.
 */
public class InputHandler implements InputProcessor {
    private PlayerFish playerFish;
    private SuperEffects superEffects;



    public static float positX=600-AssetStation.coin.getRegionWidth()/2;  //T
    public static float positY=0;//T
    public static float velocity=0; //T
    public boolean situationMiddle=false;
    public float previousX;
    public float previousY;



    // Ask for a reference to the Bird when InputHandler is created.
    public InputHandler(PlayerFish bird,SuperEffects superEffects) {
        // myBird now represents the gameWorld's bird.
        playerFish = bird;
        this.superEffects=superEffects;
    }




    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if(GameWorld.getGameState().equals("MainScreen")){

            if(screenX>800 && screenX<1200 && screenY>713 && screenY<1300){

                GameWorld.updateGameState("PlayingGame");

            }





        }else if(GameWorld.getGameState().equals("PlayingGame")) {


            //TESTING
            if(superEffects.getTypeOfSuperEffect().equals("coinThrow") && superEffects.hasPlayerThrownCoin()==false && screenX>(600)-AssetStation.coin.getRegionWidth()/2  ){
                AssetStation.healthgained.play();
                situationMiddle=true;
                previousX=screenX;
                previousY=screenY;


            }else {


                playerFish.onClick();
                situationMiddle=false;

            }
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


        if(situationMiddle==true){

            if(Math.abs(previousX-screenX)<40){

                //Coin not tossed enough,ignore
                velocity=0;
            }else{

                if(screenX>previousX){
                    superEffects.setxVelocity(Math.abs(previousX-screenX)*2);


                }else{
                    superEffects.setxVelocity(-Math.abs(previousX-screenX)*2);

                }



                if(screenY>previousY){
                    superEffects.setyVelocity(Math.abs(previousY-screenY)*2);


                }else{
                    superEffects.setyVelocity(-Math.abs(previousY-screenY)*2);



                }


//                superEffects.setyVelocity(Math.abs(previousY-screenY)*2);
                superEffects.playerHasThrownCoin();
                situationMiddle=false;

/*
                if(screenX>previousX){



                }else{



                }




                if(screenY>previousY){


                }else{



                }




                velocity=40;
                situationMiddle=false;*/

            }





        }



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

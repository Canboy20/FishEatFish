package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by Can Atay on 11/11/2015.
 */
public class InputHandler implements InputProcessor {
    private GameWorld world;
    private SuperEffects superEffects;
    private int count=2;



    public static float positX=600-AssetStation.coin.getRegionWidth()/2;  //T
    public static float positY=0;//T
    public static float velocity=0; //T
    public boolean situationMiddle=false;
    public float previousX;
    public float previousY;

    float x = Gdx.graphics.getWidth();
    float y = Gdx.graphics.getHeight();

    float ratioX =  1200/x; //being your screen size that you're developing with
    float ratioY =  1900/y;




    public InputHandler(GameWorld world,SuperEffects superEffects) {

        this.world = world;
        this.superEffects=superEffects;
    }




    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if(GameWorld.getGameState().equals("MainScreen")) {

            if (screenX * ratioX > 350 && screenX * ratioX < 850 && screenY * ratioY > 880 && screenY * ratioY < 1070) {



                world.changeState("PlayingGame");
                //GameWorld.updateGameState("PlayingGame");


            } else if (screenX * ratioX > 974 && screenX * ratioX < 1138 && screenY * ratioY > 1703 && screenY * ratioY < 1862) {
                Gdx.net.openURI("https://www.facebook.com/irfancan.atay");

            }


        }else if(GameWorld.getGameState().equals("GameOver")){
            if(count==2) {

                count = 0;
                GameWorld.updateGameState("MainScreen");
            }else{
                count++;
            }


        }else if(GameWorld.getGameState().equals("PlayingGame")) {


            //TESTING
            if(superEffects.getTypeOfSuperEffect().equals("coinThrow") && superEffects.hasPlayerThrownCoin()==false && screenX*ratioX>(600-AssetStation.coinLarge.getRegionWidth()/2) && screenX*ratioX< (600-AssetStation.coinLarge.getRegionWidth()/2) + AssetStation.coinLarge.getRegionWidth() &&
                    screenY*ratioY>(1900/2)-AssetStation.coinLarge.getRegionHeight()/2 && screenY*ratioY<((1900/2)-AssetStation.coinLarge.getRegionHeight()/2) + AssetStation.coinLarge.getRegionHeight() ){
                AssetStation.healthgained.play();
                situationMiddle=true;
                previousX=screenX;
                previousY=screenY;


            }else {


                world.getPlayerFish().onClick();
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


        if(situationMiddle==true && GameWorld.getGameState().equals("PlayingGame")){

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





        }else if(GameWorld.getGameState().equals("paused")){
            GameWorld.updateGameState("PlayingGame");
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

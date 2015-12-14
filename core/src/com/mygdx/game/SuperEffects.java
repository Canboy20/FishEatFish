package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

/**
 * Created by Can Atay on 12/14/2015.
 */
public class SuperEffects {


    private String superEffectType;

    private Vector2 Pos;
    private Vector2 Velocity;

    private boolean playerThrewCoin;
    private Rectangle superEffectCoinRect;
    private float delay=2;



    public SuperEffects(){


        superEffectType="coinThrow";
        Pos=new Vector2(600-AssetStation.coin.getRegionWidth()/2,(1900/2)-AssetStation.coin.getRegionHeight()/2);
        Velocity=new Vector2(0,0);

        playerThrewCoin=false;
        superEffectCoinRect=new Rectangle(0,0,0,0);

    }



    public void update(float delta){

        if(superEffectType.equals("coinThrow")){

            delay=delay-   Gdx.graphics.getDeltaTime();

          //  if(delay<0) {


                if (hasPlayerThrownCoin() == true) {


                    if (Velocity.x > 0) {
                        Velocity.x = Velocity.x - 50f * Gdx.graphics.getDeltaTime();
                    } else {

                        Velocity.x = Velocity.x + 50f * Gdx.graphics.getDeltaTime();

                    }


                    if (Velocity.y > 0) {
                        Velocity.y = Velocity.y - 50f * Gdx.graphics.getDeltaTime();

                    } else {
                        Velocity.y = Velocity.y + 50f * Gdx.graphics.getDeltaTime();


                    }

                    if(Math.round(Velocity.x)==0){
                        superEffectType="none";

                    }

                }


         //   }
                Pos.add(Velocity.cpy().scl(delta));
            superEffectCoinRect.set(Pos.x, Pos.y, Pos.x + AssetStation.coin.getRegionWidth(), Pos.y + AssetStation.coin.getRegionHeight());






            checkBounce();







        }

    }




    public void initializeSuperEffectType(){


        if(superEffectType.equals("coinThrow")){





        }


    }




    public void checkBounce(){

        if(Pos.x+AssetStation.coin.getRegionWidth()>1200){

            Velocity.x=-Velocity.x;

        }else if(Pos.x<0){

            Velocity.x=Math.abs(Velocity.x);

        }



        if(Pos.y+AssetStation.coin.getRegionHeight()>1900){

            Velocity.y=-Velocity.y;
        }else if(Pos.y<0){
            Velocity.y=Math.abs(Velocity.y);
        }




    }






    public String getTypeOfSuperEffect(){

        return superEffectType;


    }




    public void playerHasThrownCoin(){


        playerThrewCoin=true;

    }



    public boolean hasPlayerThrownCoin(){


        return playerThrewCoin;
    }




    public void setxVelocity(float xVelValue){

        Velocity.x=xVelValue;

    }


    public void setyVelocity(float yVelValue){

        Velocity.y=yVelValue;

    }


    public float getxPos(){
        return Pos.x;
    }

    public float getyPos(){
        return Pos.y;
    }


    public Rectangle getSuperEffectCoinRect(){
        return superEffectCoinRect;
    }








}

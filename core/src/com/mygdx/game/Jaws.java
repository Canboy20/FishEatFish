package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Can Atay on 11/16/2015.
 */
public class Jaws {

    private Rectangle jawsRectangle;
    private float width,height;
    private float xPos,yPos;
    private boolean jawsIsVisible;
    private boolean jawsShadowIsVisible;
    private boolean jawsBottomOrTopIsKnown;
    private String jawsBottomOrTop;

    float timeLeftForJaws=10;
    float shadowDuration=3;
    float jawsDuration=2;






    public Jaws(float width,float height){


        this.width=width;
        this.height=height;

        jawsRectangle=new Rectangle(0,0,0,0);
        jawsIsVisible=false;
        jawsShadowIsVisible=false;
        jawsBottomOrTopIsKnown=false;


    }




    public void update(String playerFishType, float delta){



        if(playerFishType.equals("xlarge") && jawsIsVisible==false){

            timeLeftForJaws = timeLeftForJaws - Gdx.graphics.getDeltaTime();

            if(timeLeftForJaws<0){

                timeLeftForJaws=10;
                jawsIsVisible=true;

                //Will jaws appear on top or bottom?
                if(jawsBottomOrTopIsKnown==false){

                    int random=((int)(Math.random()*2));

                    if(random==0){

                        jawsBottomOrTop="Bottom";
                    }else if(random==1){

                        jawsBottomOrTop="Top";

                    }

                    jawsBottomOrTopIsKnown=true;



                }


            }


        }






    }







    public Rectangle getJawsRectangle(){
        return jawsRectangle;
    }




    public void makeJawsGoAway(){

        jawsDuration = jawsDuration - Gdx.graphics.getDeltaTime();

        if(jawsDuration<0) {

            jawsDuration=2;
            shadowDuration=3;
            jawsIsVisible = false;
            jawsBottomOrTopIsKnown=false;
        }
    }





    public boolean isJawsVisible(){
        return jawsIsVisible;
    }


    public String jawsIsAtBottomOrTop(){
        return jawsBottomOrTop;
    }






    public boolean isShadowStillDisplayed(){


        shadowDuration = shadowDuration - Gdx.graphics.getDeltaTime();

        if(shadowDuration>0){
            return true;

        }else{
            return false;


        }



    }









}

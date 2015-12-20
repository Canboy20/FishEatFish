package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Can Atay on 11/22/2015.
 */


public class PufferFish {

    Vector2 positionPufferFish;
    Vector2 velocityPufferFish;
    Rectangle rectanglePufferFish;
    boolean pufferFishIsAvailable=false;
    boolean pufferFishAlertIsDisplayed=false;




    float timeLeftForNewFish=17;
    float pufferFishAlert=3;



    int width,height;
    boolean isVisible=true;
    int speedX,speedY;
    float curXpos,curYpos;

    int randomRowToPlace;




    public PufferFish(float x, float y, int width, int height) {

        this.width = width;
        this.height = height;
        positionPufferFish=new Vector2(0,0);
        velocityPufferFish=new Vector2(300,300);
        rectanglePufferFish=new Rectangle(x,y,width,height);


    }





    public void updatePufferFishPosition(float delta) {


        if(pufferFishIsAvailable==false) {
            timeLeftForNewFish = timeLeftForNewFish - Gdx.graphics.getDeltaTime();
        }

        if (timeLeftForNewFish < 0) {

            pufferFishIsAvailable=true;
            pufferFishAlertIsDisplayed=true;
            timeLeftForNewFish = 17;
            pufferFishAlert=3;
            generateNewPosForPufferFish();


        }


        if(pufferFishIsAvailable==true) {

            if (pufferFishAlert > 0) {
                pufferFishAlert = pufferFishAlert - Gdx.graphics.getDeltaTime();






            } else {
                pufferFishAlertIsDisplayed=false;


                positionPufferFish.add(velocityPufferFish.cpy().scl(delta));
                curXpos = positionPufferFish.x;
                curYpos = positionPufferFish.y;

                rectanglePufferFish.set(curXpos, curYpos, width, height);


                if (curXpos > 1200) {

                    pufferFishIsAvailable = false;
                    pufferFishAlert=3;

                } else if (curXpos < -width) {

                    pufferFishIsAvailable = false;
                    pufferFishAlert=3;



                }


            }
        }

    }




    public boolean isPufferFishIsAvailable(){
        return pufferFishIsAvailable;
    }




    public Rectangle getPufferFishRectangle(){
        return rectanglePufferFish;
    }



    public boolean isPufferFishAlertBeingDisplayed(){

        return pufferFishAlertIsDisplayed;
    }







    public void deletePufferFish(){

        pufferFishIsAvailable=false;

    }


    public float getX(){

        return rectanglePufferFish.getX();
    }





    public float getY(){

        return rectanglePufferFish.getY();
    }







    public float getVelocityX(){

        return velocityPufferFish.x;


    }





    public void generateNewPosForPufferFish(){

        randomRowToPlace=(int)(Math.random()*4);

        if(randomRowToPlace==0){

            positionPufferFish.set(-width, 0);
            velocityPufferFish.set(300, 300);
            rectanglePufferFish.set(-width, 0, width, height);


        }else if(randomRowToPlace==1){

            positionPufferFish.set(1200, 0);
            velocityPufferFish.set(-300, 300);
            rectanglePufferFish.set(1200, 0, width, height);




        }else if(randomRowToPlace==2){

            positionPufferFish.set(-width, 1900);
            velocityPufferFish.set(300, -300);
            rectanglePufferFish.set(-width, 1900, width, height);

        }else if(randomRowToPlace==3){

            positionPufferFish.set(1200, 1900);
            velocityPufferFish.set(-300, -300);
            rectanglePufferFish.set(1200, 1900, width, height);



        }




    }




    public void resetPufferFish(){

        pufferFishIsAvailable=false;
        pufferFishAlertIsDisplayed=false;
        timeLeftForNewFish=17;
        pufferFishAlert=3;
        isVisible=true;
        positionPufferFish.set(0,0);
        velocityPufferFish.set(300,300);
        rectanglePufferFish.set(0,0,width,height);

  }

}


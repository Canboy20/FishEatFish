package com.mygdx.game;

/**
 * Created by Can Atay on 11/14/2015.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Can Atay on 11/11/2015.
 */



public class MediumFish {

    ArrayList<Vector2> positionMediumFish;
    ArrayList<Vector2> velocityMediumFish;
    ArrayList<Rectangle> rectangleMediumFish;



    float timeLeftForNewFish=3;


    //private Vector2 position;
    //private Vector2 velocity;

    //private Rectangle bigFishRectangle;
    int width,height;
    boolean isVisible=true;
    int speedX,speedY;
    float curXpos,curYpos;

    int randomRowToPlace;






    public MediumFish(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;

        positionMediumFish=new ArrayList<Vector2>();
        velocityMediumFish=new ArrayList<Vector2>();
        rectangleMediumFish=new ArrayList<Rectangle>();


        positionMediumFish.add(new Vector2(x, y));

        velocityMediumFish.add(new Vector2(250, 0));

        rectangleMediumFish.add(new Rectangle(x, y, width, height));


    }





    public void updateMediumFishPosition(float delta){


        if(getNumberOfMediumFish()<4) {
            timeLeftForNewFish = timeLeftForNewFish - Gdx.graphics.getDeltaTime();
            if(timeLeftForNewFish<0){
                timeLeftForNewFish=6;

                generateNewPosForMediumFish();
            }

        }




        for(int p=0;p<positionMediumFish.size();p++){

            positionMediumFish.get(p).add(velocityMediumFish.get(p).cpy().scl(delta));
            curXpos=positionMediumFish.get(p).x;
            curYpos=positionMediumFish.get(p).y;

            rectangleMediumFish.get(p).set(curXpos,curYpos,width,height);


            if(curXpos>1200){

                deleteMediumFish(p);
            }else if(curXpos<-width){

                deleteMediumFish(p);


            }


        }

    }





    public Rectangle getMediumFishRectangle(int current){
        return rectangleMediumFish.get(current);
    }


    public int getNumberOfMediumFish(){
        return rectangleMediumFish.size();
    }



    public void deleteMediumFish(int cur){




        rectangleMediumFish.remove(cur);
        positionMediumFish.remove(cur);
        velocityMediumFish.remove(cur);

    }









    public float getVelocityX(int cur){

        return velocityMediumFish.get(cur).x;


    }





    public void generateNewPosForMediumFish(){

        randomRowToPlace=(int)(Math.random()*6);

        if(randomRowToPlace==0){

            positionMediumFish.add(new Vector2(-width, 0));
            velocityMediumFish.add(new Vector2(250, 0));
            rectangleMediumFish.add(new Rectangle(-width, 0, width, height));


        }else if(randomRowToPlace==1){

            positionMediumFish.add(new Vector2(1200, 2 * AssetStation.largeFish.getRegionHeight()));
            velocityMediumFish.add(new Vector2(-250, 0));
            rectangleMediumFish.add(new Rectangle(1200, 2 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==2){

            positionMediumFish.add(new Vector2(-width, 4 * AssetStation.largeFish.getRegionHeight()));
            velocityMediumFish.add(new Vector2(250, 0));
            rectangleMediumFish.add(new Rectangle(-width, 4 * AssetStation.largeFish.getRegionHeight(), width, height));

        }else if(randomRowToPlace==3){

            positionMediumFish.add(new Vector2(1200, 6 * AssetStation.largeFish.getRegionHeight()));
            velocityMediumFish.add(new Vector2(-250, 0));
            rectangleMediumFish.add(new Rectangle(1200, 6 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==4){

            positionMediumFish.add(new Vector2(-width, 12 * AssetStation.largeFish.getRegionHeight()));
            velocityMediumFish.add(new Vector2(250, 0));
            rectangleMediumFish.add(new Rectangle(-width, 12 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==5){

            positionMediumFish.add(new Vector2(1200, 14 * AssetStation.largeFish.getRegionHeight()));
            velocityMediumFish.add(new Vector2(-250, 0));
            rectangleMediumFish.add(new Rectangle(1200, 14 * AssetStation.largeFish.getRegionHeight(), width, height));




        }




    }

}

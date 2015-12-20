package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Can Atay on 11/11/2015.
 */



public class LargeFish {

    ArrayList<Vector2> positionLargeFish;
    ArrayList<Vector2> velocityLargeFish;
    ArrayList<Rectangle> rectangleLargeFish;



    float timeLeftForNewFish=3;


    //private Vector2 position;
    //private Vector2 velocity;

    //private Rectangle bigFishRectangle;
    int width,height;
    boolean isVisible=true;
    int speedX,speedY;
    float curXpos,curYpos;

    int randomRowToPlace;



    private float decreaser=0;



    public LargeFish(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;

        positionLargeFish=new ArrayList<Vector2>();
        velocityLargeFish=new ArrayList<Vector2>();
        rectangleLargeFish=new ArrayList<Rectangle>();


        positionLargeFish.add(new Vector2(x, y));

        velocityLargeFish.add(new Vector2(200, decreaser));

        rectangleLargeFish.add(new Rectangle(x, y, width, height));


    }



    public void updateLargeFishPosition(float delta){


        if(getNumberOfLargeFish()<4) {
            timeLeftForNewFish = timeLeftForNewFish - Gdx.graphics.getDeltaTime();
            if(timeLeftForNewFish<0){
                timeLeftForNewFish=6;

                generateNewPosForLargeFish();
            }

        }




        for(int p=0;p<positionLargeFish.size();p++){

            positionLargeFish.get(p).add(velocityLargeFish.get(p).cpy().scl(delta));
            curXpos=positionLargeFish.get(p).x;
            curYpos=positionLargeFish.get(p).y;

            rectangleLargeFish.get(p).set(curXpos,curYpos,width,height);


            if(curXpos>1200){

                deleteLargeFish(p);
            }else if(curXpos<-width){

                deleteLargeFish(p);


            }


        }

    }





    public Rectangle getLargeFishRectangle(int current){
        return rectangleLargeFish.get(current);
    }


    public int getNumberOfLargeFish(){
        return rectangleLargeFish.size();
    }



    public void deleteLargeFish(int cur){




        rectangleLargeFish.remove(cur);
        positionLargeFish.remove(cur);
        velocityLargeFish.remove(cur);

    }









    public float getVelocityX(int cur){

        return velocityLargeFish.get(cur).x;


    }





    public void generateNewPosForLargeFish(){

        randomRowToPlace=(int)(Math.random()*6);

        if(randomRowToPlace==0){

            positionLargeFish.add(new Vector2(-width, 0));
            velocityLargeFish.add(new Vector2(200, decreaser));
            rectangleLargeFish.add(new Rectangle(-width, 0, width, height));


        }else if(randomRowToPlace==1){

            positionLargeFish.add(new Vector2(1200, 2 * AssetStation.largeFish.getRegionHeight()));
            velocityLargeFish.add(new Vector2(-200, decreaser));
            rectangleLargeFish.add(new Rectangle(1200, 2 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==2){

            positionLargeFish.add(new Vector2(-width, 4 * AssetStation.largeFish.getRegionHeight()));
            velocityLargeFish.add(new Vector2(200, decreaser));
            rectangleLargeFish.add(new Rectangle(-width, 4 * AssetStation.largeFish.getRegionHeight(), width, height));

        }else if(randomRowToPlace==3){

            positionLargeFish.add(new Vector2(1200, 6 * AssetStation.largeFish.getRegionHeight()));
            velocityLargeFish.add(new Vector2(-200, decreaser));
            rectangleLargeFish.add(new Rectangle(1200, 6 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==4){

            positionLargeFish.add(new Vector2(-width, 12 * AssetStation.largeFish.getRegionHeight()));
            velocityLargeFish.add(new Vector2(200, decreaser));
            rectangleLargeFish.add(new Rectangle(-width, 12 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==5){

            positionLargeFish.add(new Vector2(1200, 14 * AssetStation.largeFish.getRegionHeight()));
            velocityLargeFish.add(new Vector2(-200, decreaser));
            rectangleLargeFish.add(new Rectangle(1200, 14 * AssetStation.largeFish.getRegionHeight(), width, height));




        }




    }


    public void resetLargeFish(){

        positionLargeFish.clear();
        velocityLargeFish.clear();
        rectangleLargeFish.clear();

        timeLeftForNewFish=3;

        isVisible=true;
      decreaser=0;




            positionLargeFish.add(new Vector2(0, 0));

            velocityLargeFish.add(new Vector2(200, decreaser));

            rectangleLargeFish.add(new Rectangle(0, 0, width, height));


        }

}

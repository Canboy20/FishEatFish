package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Can Atay on 11/10/2015.
 */


public class XLargeFish {


    ArrayList<Vector2> positionXLargeFish;
    ArrayList<Vector2> velocityXLargeFish;
    ArrayList<Rectangle> rectangleXLargeFish;



    float timeLeftForNewFish=3;


    //private Vector2 position;
    //private Vector2 velocity;

    //private Rectangle bigFishRectangle;
    int width,height;
    boolean isVisible=true;
    int speedX,speedY;
    float curXpos,curYpos;

    int randomRowToPlace;


    public XLargeFish(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;

        positionXLargeFish=new ArrayList<Vector2>();
        velocityXLargeFish=new ArrayList<Vector2>();
        rectangleXLargeFish=new ArrayList<Rectangle>();


        positionXLargeFish.add(new Vector2(x,y));

        velocityXLargeFish.add(new Vector2(100, 0));

        rectangleXLargeFish.add(new Rectangle(x, y, width, height));


    }



    public void updateBigFishPosition(float delta){


        if(getNumberOfXLargeFish()<2) {
            timeLeftForNewFish = timeLeftForNewFish - Gdx.graphics.getDeltaTime();
            if(timeLeftForNewFish<0){
                timeLeftForNewFish=6;

                generateNewPosForXLargeFish();
            }

        }




        for(int p=0;p<positionXLargeFish.size();p++){

            positionXLargeFish.get(p).add(velocityXLargeFish.get(p).cpy().scl(delta));
            curXpos=positionXLargeFish.get(p).x;
            curYpos=positionXLargeFish.get(p).y;

            rectangleXLargeFish.get(p).set(curXpos,curYpos,width,height);


            if(curXpos>1200){

                deleteXLargeFish(p);
            }else if(curXpos<-width){

                deleteXLargeFish(p);


            }


        }

    }





    public Rectangle getXLargeFishRectangle(int current){
        return rectangleXLargeFish.get(current);
    }


    public int getNumberOfXLargeFish(){
        return rectangleXLargeFish.size();
    }



    public void deleteXLargeFish(int cur){

        rectangleXLargeFish.remove(cur);
        positionXLargeFish.remove(cur);
        velocityXLargeFish.remove(cur);


    }


    public float getVelocityX(int cur){

        return velocityXLargeFish.get(cur).x;


    }





    public void generateNewPosForXLargeFish(){

        randomRowToPlace=(int)(Math.random()*6);

        if(randomRowToPlace==0){

            positionXLargeFish.add(new Vector2(-width,0));
            velocityXLargeFish.add(new Vector2(100, 0));
            rectangleXLargeFish.add(new Rectangle(-width, 0, width, height));


        }else if(randomRowToPlace==1){

            positionXLargeFish.add(new Vector2(800,AssetStation.xLargeFish.getRegionHeight()));
            velocityXLargeFish.add(new Vector2(-100, 0));
            rectangleXLargeFish.add(new Rectangle(1200, AssetStation.xLargeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==2){

            positionXLargeFish.add(new Vector2(-width,2*AssetStation.xLargeFish.getRegionHeight()));
            velocityXLargeFish.add(new Vector2(100, 0));
            rectangleXLargeFish.add(new Rectangle(-width, 2 * AssetStation.xLargeFish.getRegionHeight(), width, height));

        }else if(randomRowToPlace==3){

            positionXLargeFish.add(new Vector2(800,3*AssetStation.xLargeFish.getRegionHeight()));
            velocityXLargeFish.add(new Vector2(-100, 0));
            rectangleXLargeFish.add(new Rectangle(1200, 3 * AssetStation.xLargeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==4){

            positionXLargeFish.add(new Vector2(-width,4*AssetStation.xLargeFish.getRegionHeight()));
            velocityXLargeFish.add(new Vector2(100, 0));
            rectangleXLargeFish.add(new Rectangle(-width, 4 * AssetStation.xLargeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==5){

            positionXLargeFish.add(new Vector2(1200,5*AssetStation.xLargeFish.getRegionHeight()));
            velocityXLargeFish.add(new Vector2(-100, 0));
            rectangleXLargeFish.add(new Rectangle(1200, 5 * AssetStation.xLargeFish.getRegionHeight(), width, height));




        }




    }

}

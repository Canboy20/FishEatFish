package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Can Atay on 11/28/2015.
 */
public class AquariumFishes {

/*
    private ArrayList<Vector2> positionAquariumFishes;
    private ArrayList<Vector2> velocityAquariumFishes;
    private ArrayList<Rectangle> rectangleAquariumFishes;
    private ArrayList<String> typeOfAquariumFishes;


    private float timeLeftForNewFish=3;
    private float curXpos,curYpos;
    private int randomRowToPlace;


    public AquariumFishes() {

        positionAquariumFishes=new ArrayList<Vector2>();
        velocityAquariumFishes=new ArrayList<Vector2>();
        rectangleAquariumFishes=new ArrayList<Rectangle>();

        positionAquariumFishes.add(new Vector2(0, 0));
        velocityAquariumFishes.add(new Vector2(200, 0));
        rectangleAquariumFishes.add(new Rectangle(0, 0, 0, 0));


    }







    public void updateAquariumFishPosition(float delta){


        if(getNumberOfFishInAquarium()<5) {
            timeLeftForNewFish = timeLeftForNewFish - Gdx.graphics.getDeltaTime();
            if(timeLeftForNewFish<0){
                timeLeftForNewFish=6;

                generateNewPosForAquariumFish();
            }

        }




        for(int p=0;p<positionAquariumFishes.size();p++){

            positionAquariumFishes.get(p).add(velocityAquariumFishes.get(p).cpy().scl(delta));
            curXpos=positionAquariumFishes.get(p).x;
            curYpos=positionAquariumFishes.get(p).y;


            rectangleAquariumFishes.get(p).set(curXpos,curYpos,,height);


            if(curXpos>800){

                deleteLargeFish(p);
            }else if(curXpos<-width){

                deleteLargeFish(p);


            }


        }

    }





    public Rectangle getLargeFishRectangle(int current){
        return rectangleAquariumFishes.get(current);
    }


    public int getNumberOfFishInAquarium(){

        return rectangleAquariumFishes.size();
    }



    public void deleteAquariumFish(int cur){

        rectangleAquariumFishes.remove(cur);
        positionAquariumFishes.remove(cur);
        velocityAquariumFishes.remove(cur);

    }









    public float getVelocityX(int cur){

        return velocityAquariumFishes.get(cur).x;


    }





    public void generateNewPosForAquariumFish(){


        //will give us a random position on tank to put new fish on
        randomRowToPlace=(int)(Math.random()*6);

        //what type will new fish be




        if(randomRowToPlace==0){

            positionAquariumFishes.add(new Vector2(-width, 0));
            velocityAquariumFishes.add(new Vector2(200, 0));
            rectangleAquariumFishes.add(new Rectangle(-width, 0, width, height));


        }else if(randomRowToPlace==1){

            positionAquariumFishes.add(new Vector2(800, 2 * AssetStation.largeFish.getRegionHeight()));
            velocityAquariumFishes.add(new Vector2(-200, 0));
            rectangleAquariumFishes.add(new Rectangle(800, 2 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==2){

            positionAquariumFishes.add(new Vector2(-width, 4 * AssetStation.largeFish.getRegionHeight()));
            velocityAquariumFishes.add(new Vector2(200, 0));
            rectangleAquariumFishes.add(new Rectangle(-width, 4 * AssetStation.largeFish.getRegionHeight(), width, height));

        }else if(randomRowToPlace==3){

            positionAquariumFishes.add(new Vector2(800, 6 * AssetStation.largeFish.getRegionHeight()));
            velocityAquariumFishes.add(new Vector2(-200, 0));
            rectangleAquariumFishes.add(new Rectangle(800, 6 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==4){

            positionAquariumFishes.add(new Vector2(-width, 12 * AssetStation.largeFish.getRegionHeight()));
            velocityAquariumFishes.add(new Vector2(200, 0));
            rectangleAquariumFishes.add(new Rectangle(-width, 12 * AssetStation.largeFish.getRegionHeight(), width, height));



        }else if(randomRowToPlace==5){

            positionAquariumFishes.add(new Vector2(800, 14 * AssetStation.largeFish.getRegionHeight()));
            velocityAquariumFishes.add(new Vector2(-200, 0));
            rectangleAquariumFishes.add(new Rectangle(800, 14 * AssetStation.largeFish.getRegionHeight(), width, height));

        }

    }*/

}

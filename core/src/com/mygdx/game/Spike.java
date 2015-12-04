package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Can Atay on 11/11/2015.
 */
public class Spike {

    private float x;
    private float y;
    private boolean isAvailable=false;
    private float timeToReappear=5;

    private Rectangle spikeRect;
    private int width,height;
    private Rectangle randomRectangleArea;
    private PlayerFish pf;

    public Spike(PlayerFish pf,int width,int height){

        this.width=width;
        this.height=height;
        spikeRect=new Rectangle(0,0,0,0);
        randomRectangleArea=new Rectangle(0,0,0,0);
        this.pf=pf;

    }



    public void update(float delta){

        if(isAvailable==false){

            timeToReappear = timeToReappear - Gdx.graphics.getDeltaTime();

            if(timeToReappear<0){
                timeToReappear=5;

                x=(int)(Math.random()*800);
                y=(int)(Math.random()*1000);
                randomRectangleArea.set(x-AssetStation.xLargeFish.getRegionWidth(),y-AssetStation.xLargeFish.getRegionHeight(),(x+width)+AssetStation.xLargeFish.getRegionWidth(),(y+height)+AssetStation.xLargeFish.getRegionHeight());
                spikeRect.set(x,y,width,height);

                while(randomRectangleArea.overlaps(pf.getPlayerFishRectangle())){


                    x=(int)(Math.random()*800);
                    y=(int)(Math.random()*1000);
                    randomRectangleArea.set(x-AssetStation.xLargeFish.getRegionWidth(),y-AssetStation.xLargeFish.getRegionHeight(),(x+width)+AssetStation.xLargeFish.getRegionWidth(),(y+height)+AssetStation.xLargeFish.getRegionHeight());
                    spikeRect.set(x,y,width,height);

                }


                isAvailable=true;

            }


        }

    }


    public Rectangle getSpikeRect(){
        return spikeRect;
    }






    public boolean isSpikeAvailable(){

        return isAvailable;
    }



    public void spikeHasBeenUsed(){

        isAvailable=false;
    }




}

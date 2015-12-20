package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Can Atay on 11/11/2015.
 */
public class Spike {

    private float x;
    private float y;
    private float x2;
    private float y2;

    private boolean isAvailable=false;
    private boolean isAvailable2=false;

    private float timeToReappear=5;
    private float timeToReappear2=12;


    private Rectangle spikeRect;
    private Rectangle spikeRect2;
    private int width,height;
    private Rectangle randomRectangleArea;
    private Rectangle randomRectangleArea2;

    private PlayerFish pf;

    public Spike(PlayerFish pf,int width,int height){

        this.width=width;
        this.height=height;
        spikeRect=new Rectangle(0,0,0,0);
        spikeRect2=new Rectangle(0,0,0,0);

        randomRectangleArea=new Rectangle(0,0,0,0);
        randomRectangleArea2=new Rectangle(0,0,0,0);

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


        }else{

            //Increment spike y by 1
            spikeRect.setY(spikeRect.getY()+1f);

            if(spikeRect.getY()+AssetStation.spikes.getRegionHeight()>1900){
                isAvailable=false;
            }

        }




        if(isAvailable2==false && pf.getPointsGained()>=100){

            timeToReappear2 = timeToReappear2 - Gdx.graphics.getDeltaTime();

            if(timeToReappear2<0){
                timeToReappear2=15;

                x2=(int)(Math.random()*800);
                y2=(int)(Math.random()*1000);
                randomRectangleArea2.set(x2-AssetStation.xLargeFish.getRegionWidth(),y2-AssetStation.xLargeFish.getRegionHeight(),(x2+width)+AssetStation.xLargeFish.getRegionWidth(),(y2+height)+AssetStation.xLargeFish.getRegionHeight());
                spikeRect2.set(x2,y2,width,height);

                while(randomRectangleArea2.overlaps(pf.getPlayerFishRectangle())){


                    x2=(int)(Math.random()*800);
                    y2=(int)(Math.random()*1000);
                    randomRectangleArea2.set(x2-AssetStation.xLargeFish.getRegionWidth(),y2-AssetStation.xLargeFish.getRegionHeight(),(x2+width)+AssetStation.xLargeFish.getRegionWidth(),(y2+height)+AssetStation.xLargeFish.getRegionHeight());
                    spikeRect2.set(x2,y2,width,height);

                }


                isAvailable2=true;

            }


        }else{

            //Increment spike y by 1
            spikeRect2.setY(spikeRect2.getY()+1f);

            if(spikeRect2.getY()+AssetStation.spikes.getRegionHeight()>1900){
                isAvailable2=false;
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







    public Rectangle getSpikeRect2(){
        return spikeRect2;
    }


    public boolean isSpikeAvailable2(){

        return isAvailable2;
    }



    public void spikeHasBeenUsed2(){

        isAvailable2=false;
    }



    public void resetSpike(){


        isAvailable=false;
        isAvailable2=false;
        timeToReappear=5;
        timeToReappear2=12;
        spikeRect.set(0,0,0,0);
        spikeRect2.set(0,0,0,0);
        randomRectangleArea.set(0,0,0,0);
        randomRectangleArea2.set(0,0,0,0);


    }


}

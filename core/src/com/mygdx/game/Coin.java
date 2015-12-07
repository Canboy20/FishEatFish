package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Can Atay on 11/12/2015.
 */
public class Coin {



    private float width,height;


    Vector2 positionCoin;
    Vector2 velocityCoin;

    Vector2 positionCoin2;
    Vector2 velocityCoin2;

    private Rectangle coinRect;
    private Rectangle coinRect2;

    private float timeToReappear=3;
    private float timeToReappear2=5;

    private boolean coinIsAvailabke=false;
    private boolean coinIsAvailabke2=false;

    private String coinType="none";
    private String coin2Type="none";

    private float HealthHPOfPlayerFish;




    public Coin(int width, int height){

        this.width=width;
        this.height=height;
        positionCoin=new Vector2(0,0);
        velocityCoin=new Vector2(190,200);
        coinRect=new Rectangle(0,0,0,0);

        positionCoin2=new Vector2(0,0);
        velocityCoin2=new Vector2(190,200);
        coinRect2=new Rectangle(0,0,0,0);

    }


    public void update(float delta,float playerFishHealthHP){

        HealthHPOfPlayerFish=playerFishHealthHP;

        if(coinIsAvailabke==false){

            timeToReappear=timeToReappear- Gdx.graphics.getDeltaTime();

            if(timeToReappear<0){
                timeToReappear=3;
                initializeRandomPositionForCoin();
                coinIsAvailabke=true;

            }


        }else{
            positionCoin.add(velocityCoin.cpy().scl(delta));
            coinRect.set(positionCoin.x,positionCoin.y,AssetStation.coin.getRegionWidth(),AssetStation.coin.getRegionHeight());


            if(velocityCoin.y<0 && positionCoin.y<-AssetStation.coin.getRegionHeight()){

                coinIsAvailabke=false;
                timeToReappear=3;

            }else if(velocityCoin.y>0 && positionCoin.y>1900){
                coinIsAvailabke=false;
                timeToReappear=3;


            }

        }




        if(coinIsAvailabke2==false){

            timeToReappear2=timeToReappear2- Gdx.graphics.getDeltaTime();

            if(timeToReappear2<0){
                timeToReappear2=3;
                initializeRandomPositionForCoin2();
                coinIsAvailabke2=true;

            }


        }else{
            positionCoin2.add(velocityCoin2.cpy().scl(delta));
            coinRect2.set(positionCoin2.x,positionCoin2.y,AssetStation.coin.getRegionWidth(),AssetStation.coin.getRegionHeight());


            if(velocityCoin2.y<0 && positionCoin2.y<-AssetStation.coin.getRegionHeight()){

                coinIsAvailabke2=false;
                timeToReappear2=3;

            }else if(velocityCoin2.y>0 && positionCoin2.y>1900){
                coinIsAvailabke2=false;
                timeToReappear2=3;


            }

        }
    }





    public void initializeRandomPositionForCoin(){

        int  randomerType;
        if(HealthHPOfPlayerFish<80) {
            randomerType = (int) (Math.random() * 180);

        }else{
            randomerType = (int) (Math.random() * 100);

        }


        if(randomerType>=0 && randomerType<80) {
            coinType = "coin";

        }else if(randomerType>=80 && randomerType<100){

            coinType="spikesprotection";


        }else if(randomerType>=100 && randomerType<180){
            coinType="health";
        }






        int randomer=(int)(Math.random()*2);

        if(randomer==0){

            int randomer2=(int)(Math.random()*1000);

            positionCoin.set(randomer2,0);
            velocityCoin.set(0, 200);



        }else if(randomer==1){

            int randomer2=(int)(Math.random()*1000);

            positionCoin.set(randomer2,1800);
            velocityCoin.set(0,-200);



        }
        coinRect.set(positionCoin.x,positionCoin.y,AssetStation.coin.getRegionWidth(),AssetStation.coin.getRegionHeight());

    }


    public Rectangle getCoinRect(){
        return coinRect;
    }



    public boolean isCoinAvailabke(){
        return coinIsAvailabke;
    }


    public void makeCoinAvailable(){
        coinIsAvailabke=true;
    }


    public void makeCoinNotAvailable(){

        coinIsAvailabke=false;
    }





    public void initializeRandomPositionForCoin2(){

        int  randomer2Type;
        if(HealthHPOfPlayerFish<80) {
            randomer2Type = (int) (Math.random() * 180);

        }else{
            randomer2Type = (int) (Math.random() * 100);

        }


        if(randomer2Type>=0 && randomer2Type<80) {
            coin2Type = "coin";

        }else if(randomer2Type>=80 && randomer2Type<100){

            coin2Type="spikesprotection";


        }else if(randomer2Type>=100 && randomer2Type<180){
            coin2Type="health";
        }



        int randomer=(int)(Math.random()*2);



        if(randomer==0){

            int randomer2=(int)(Math.random()*1000);

            positionCoin2.set(randomer2,0);
            velocityCoin2.set(0, 200);



        }else if(randomer==1){

            int randomer2=(int)(Math.random()*1000);

            positionCoin2.set(randomer2,1800);
            velocityCoin2.set(0,-200);



        }
        coinRect2.set(positionCoin2.x,positionCoin2.y,AssetStation.coin.getRegionWidth(),AssetStation.coin.getRegionHeight());

    }


    public Rectangle getCoinRect2(){
        return coinRect2;
    }



    public boolean isCoinAvailabke2(){
        return coinIsAvailabke2;
    }


    public void makeCoinAvailable2(){
        coinIsAvailabke2=true;
    }


    public void makeCoinNotAvailable2(){

        coinIsAvailabke2=false;
    }


    public String getCoinType(){
        return coinType;
    }

    public String getCoin2Type(){
        return coin2Type;
    }



}

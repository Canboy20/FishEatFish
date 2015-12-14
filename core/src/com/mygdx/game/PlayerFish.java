package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Can Atay on 11/11/2015.
 */


public class PlayerFish {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;
    private Rectangle playerFishRectangle;

    private String currentFish="small";



    private int deadFishFrameCount=0;

    private int pointGainedFromCoinCollect=0;

    private float healthHP=100;

    GameWorld gmw;

    private float muliplier=1;



    private float currentFishWidth,currentFishHeight;

    String fishDestroyedType="";
    boolean fishDestroyed=false;
    float fishDestroyedX;
    float fishDestroyedY;
    ArrayList<String> fishStomach;


    boolean playerFishIsProtected;
    float protectionDuration=4;

    private float rotation=0;










    public PlayerFish(GameWorld gmw,float x, float y, int width, int height) {

        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(410, 0);
        acceleration = new Vector2(0, 460);
        this.gmw=gmw;

        //Will keep all the fish current fish ate
        fishStomach=new ArrayList<String>();


        //Game will start with small Fish
        currentFishWidth=AssetStation.smallFish.getRegionWidth();
        currentFishHeight=AssetStation.smallFish.getRegionHeight();
        playerFishRectangle=new Rectangle(x,y,currentFishWidth,currentFishHeight);


        playerFishIsProtected=false;

    }


    public void update(float delta) {


        if(playerFishIsProtected==true){
            protectionDuration = protectionDuration - Gdx.graphics.getDeltaTime();
            if(protectionDuration<0){

                protectionDuration=4;
                playerFishIsProtected=false;
            }



        }


        if(currentFish.equals("small")) {

            velocity.add(acceleration.cpy().scl(delta));

            if (velocity.y > 400) {
                velocity.y = 400;
            }

            position.add(velocity.cpy().scl(delta));

            if (position.x + currentFishWidth > 1200) {
                velocity.x = -410*muliplier;
            } else if (position.x < 0) {
                velocity.x = 410*muliplier;
            }

          //  velocity.x =velocity.x-100f*Gdx.graphics.getDeltaTime();






        }else  if(currentFish.equals("medium")) {
            velocity.add(acceleration.cpy().scl(delta));

            if (velocity.y > 400) {
                velocity.y = 400;
            }

            position.add(velocity.cpy().scl(delta));

            if (position.x + currentFishWidth > 1200) {
                velocity.x = -250;
            } else if (position.x < 0) {
                velocity.x = 250;
            }













        }else if(currentFish.equals("large")){


            velocity.add(acceleration.cpy().scl(delta));

            if (velocity.y > 400) {
                velocity.y = 400;
            }

            position.add(velocity.cpy().scl(delta));

            if (position.x + currentFishWidth > 1200) {
                velocity.x = -150;
            } else if (position.x < 0) {
                velocity.x = 150;
            }





        }else if(currentFish.equals("xlarge")){

            velocity.add(acceleration.cpy().scl(delta));

            if (velocity.y > 400) {
                velocity.y = 400;
            }

            position.add(velocity.cpy().scl(delta));

            if (position.x + currentFishWidth > 1200) {
                velocity.x = -50;
            } else if (position.x < 0) {
                velocity.x = 50;
            }
        }







        if(position.y + currentFishHeight>1900-10){

            position.y=(1900-10)- currentFishHeight;
        }else if(position.y<0){
            position.y=11;
        }

        playerFishRectangle.set(position.x, position.y, currentFishWidth, currentFishHeight);



        //HP update
        if(fishStomach.size()==0) {
            healthHP = healthHP + 4*Gdx.graphics.getDeltaTime();

            if (healthHP > 100) {
                healthHP = 100;
            }

        }else{

            if(fishStomach.size()==1){
                healthHP = healthHP - Gdx.graphics.getDeltaTime();


            }else if(fishStomach.size()==2){

                healthHP = healthHP - 2* Gdx.graphics.getDeltaTime();


            }else if(fishStomach.size()==3){

                healthHP = healthHP - 3* Gdx.graphics.getDeltaTime();


            }

        }


        if(healthHP<0){
            //GameOver
            gmw.changeState("MainScreen");
            healthHP=100;

        }



        rotation -= 600 * delta;

        if(rotation>360){
            //rotation=0;
        }

    }






    public Rectangle getPlayerFishRectangle(){
        return playerFishRectangle;
    }

/*
    public void makeBirdInvisible(){

        isVisible=false;
    }


    public boolean isBirdVisible(){

        return isVisible;

    }*/


    public void onClick() {
        velocity.y = -300;
    }

    public float getX() {
        return playerFishRectangle.getX();
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return currentFishWidth;
    }

    public float getHeight() {
        return currentFishHeight;
    }

    public float getRotation() {
        return rotation;
    }



    public void updateStateOfFishByOtherFish(String newFish,int index) {

        //Check if a fish was eaten before. If not, then it means small fish has killed itself, end of game :(

        //If current type fish collided with same type



        if (currentFish.equals(newFish)) {

            //Wont each eachother


        } else {


            //If current Fish is a small one, then any fish other than small may eat it
            if (currentFish.equals("small")) {

                fishStomach.add("small");        //Small Fish was eaten by new Fish
                currentFish=newFish;             //New fish
                updateAllValuesOfNewPlayerFish(newFish,index);        //Update all values according to new Fish. Since new Fish is bigger than previous, it will move slower and cover more space

                AssetStation.bite.play();



            }else if(currentFish.equals("medium")) {

                if(newFish.equals("small")){

                    //Won't eat as our current Fish is bigger in size

                }else if(newFish.equals("large")) {

                    AssetStation.bite.play();

                    fishStomach.add("medium");        //Large Fish was eaten by new Fish
                    currentFish=newFish;             //New fish
                    updateAllValuesOfNewPlayerFish(newFish,index);        //Update all values according to new Fish. Since new Fish is bigger than previous, it will move slower and cover more space


                }else if(newFish.equals("xlarge")) {

                    AssetStation.bite.play();
                    fishStomach.add("medium");        //Large Fish was eaten by new Fish
                    currentFish = newFish;             //New fish
                    updateAllValuesOfNewPlayerFish(newFish, index);        //Update all values according to new Fish. Since new Fish is bigger than previous, it will move slower and cover more space

                }



            }else if(currentFish.equals("large")) {

                if(newFish.equals("small")){

                    //Won't eat as our current Fish is bigger in size
                }else if(newFish.equals("medium")){

                    //Won't eat as our current Fish is bigger in size


                }else if(newFish.equals("xlarge")) {

                    AssetStation.bite.play();

                    fishStomach.add("large");        //Large Fish was eaten by new Fish
                    currentFish=newFish;             //New fish
                    updateAllValuesOfNewPlayerFish(newFish,index);        //Update all values according to new Fish. Since new Fish is bigger than previous, it will move slower and cover more space

                }

            }else if(currentFish.equals("xlarge")) {

                if(newFish.equals("small")) {
                    //Won't eat as our current Fish is bigger in size

                }else if(currentFish.equals("medium")) {
                    //Won't eat as our current Fish is bigger in size

                }else if(currentFish.equals("large")){
                    //Won't eat as our current Fish is bigger in size


                }else if(currentFish.equals("jaws")) {
/*
                    fishStomach.add("xlarge");        //XLarge Fish was eaten by new Fish
                    currentFish=jaws;             //New fish
                    updateAllValuesOfNewPlayerFish(collidedFish,index);        //Update all values according to new Fish. Since new Fish is bigger than previous, it will move slower and cover more space
*/

                }

            }
        }
    }




    public void updateStateOfFishByJaws(){

        GameWorld.updateGameState("MainScreen");
    }






    public void updateStateOfFishBySpikeOrPufferFish() {

        //Check if a fish was eaten before. If not, then it means small fish has killed itself, end of game :(

        //If current type fish collided with same type

        AssetStation.rip.play();
       if(currentFish.equals("small")){


           GameWorld.updateGameState("MainScreen");



       }else if(currentFish.equals("medium")) {

           currentFish = popLastEatenFish();
           destroyFish("medium");
           updateAllValuesOfNewPlayerFishSpikePuffer(currentFish);




       }else if(currentFish.equals("large")) {

           currentFish = popLastEatenFish();
           destroyFish("large");
           updateAllValuesOfNewPlayerFishSpikePuffer(currentFish);

       }else if(currentFish.equals("xlarge")){

           currentFish = popLastEatenFish();
           destroyFish("xlarge");
           updateAllValuesOfNewPlayerFishSpikePuffer(currentFish);


       }


    }




    public void updateAllValuesOfNewPlayerFishSpikePuffer(String typeOfFish) {


        if (typeOfFish.equals("small")) {
            currentFish = "small";

            velocity.x = 410*muliplier;
            acceleration.y = 460;

            currentFishWidth = AssetStation.smallFish.getRegionWidth();
            currentFishHeight = AssetStation.smallFish.getRegionHeight();


        } else if (typeOfFish.equals("medium")) {

            currentFish = "medium";
            velocity.x = 250;
            acceleration.y = 460;

            currentFishWidth = AssetStation.mediumFish.getRegionWidth();
            currentFishHeight = AssetStation.mediumFish.getRegionHeight();






        } else if (typeOfFish.equals("large")) {

            currentFish = "large";
            velocity.x = 150;
            acceleration.y = 460;

            currentFishWidth = AssetStation.largeFish.getRegionWidth();
            currentFishHeight = AssetStation.largeFish.getRegionHeight();


        } else if (typeOfFish.equals("xlarge")) {

            currentFish = "xlarge";

            velocity.x = 50;
            acceleration.y = 460;

            currentFishWidth = AssetStation.xLargeFish.getRegionWidth();
            currentFishHeight = AssetStation.xLargeFish.getRegionHeight();


        }
    }












        public void updateAllValuesOfNewPlayerFish(String typeOfFish,int index){

        if(typeOfFish.equals("small")){
            currentFish="small";

            velocity.x=410*muliplier;
            acceleration.y=460;

            currentFishWidth=AssetStation.smallFish.getRegionWidth();
            currentFishHeight=AssetStation.smallFish.getRegionHeight();

        }else if(typeOfFish.equals("medium")){

            currentFish="medium";
            velocity.x=250;
            acceleration.y=460;

            currentFishWidth=AssetStation.mediumFish.getRegionWidth();
            currentFishHeight=AssetStation.mediumFish.getRegionHeight();

            gmw.getMediumFish().deleteMediumFish(index);




        }else if(typeOfFish.equals("large")){

            currentFish="large";
            velocity.x=150;
            acceleration.y=460;

            currentFishWidth=AssetStation.largeFish.getRegionWidth();
            currentFishHeight=AssetStation.largeFish.getRegionHeight();

            gmw.getLargeFish().deleteLargeFish(index);


        }else if(typeOfFish.equals("xlarge")){

            currentFish="xlarge";

            velocity.x=50;
            acceleration.y=460;

            currentFishWidth=AssetStation.xLargeFish.getRegionWidth();
            currentFishHeight=AssetStation.xLargeFish.getRegionHeight();
            gmw.getxLargeFish().deleteXLargeFish(index);



        }
    }












    //Stack properties


    public String getLastEatenFish(){

        if(fishStomach.size()==0){

            return "none";
        }else{

            return fishStomach.get(fishStomach.size()-1);
        }


    }



    public String popLastEatenFish(){

        if(fishStomach.size()==0){

            return "none";
        }else{

            return fishStomach.remove(fishStomach.size() - 1);
        }


    }









    public float getDestroyedFishX(){
        return fishDestroyedX;
    }

    public float getDestroyedFishY(){
        return fishDestroyedY;
    }




    public String getTypeOfPlayerFish(){

        return currentFish;

    }


    public float getXVelocityOfPlayerFish(){
        return velocity.x;
    }


    public void destroyFish(String deadFish){

        fishDestroyedType=deadFish;
        fishDestroyedX=playerFishRectangle.getX();
        fishDestroyedY=playerFishRectangle.getY();

        fishDestroyed=true;
    }


    public String getdeadFishType(){

        return fishDestroyedType;

    }



    public boolean isFishBeingDestroyed(){

        return fishDestroyed;
    }



    public void increaseDeadFishCount(){
        deadFishFrameCount++;
    }


    public int getDeadFishCount(){
        return deadFishFrameCount;

    }


    public void fishDestroyEnded(){

        fishDestroyed=false;

    }



    public void resetDeadFishCount(){


            fishDestroyEnded();

        deadFishFrameCount=0;

    }



    public void increasePointsGained(){
        pointGainedFromCoinCollect++;
    }


    public int getPointsGained(){
        return pointGainedFromCoinCollect;
    }

    public float getHealthHP(){
        return healthHP;
    }



    public void increaseHealthHP(){

        healthHP=healthHP+30;



    }


    public void protectFish(){

        playerFishIsProtected=true;
    }



    public boolean isPlayerFishProtected(){
        return playerFishIsProtected;
    }


    public void increaseMuliplier(){
        muliplier=3;
    }


    public void revertToNormalMultiplier(){
        muliplier=1;
    }

}






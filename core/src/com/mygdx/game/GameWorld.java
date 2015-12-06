package com.mygdx.game;

/**
 * Created by Can Atay on 11/10/2015.
 */


public class GameWorld {

    private PlayerFish playerFish;
    private Jaws jaws;
    private PufferFish pufferFish;
    private XLargeFish xLargeFish;
    private LargeFish largeFish;
    private MediumFish mediumFish;
    private Spike spike;
    private Coin coin;
    private static String gameState;

    public GameWorld(int midPointY) {


        playerFish = new PlayerFish(this,400, midPointY - 5,35, 34);
        jaws=new Jaws(1200, 920);
        pufferFish=new PufferFish(0,0,AssetStation.pufferFish.getRegionWidth(), AssetStation.pufferFish.getRegionHeight());
        xLargeFish =new XLargeFish(0,0,550, 323);
        largeFish =new LargeFish(800,midPointY,395, 236);
        mediumFish=new MediumFish(0,0,234, 214);
        spike=new Spike(playerFish,129, 142);
        coin=new Coin(106, 103);

        gameState="MainScreen";   //At start main screen will be shown

    }

    public void update(float delta) {

        if(gameState.equals("MainScreen")){




        }else if(gameState.equals("PlayingGame")){

            if(! AssetStation.gameMusic.isPlaying()){
                AssetStation.gameMusic.play();
            }


            playerFish.update(delta);
            pufferFish.updatePufferFishPosition(delta);
            jaws.update(playerFish.getTypeOfPlayerFish(), delta);
            xLargeFish.updateBigFishPosition(delta);
            largeFish.updateLargeFishPosition(delta);
            mediumFish.updateMediumFishPosition(delta);
            spike.update(delta);
            coin.update(delta,playerFish.getHealthHP());




                for (int cur = 0; cur < xLargeFish.getNumberOfXLargeFish(); cur++) {
                    if (xLargeFish.getXLargeFishRectangle(cur).overlaps(playerFish.getPlayerFishRectangle())) {

                        if(playerFish.isPlayerFishProtected()==true){

                            xLargeFish.deleteXLargeFish(cur);
                        }else {
                            playerFish.updateStateOfFishByOtherFish("xlarge", cur);
                        }
                    }
                }







                for (int cur = 0; cur < largeFish.getNumberOfLargeFish(); cur++) {
                    if (largeFish.getLargeFishRectangle(cur).overlaps(playerFish.getPlayerFishRectangle())) {

                        //playerFish.makeBirdInvisible();

                        if(playerFish.isPlayerFishProtected()==true){

                            largeFish.deleteLargeFish(cur);
                        }else {
                            playerFish.updateStateOfFishByOtherFish("large", cur);
                        }
                    }
                }




            for (int cur = 0; cur < mediumFish.getNumberOfMediumFish(); cur++) {
                if (mediumFish.getMediumFishRectangle(cur).overlaps(playerFish.getPlayerFishRectangle())) {

                    //playerFish.makeBirdInvisible();
                    if(playerFish.isPlayerFishProtected()==true){

                        mediumFish.deleteMediumFish(cur);
                    }else {
                        playerFish.updateStateOfFishByOtherFish("medium", cur);
                    }
                }
            }



            //If jaws is visible, check collision
            if(jaws.isJawsVisible()==true){

                if(playerFish.getPlayerFishRectangle().overlaps(jaws.getJawsRectangle())){

                    playerFish.updateStateOfFishByJaws();


                }
            }


            if(pufferFish.isPufferFishIsAvailable()==true){

                if(playerFish.getPlayerFishRectangle().overlaps(pufferFish.getPufferFishRectangle())){

                    playerFish.updateStateOfFishBySpikeOrPufferFish();
                    pufferFish.deletePufferFish();
                    AssetStation.puff.play();


                }
            }





            //Check coin collision. If collides, you gain a point!!!
            if(coin.isCoinAvailabke()==true){
                if(playerFish.getPlayerFishRectangle().overlaps(coin.getCoinRect()) && playerFish.getTypeOfPlayerFish().equals("small")) {

                    if (coin.getCoinType().equals("coin")) {
                        coin.makeCoinNotAvailable();
                        playerFish.increasePointsGained();
                        AssetStation.coinPickUp.play();
                    }else if(coin.getCoinType().equals("health")){
                        coin.makeCoinNotAvailable();
                        playerFish.increaseHealthHP();
                        AssetStation.healthgained.play();

                    }else if(coin.getCoinType().equals("spikesprotection")){
                        coin.makeCoinNotAvailable();
                        playerFish.protectFish();


                    }
                }
            }




            if(coin.isCoinAvailabke2()==true){
                if(playerFish.getPlayerFishRectangle().overlaps(coin.getCoinRect2()) && playerFish.getTypeOfPlayerFish().equals("small")){

                    if(coin.getCoin2Type().equals("coin")) {
                        coin.makeCoinNotAvailable2();
                        playerFish.increasePointsGained();
                        AssetStation.coinPickUp.play();

                    }else if(coin.getCoin2Type().equals("health")){

                        coin.makeCoinNotAvailable2();
                        playerFish.increaseHealthHP();
                        AssetStation.healthgained.play();

                    }else if(coin.getCoin2Type().equals("spikesprotection")){
                        coin.makeCoinNotAvailable2();
                        playerFish.protectFish();


                    }

                }
            }






            if (spike.isSpikeAvailable() == true) {
                if (spike.getSpikeRect().overlaps(playerFish.getPlayerFishRectangle())) {


                    playerFish.updateStateOfFishBySpikeOrPufferFish();
                    spike.spikeHasBeenUsed();


                }
            }







        }

    }




    public static void updateGameState(String newState){

        gameState=newState;
    }


    public  static String getGameState(){

        return gameState;
    }


    public PlayerFish getPlayerFish() {
        return playerFish;

    }


    public XLargeFish getxLargeFish() {
        return xLargeFish;

    }


    public LargeFish getLargeFish() {
        return largeFish;

    }


    public MediumFish getMediumFish() {
        return mediumFish;

    }

    public Spike getSpike() {
        return spike;

    }


    public Jaws getJaws() {
        return jaws;

    }


    public PufferFish getPufferFish() {
        return pufferFish;

    }


    public Coin getCoin(){
        return coin;
    }


    public void changeState(String newState){

        if(newState.equals("PlayingGame")){
            AssetStation.gameMusic.play();

        }

        gameState=newState;

    }


}


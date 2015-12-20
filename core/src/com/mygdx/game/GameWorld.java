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
    private SuperEffects superEffects;

    private static String gameState;




    public GameWorld(int midPointY) {


        playerFish = new PlayerFish(this,400, midPointY - 5,35, 34);
        jaws=new Jaws(1200, 920);
        pufferFish=new PufferFish(0,0,AssetStation.pufferFish.getRegionWidth()-100, AssetStation.pufferFish.getRegionHeight());
        xLargeFish =new XLargeFish(0,0,550, 323);
        largeFish =new LargeFish(800,midPointY,395, 236);
        mediumFish=new MediumFish(0,0,234, 214);
        spike=new Spike(playerFish,129, 142);
        coin=new Coin(106, 103);
        superEffects=new SuperEffects();

        gameState="MainScreen";   //At start main screen will be shown

    }

    public void update(float delta) {

        if(gameState.equals("MainScreen")) {


        }else if(gameState.equals("GameOver")){




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
            superEffects.update(delta);




                for (int cur = 0; cur < xLargeFish.getNumberOfXLargeFish(); cur++) {
                    if (xLargeFish.getXLargeFishRectangle(cur).overlaps(playerFish.getPlayerFishRectangle())) {

                        if(playerFish.isPlayerFishProtected()==true || superEffects.hasPlayerPickedUpJet()==true){

                            xLargeFish.deleteXLargeFish(cur);
                            playerFish.increasePointsGained();


                        }else {
                            playerFish.updateStateOfFishByOtherFish("xlarge", cur);
                        }
                    }
                }







                for (int cur = 0; cur < largeFish.getNumberOfLargeFish(); cur++) {
                    if (largeFish.getLargeFishRectangle(cur).overlaps(playerFish.getPlayerFishRectangle())) {

                        //playerFish.makeBirdInvisible();

                        if(playerFish.isPlayerFishProtected()==true || superEffects.hasPlayerPickedUpJet()==true){

                            largeFish.deleteLargeFish(cur);
                            playerFish.increasePointsGained();

                        }else {
                            playerFish.updateStateOfFishByOtherFish("large", cur);
                        }
                    }
                }




            for (int cur = 0; cur < mediumFish.getNumberOfMediumFish(); cur++) {
                if (mediumFish.getMediumFishRectangle(cur).overlaps(playerFish.getPlayerFishRectangle())) {

                    //playerFish.makeBirdInvisible();
                    if(playerFish.isPlayerFishProtected()==true || superEffects.hasPlayerPickedUpJet()==true){

                        mediumFish.deleteMediumFish(cur);
                        playerFish.increasePointsGained();

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


            if(pufferFish.isPufferFishIsAvailable()==true || superEffects.hasPlayerPickedUpJet()==true ){

                if(playerFish.getPlayerFishRectangle().overlaps(pufferFish.getPufferFishRectangle())){

                    if(playerFish.isPlayerFishProtected()==true || superEffects.hasPlayerPickedUpJet()==true){

                        pufferFish.deletePufferFish();
                        AssetStation.puff.play();
                        playerFish.increasePointsGained();


                    }else {

                        playerFish.updateStateOfFishBySpikeOrPufferFish();
                        pufferFish.deletePufferFish();
                        AssetStation.puff.play();
                    }


                }
            }



            if(superEffects.hasPlayerThrownCoin()==true){

                for(int i=0;i<xLargeFish.getNumberOfXLargeFish();i++){
                    if(superEffects.getSuperEffectCoinRect().overlaps(xLargeFish.getXLargeFishRectangle(i))){
                        xLargeFish.deleteXLargeFish(i);
                        playerFish.increasePointsGained();
                        AssetStation.coinPickUp.play();
                    }
                }

                for(int i=0;i<largeFish.getNumberOfLargeFish();i++) {
                    if (superEffects.getSuperEffectCoinRect().overlaps(largeFish.getLargeFishRectangle(i))) {
                        largeFish.deleteLargeFish(i);
                        playerFish.increasePointsGained();
                        AssetStation.coinPickUp.play();
                    }
                }
            }


            if(superEffects.getTypeOfSuperEffect().equals("jet") && superEffects.hasPlayerPickedUpJet()==false && playerFish.getTypeOfPlayerFish().equals("small")){

                if(playerFish.getPlayerFishRectangle().overlaps(superEffects.getSuperEffectCoinRect())){

                    superEffects.playerHasPickedUpJet();
                    playerFish.increaseMuliplier();
                    AssetStation.jetsound.play();


                }
            }


            if(superEffects.getTypeOfSuperEffect().equals("none")){
                playerFish.revertToNormalMultiplier();
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

                if(superEffects.hasPlayerPickedUpJet()==true){

                    spike.spikeHasBeenUsed();

                }else if (spike.getSpikeRect().overlaps(playerFish.getPlayerFishRectangle())) {

                    playerFish.updateStateOfFishBySpikeOrPufferFish();
                    spike.spikeHasBeenUsed();
                    playerFish.increaseHealthHP();

                }
            }




            if (spike.isSpikeAvailable2() == true) {

                if(superEffects.hasPlayerPickedUpJet()==true){

                    spike.spikeHasBeenUsed2();

                }else if (spike.getSpikeRect2().overlaps(playerFish.getPlayerFishRectangle())) {


                    playerFish.updateStateOfFishBySpikeOrPufferFish();
                    spike.spikeHasBeenUsed2();
                    playerFish.increaseHealthHP();

                }
            }
        }
    }





    public static void updateGameState(String newState){

        if(newState.equals("GameOver")) {
            if (AssetStation.gameMusic.isPlaying() == true) {
                AssetStation.gameMusic.stop();
            }
        }

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

    public SuperEffects getSuperEffects(){
        return superEffects;
    }


    public void changeState(String newState){

        if(newState.equals("PlayingGame")){
            AssetStation.gameMusic.play();

        }else if(newState.equals("GameOver")){
            if(AssetStation.gameMusic.isPlaying()==true) {
                AssetStation.gameMusic.stop();
            }
        }else if(newState.equals("Paused")){


        }

        gameState=newState;

    }


}


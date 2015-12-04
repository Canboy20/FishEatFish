package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Can Atay on 11/11/2015.
 */


public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private OrthographicCamera cam2;

    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;
    private SpriteBatch batcher2;


    private int midPointY;
    private int gameHeight;





    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;

        // The word "this" refers to this instance.
        // We are setting the instance variables' values to be that of the
        // parameters passed in from GameScreen.
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1200, gameHeight);

        cam2 = new OrthographicCamera();
        cam2.setToOrtho(false, 1200, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        batcher2 = new SpriteBatch();
        batcher2.setProjectionMatrix(cam2.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);


    }

    public void render(float runTime) {

        if(myWorld.getGameState().equals("MainScreen")){

            batcher.begin();
            // Disable transparency
            // This is good for performance when drawing images that do not require
            // transparency.
            batcher.disableBlending();



            batcher.draw(AssetStation.mainscreenbackgroundPlay, 0,0, 1200, 1900);


            batcher.end();



        }else if(myWorld.getGameState().equals("PlayingGame")) {




            // We will move these outside of the loop for performance later.
            PlayerFish bird = myWorld.getPlayerFish();

            // Fill the entire screen with black, to prevent potential flickering.
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            // Begin ShapeRenderer
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

            // Draw Background color/*
           /* shapeRenderer.setColor(153 / 255.0f, 204 / 255.0f, 255 / 255.0f, 1);
            shapeRenderer.rect(0, 0, 1200, midPointY + 1200);*/
/*
        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);
*/
            // End ShapeRenderer
            shapeRenderer.end();

            // Begin SpriteBatch
            batcher.begin();
            // Disable transparency
            // This is good for performance when drawing images that do not require
            // transparency.
            batcher.disableBlending();







            // The bird needs transparency, so we enable that again.
            batcher.enableBlending();

            batcher.draw(AssetStation.background, 0,
                    0, 1200, 1900);



            //Draw health points
            drawHPTriangles();



            if (myWorld.getSpike().isSpikeAvailable() == true) {


                batcher.draw(AssetStation.spikes, myWorld.getSpike().getSpikeRect().getX(),
                        myWorld.getSpike().getSpikeRect().getY(), myWorld.getSpike().getSpikeRect().getWidth(), myWorld.getSpike().getSpikeRect().getHeight());


            }


            batcher.end();


            batcher2.begin();
            AssetStation.font.draw(batcher2, Integer.toString(myWorld.getPlayerFish().getPointsGained()), 570, gameHeight/2 + 125/2);
            batcher2.end();


            batcher.begin();


            for (int cur = 0; cur < myWorld.getxLargeFish().getNumberOfXLargeFish(); cur++) {

                if (myWorld.getxLargeFish().getVelocityX(cur) > 0) {

                    batcher.draw(AssetStation.xLargeFishAnimation.getKeyFrame(runTime),
                            myWorld.getxLargeFish().getXLargeFishRectangle(cur).getX(), myWorld.getxLargeFish().getXLargeFishRectangle(cur).getY(), myWorld.getxLargeFish().getXLargeFishRectangle(cur).getWidth(), myWorld.getxLargeFish().getXLargeFishRectangle(cur).getHeight());

                } else {

                    batcher.draw(AssetStation.xLargeFishAnimation.getKeyFrame(runTime), myWorld.getxLargeFish().getXLargeFishRectangle(cur).getX() + myWorld.getxLargeFish().getXLargeFishRectangle(cur).getWidth(),
                            myWorld.getxLargeFish().getXLargeFishRectangle(cur).getY(), -myWorld.getxLargeFish().getXLargeFishRectangle(cur).getWidth(), myWorld.getxLargeFish().getXLargeFishRectangle(cur).getHeight());


                }

            }


            for (int cur = 0; cur < myWorld.getLargeFish().getNumberOfLargeFish(); cur++) {

                if (myWorld.getLargeFish().getVelocityX(cur) > 0) {
                    batcher.draw(AssetStation.largeFishAnimation.getKeyFrame(runTime),
                            myWorld.getLargeFish().getLargeFishRectangle(cur).getX(), myWorld.getLargeFish().getLargeFishRectangle(cur).getY(),
                            myWorld.getLargeFish().getLargeFishRectangle(cur).getWidth(), myWorld.getLargeFish().getLargeFishRectangle(cur).getHeight());
                } else {

                    batcher.draw(AssetStation.largeFishAnimation.getKeyFrame(runTime),
                            myWorld.getLargeFish().getLargeFishRectangle(cur).getX() + myWorld.getLargeFish().getLargeFishRectangle(cur).getWidth(),
                            myWorld.getLargeFish().getLargeFishRectangle(cur).getY(),
                            -myWorld.getLargeFish().getLargeFishRectangle(cur).getWidth(), myWorld.getLargeFish().getLargeFishRectangle(cur).getHeight());



                }
            }




            for (int cur = 0; cur < myWorld.getMediumFish().getNumberOfMediumFish(); cur++) {

                if (myWorld.getMediumFish().getVelocityX(cur) > 0) {
                    batcher.draw(AssetStation.mediumFishAnimation.getKeyFrame(runTime),
                            myWorld.getMediumFish().getMediumFishRectangle(cur).getX(), myWorld.getMediumFish().getMediumFishRectangle(cur).getY(),
                            myWorld.getMediumFish().getMediumFishRectangle(cur).getWidth(), myWorld.getMediumFish().getMediumFishRectangle(cur).getHeight());
                } else {

                    batcher.draw(AssetStation.mediumFishAnimation.getKeyFrame(runTime),
                            myWorld.getMediumFish().getMediumFishRectangle(cur).getX() + myWorld.getMediumFish().getMediumFishRectangle(cur).getWidth(),
                            myWorld.getMediumFish().getMediumFishRectangle(cur).getY(),
                            -myWorld.getMediumFish().getMediumFishRectangle(cur).getWidth(), myWorld.getMediumFish().getMediumFishRectangle(cur).getHeight());


                }
            }






            if (myWorld.getPlayerFish().getTypeOfPlayerFish().equals("small")) {


                // Draw bird at its coordinates. Retrieve the Animation object from AssetLoader
                // Pass in the runTime variable to get the current frame.

                if (myWorld.getPlayerFish().getXVelocityOfPlayerFish() > 0) {
                    batcher.draw(AssetStation.smallFishAnimation.getKeyFrame(runTime),
                            bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
                } else {
                    batcher.draw(AssetStation.smallFishAnimation.getKeyFrame(runTime),
                            bird.getX() + bird.getWidth(), bird.getY(), -bird.getWidth(), bird.getHeight());
                }



            } else if (myWorld.getPlayerFish().getTypeOfPlayerFish().equals("medium")) {


                if (myWorld.getPlayerFish().getXVelocityOfPlayerFish()> 0) {
                    batcher.draw(AssetStation.mediumFishAnimation.getKeyFrame(runTime),
                            bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
                } else {
                    batcher.draw(AssetStation.mediumFishAnimation.getKeyFrame(runTime),
                            bird.getX() + bird.getWidth(), bird.getY(), -bird.getWidth(), bird.getHeight());
                }






            } else if (myWorld.getPlayerFish().getTypeOfPlayerFish().equals("large")) {


                if (myWorld.getPlayerFish().getXVelocityOfPlayerFish()> 0) {
                    batcher.draw(AssetStation.largeFishAnimation.getKeyFrame(runTime),
                            bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
                } else {
                    batcher.draw(AssetStation.largeFishAnimation.getKeyFrame(runTime),
                            bird.getX() + bird.getWidth(), bird.getY(), -bird.getWidth(), bird.getHeight());
                }


            } else if (myWorld.getPlayerFish().getTypeOfPlayerFish().equals("xlarge")) {

                if (myWorld.getPlayerFish().getXVelocityOfPlayerFish() > 0) {
                    batcher.draw(AssetStation.xLargeFishAnimation.getKeyFrame(runTime),
                            bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
                } else {
                    batcher.draw(AssetStation.xLargeFishAnimation.getKeyFrame(runTime),
                            bird.getX() + bird.getWidth(), bird.getY(), -bird.getWidth(), bird.getHeight());
                }

            }



            //FishProtection
            if(myWorld.getPlayerFish().isPlayerFishProtected()==true){

                batcher.draw(AssetStation.spikesProtection,
                        (myWorld.getPlayerFish().getX()+bird.getWidth())-AssetStation.spikesProtection.getRegionWidth(), myWorld.getPlayerFish().getY(),
                        AssetStation.spikesProtection.getRegionWidth(), AssetStation.spikesProtection.getRegionHeight());

            }





            //DEAD FISHES EXPLOSION

            if(myWorld.getPlayerFish().isFishBeingDestroyed()==true) {



                if(myWorld.getPlayerFish().getdeadFishType().equals("medium")) {

                    if (myWorld.getPlayerFish().getDeadFishCount() <= 12) {

                        batcher.draw(AssetStation.mediumFishDead1,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.mediumFish.getRegionWidth(), AssetStation.mediumFish.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();

                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 24) {

                        batcher.draw(AssetStation.mediumFishDead2,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.mediumFish.getRegionWidth(), AssetStation.mediumFish.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();


                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 36) {
                        batcher.draw(AssetStation.mediumFishDead3,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.mediumFish.getRegionWidth(), AssetStation.mediumFish.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();


                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 48) {

                        batcher.draw(AssetStation.mediumFishDead4,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.mediumFish.getRegionWidth(), AssetStation.mediumFish.getRegionHeight());

                        if (myWorld.getPlayerFish().getDeadFishCount() == 48) {
                            myWorld.getPlayerFish().resetDeadFishCount();
                            Gdx.app.log("MyTag", "RESET RESET RESET");


                        } else {

                            myWorld.getPlayerFish().increaseDeadFishCount();

                        }

                    }










            }else if(myWorld.getPlayerFish().getdeadFishType().equals("large")) {

                    if (myWorld.getPlayerFish().getDeadFishCount() <= 12) {

                        batcher.draw(AssetStation.largeFishDead1,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.largeFish.getRegionWidth(), AssetStation.largeFish.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();

                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 24) {

                        batcher.draw(AssetStation.largeFishDead2,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.largeFish.getRegionWidth(), AssetStation.largeFish.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();


                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 36) {
                        batcher.draw(AssetStation.largeFishDead3,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.largeFish.getRegionWidth(), AssetStation.largeFish.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();


                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 48) {

                        batcher.draw(AssetStation.largeFishDead4,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.largeFish.getRegionWidth(), AssetStation.largeFish.getRegionHeight());

                        if (myWorld.getPlayerFish().getDeadFishCount() == 48) {
                            myWorld.getPlayerFish().resetDeadFishCount();
                            Gdx.app.log("MyTag", "RESET RESET RESET");


                        } else {

                            myWorld.getPlayerFish().increaseDeadFishCount();

                        }

                    }


                }else if(myWorld.getPlayerFish().getdeadFishType().equals("xlarge")){

                    if (myWorld.getPlayerFish().getDeadFishCount() <= 10) {

                        batcher.draw(AssetStation.xLargeFishDead1,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.xLargeFishDead1.getRegionWidth(), AssetStation.xLargeFishDead1.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();

                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 20) {

                        batcher.draw(AssetStation.xLargeFishDead2,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.xLargeFishDead2.getRegionWidth(), AssetStation.xLargeFishDead2.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();


                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 30) {
                        batcher.draw(AssetStation.xLargeFishDead3,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.xLargeFishDead3.getRegionWidth(), AssetStation.xLargeFishDead3.getRegionHeight());

                        myWorld.getPlayerFish().increaseDeadFishCount();


                    } else if (myWorld.getPlayerFish().getDeadFishCount() <= 40) {

                        batcher.draw(AssetStation.xLargeFishDead4,
                                myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                                AssetStation.xLargeFishDead4.getRegionWidth(), AssetStation.xLargeFishDead4.getRegionHeight());

                        if (myWorld.getPlayerFish().getDeadFishCount() == 40) {
                            myWorld.getPlayerFish().resetDeadFishCount();
                            Gdx.app.log("MyTag", "RESET RESET RESET");


                        } else {

                            myWorld.getPlayerFish().increaseDeadFishCount();

                        }
                    }



                }
                /*
                    batcher.draw(AssetStation.largeFishDeadAnimation.getKeyFrame(runTime),
                            myWorld.getPlayerFish().getDestroyedFishX(), myWorld.getPlayerFish().getDestroyedFishY(),
                            AssetStation.largeFish.getRegionWidth(), AssetStation.largeFish.getRegionHeight());
*/





            }


            if(myWorld.getPufferFish().isPufferFishIsAvailable()==true) {


                if(myWorld.getPufferFish().getVelocityX()>0) {
                    batcher.draw(AssetStation.pufferFishAnimation.getKeyFrame(runTime),
                            myWorld.getPufferFish().getPufferFishRectangle().getX(), myWorld.getPufferFish().getPufferFishRectangle().getY(),
                            AssetStation.pufferFish.getRegionWidth(), AssetStation.pufferFish.getRegionHeight());

                }else{
                    batcher.draw(AssetStation.pufferFishAnimation.getKeyFrame(runTime),
                            myWorld.getPufferFish().getPufferFishRectangle().getX(), myWorld.getPufferFish().getPufferFishRectangle().getY(),
                            -AssetStation.pufferFish.getRegionWidth(), AssetStation.pufferFish.getRegionHeight());

                }











            }


            if(myWorld.getCoin().isCoinAvailabke()==true) {

                if(myWorld.getCoin().getCoinType().equals("coin")) {

                    batcher.draw(AssetStation.coin,
                            myWorld.getCoin().getCoinRect().getX(), myWorld.getCoin().getCoinRect().getY(),
                            AssetStation.coin.getRegionWidth(), AssetStation.coin.getRegionHeight());

                }else if(myWorld.getCoin().getCoinType().equals("health")){

                    batcher.draw(AssetStation.coinHealth,
                    myWorld.getCoin().getCoinRect().getX(), myWorld.getCoin().getCoinRect().getY(),
                            AssetStation.coin.getRegionWidth(), AssetStation.coin.getRegionHeight());

                }else if(myWorld.getCoin().getCoinType().equals("spikesprotection")){


                    batcher.draw(AssetStation.coinSpikes,
                            myWorld.getCoin().getCoinRect().getX(), myWorld.getCoin().getCoinRect().getY(),
                            AssetStation.coin.getRegionWidth(), AssetStation.coin.getRegionHeight());


                }
            }


            if(myWorld.getCoin().isCoinAvailabke2()==true) {

                if(myWorld.getCoin().getCoin2Type().equals("coin")) {
                    batcher.draw(AssetStation.coin,
                            myWorld.getCoin().getCoinRect2().getX(), myWorld.getCoin().getCoinRect2().getY(),
                            AssetStation.coin.getRegionWidth(), AssetStation.coin.getRegionHeight());


                }else if(myWorld.getCoin().getCoin2Type().equals("health")){
                    batcher.draw(AssetStation.coinHealth,
                            myWorld.getCoin().getCoinRect2().getX(), myWorld.getCoin().getCoinRect2().getY(),
                            AssetStation.coin.getRegionWidth(), AssetStation.coin.getRegionHeight());

                }else if(myWorld.getCoin().getCoin2Type().equals("spikesprotection")){


                batcher.draw(AssetStation.coinSpikes,
                        myWorld.getCoin().getCoinRect2().getX(), myWorld.getCoin().getCoinRect2().getY(),
                        AssetStation.coin.getRegionWidth(), AssetStation.coin.getRegionHeight());

                }
            }



            if(myWorld.getJaws().isJawsVisible()==true) {

                if(myWorld.getJaws().isShadowStillDisplayed()==true){


                    if(myWorld.getJaws().jawsIsAtBottomOrTop().equals("Top")) {
                        batcher.draw(AssetStation.jawsShadow,
                                0, -100,
                                1200, 920);

                    }else if(myWorld.getJaws().jawsIsAtBottomOrTop().equals("Bottom")){

                        batcher.draw(AssetStation.jawsShadow,
                                0, 1900,
                                1200, -920);


                    }





                }else {

                    if(myWorld.getJaws().jawsIsAtBottomOrTop().equals("Top")) {
                        batcher.draw(AssetStation.jaws,
                                0, -100,
                                1200, 920);

                    }else if(myWorld.getJaws().jawsIsAtBottomOrTop().equals("Bottom")){

                        batcher.draw(AssetStation.jaws,
                                0, 1900,
                                1200, -920);


                    }

                    //Will make jaws go away after 2 seconds
                    myWorld.getJaws().makeJawsGoAway();

                }
            }



            // End SpriteBatch
            batcher.end();


        }



    }





    public void drawHPTriangles(){

        if(myWorld.getPlayerFish().getHealthHP()>88) {

            batcher.draw(AssetStation.greenTriangle, 600 - AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 - 4 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());

            batcher.draw(AssetStation.greenTriangle, 600 + AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth(),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());

            batcher.draw(AssetStation.greenTriangle, 600 + 3 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());

            batcher.draw(AssetStation.greenTriangle, 600 + AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth(),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 + 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (4 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2),
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


        }else if(myWorld.getPlayerFish().getHealthHP()>76){

            batcher.draw(AssetStation.greenTriangle, 600 + AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth(),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());

            batcher.draw(AssetStation.greenTriangle, 600 + 3 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());

            batcher.draw(AssetStation.greenTriangle, 600 + AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth(),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 + 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (4 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2),
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


        }else if(myWorld.getPlayerFish().getHealthHP()>64){


            batcher.draw(AssetStation.greenTriangle, 600 + 3 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());

            batcher.draw(AssetStation.greenTriangle, 600 + AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth(),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 + 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (4 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2),
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.greenTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());



        }else if(myWorld.getPlayerFish().getHealthHP()>52){

            batcher.draw(AssetStation.yellowTriangle, 600 + AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth(),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.yellowTriangle, 600 - AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 + 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.yellowTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.yellowTriangle, 600 - (4 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2),
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.yellowTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());



        }else if(myWorld.getPlayerFish().getHealthHP()>40){

            batcher.draw(AssetStation.yellowTriangle, 600 - AssetStation.greenTriangle.getRegionWidth() / 2,
                    gameHeight / 2 + 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.yellowTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.yellowTriangle, 600 - (4 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2),
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.yellowTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());



        }else if(myWorld.getPlayerFish().getHealthHP()>28){

            batcher.draw(AssetStation.redTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 + AssetStation.greenTriangle.getRegionHeight() + AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.redTriangle, 600 - (4 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2),
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.redTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());



        }else if(myWorld.getPlayerFish().getHealthHP()>16){

            batcher.draw(AssetStation.redTriangle, 600 - (4 * AssetStation.greenTriangle.getRegionWidth() + AssetStation.greenTriangle.getRegionWidth() / 2),
                    gameHeight / 2 - 1 * AssetStation.greenTriangle.getRegionHeight() / 2, AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


            batcher.draw(AssetStation.redTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


        }else if(myWorld.getPlayerFish().getHealthHP()>4){
            batcher.draw(AssetStation.redTriangle, 600 - (3 * AssetStation.greenTriangle.getRegionWidth()),
                    gameHeight / 2 - 3 * AssetStation.greenTriangle.getRegionHeight(), AssetStation.greenTriangle.getRegionWidth(), AssetStation.greenTriangle.getRegionHeight());


        }


    }

}



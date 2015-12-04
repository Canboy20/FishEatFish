package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Can Atay on 11/10/2015.
 */


public class AssetStation {

    public static Texture texture;
    public static Texture textureBackground;
    public static Texture textureJaws;
    public static Texture mainScreenbackground;


    public static TextureRegion bg, grass;

    public static Sound coinPickUp,healthgained,bite,rip,puff;



    public static Music gameMusic;

    static BitmapFont font;







    //Animations

    public static Animation smallFishAnimation;
  //  public static Animation mediumFishAnimation;
    public static Animation largeFishAnimation;
    public static Animation largeFishDeadAnimation;


    public static Animation xLargeFishAnimation;
    public static Animation xLargeFishDeadAnimation;


    public static Animation mediumFishAnimation;
    public static Animation mediumFishDeadAnimation;

    public static Animation pufferFishAnimation;





    public static TextureRegion mainscreenbackgroundPlay,background;

    public static TextureRegion spikes;


    public static TextureRegion jaws,jawsShadow;



    //Fish Texture Regions
    public static TextureRegion smallFish, smallFishDown, smallFishUp;

    public static TextureRegion mediumFish,mediumFishDown,mediumFishDead1,mediumFishDead2,mediumFishDead3,mediumFishDead4;

    public static TextureRegion largeFish,largeFishDown,largeFishDead1,largeFishDead2,largeFishDead3,largeFishDead4;

    public static TextureRegion xLargeFishDown,xLargeFish,xLargeFishDead1,xLargeFishDead2,xLargeFishDead3,xLargeFishDead4;


    public static TextureRegion pufferFish,pufferFishDown;

    public static TextureRegion redTriangle,yellowTriangle,greenTriangle;


    public static TextureRegion coin,coinHealth,coinSpikes;

    public static TextureRegion spikesProtection;










    public static void load() {

        font = new BitmapFont(Gdx.files.internal("data/texturing.fnt"), false);


        mainScreenbackground = new Texture(Gdx.files.internal("data/mainscreenTexture.jpg"));
        mainScreenbackground.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);



        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        textureBackground = new Texture(Gdx.files.internal("data/backgroundTexture.png"));
        textureBackground.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);


        textureJaws = new Texture(Gdx.files.internal("data/jawsTexture.png"));
        textureJaws.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);



        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);

        mainscreenbackgroundPlay = new TextureRegion(mainScreenbackground, 0, 0, 1200, 1900);
        mainscreenbackgroundPlay.flip(false, true);

        background = new TextureRegion(textureBackground, 0, 0, 1200, 1900);
        background.flip(false, true);


        grass = new TextureRegion(texture, 0, 43, 143, 11);
        grass.flip(false, true);

        smallFishDown = new TextureRegion(texture, 298, 6, 146, 109);
        smallFishDown.flip(false, true);


        //Coin
        //coin = new TextureRegion(texture, 204, 1538, 210, 205);
        //coin.flip(false, true);

        coin = new TextureRegion(texture, 1148+115, 1804, 115/*106*/, 103);
        coin.flip(false, true);


        coinHealth = new TextureRegion(texture, 1639, 1804, 115/*106*/, 103);
        coinHealth.flip(false, true);

        coinSpikes = new TextureRegion(texture, 1520, 1804, 115/*106*/, 103);
        coinSpikes.flip(false, true);


        spikesProtection = new TextureRegion(texture, 227, 1557, 140, 154);
        spikesProtection.flip(false, true);


        //Puffer Fish

        redTriangle = new TextureRegion(texture, 274, 2073, 90, 102);
        redTriangle.flip(false, true);


        yellowTriangle = new TextureRegion(texture, 151, 2073, 90, 102);
        yellowTriangle.flip(false, true);

        greenTriangle = new TextureRegion(texture, 37, 2073, 90, 102);
        greenTriangle.flip(false, true);




        //Jaws

        jaws = new TextureRegion(textureJaws, 0, 0, 1200, 920);
        jaws.flip(false, true);

        jawsShadow = new TextureRegion(textureJaws, 0, 950, 1200, 920);
        jawsShadow.flip(false, true);


        //Puffer Fish

        pufferFish = new TextureRegion(texture, 1603, 55, 231, 224);
        pufferFish.flip(false, true);


        pufferFishDown = new TextureRegion(texture, 1603, 352, 231, 224);
        pufferFishDown.flip(false, true);




        //XLarge Fish

        xLargeFishDown = new TextureRegion(texture, 474, 0, 550, 323);
        xLargeFishDown.flip(false, true);

        xLargeFish = new TextureRegion(texture, 474, 377, 550, 323);
        xLargeFish.flip(false, true);


        xLargeFishDead1 = new TextureRegion(texture, 474, 770, 550, 323);
        xLargeFishDead1.flip(false, true);

        xLargeFishDead2 = new TextureRegion(texture, 474, 1119, 550, 323);
        xLargeFishDead2.flip(false, true);


        xLargeFishDead3 = new TextureRegion(texture, 474, 1505, 550, 323);
        xLargeFishDead3.flip(false, true);

        xLargeFishDead4 = new TextureRegion(texture, 474, 1889, 550, 323);
        xLargeFishDead4.flip(false, true);






        //Large Fish
        largeFish = new TextureRegion(texture, 1094, 30, 395, 236);
        largeFish.flip(false, true);

        largeFishDown = new TextureRegion(texture, 1094, 321, 395, 236);
        largeFishDown.flip(false, true);


        largeFishDead1 = new TextureRegion(texture, 1094, 629, 395, 236);
        largeFishDead1.flip(false, true);

        largeFishDead2 = new TextureRegion(texture, 1094, 914, 395, 236);
        largeFishDead2.flip(false, true);


        largeFishDead3 = new TextureRegion(texture, 1094, 1214, 395, 236);
        largeFishDead3.flip(false, true);

        largeFishDead4 = new TextureRegion(texture, 1094, 1514, 395, 236);
        largeFishDead4.flip(false, true);




        //Medium Fish
        mediumFish = new TextureRegion(texture, 0, 0, 234, 214);
        mediumFish.flip(false, true);

        mediumFishDown = new TextureRegion(texture, 0, 271, 234, 214);
        mediumFishDown.flip(false, true);


        mediumFishDead1 = new TextureRegion(texture, 0, 551, 234, 214);
        mediumFishDead1.flip(false, true);

        mediumFishDead2 = new TextureRegion(texture, 0, 814, 234, 214);
        mediumFishDead2.flip(false, true);


        mediumFishDead3 = new TextureRegion(texture, 0, 1064, 234, 214);
        mediumFishDead3.flip(false, true);

        mediumFishDead4 = new TextureRegion(texture, 0, 1306, 234, 214);
        mediumFishDead4.flip(false, true);











        //Small Fish
        smallFish = new TextureRegion(texture, 298, 146, 146, 109);
        smallFish.flip(false, true);

        smallFishUp = new TextureRegion(texture,  298, 296, 146, 109);
        smallFishUp.flip(false, true);


        spikes = new TextureRegion(texture, 29, 1569, 129, 142);
        spikes.flip(false, true);

        TextureRegion[] small = { smallFishDown, smallFish, smallFishUp };
        smallFishAnimation = new Animation(0.1f, small);
        smallFishAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        TextureRegion[] xLarge = { xLargeFishDown, xLargeFish };
        xLargeFishAnimation = new Animation(0.15f, xLarge);
        xLargeFishAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        TextureRegion[] large = { largeFish, largeFishDown };
        largeFishAnimation = new Animation(0.3f, large);
        largeFishAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        TextureRegion[] medium = { mediumFishDown, mediumFish };
        mediumFishAnimation = new Animation(0.3f, medium);
        mediumFishAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        TextureRegion[] puffer = { pufferFish, pufferFishDown };
        pufferFishAnimation = new Animation(0.3f, puffer);
        pufferFishAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);





        TextureRegion[] largeDead = { largeFishDead1,largeFishDead1,largeFishDead1,largeFishDead1,largeFishDead1,
                largeFishDead2,largeFishDead2,largeFishDead2,largeFishDead2,largeFishDead2,
                largeFishDead3,largeFishDead3,largeFishDead3,largeFishDead3,largeFishDead3,
                largeFishDead4,largeFishDead4,largeFishDead4,largeFishDead4,largeFishDead4 };
        largeFishDeadAnimation = new Animation(1f, largeDead);
        largeFishDeadAnimation.setPlayMode(Animation.PlayMode.NORMAL);


        TextureRegion[] xlargeDead = { xLargeFishDead1,xLargeFishDead1,xLargeFishDead1,xLargeFishDead1,xLargeFishDead1,
                xLargeFishDead2,xLargeFishDead2,xLargeFishDead2,xLargeFishDead2,xLargeFishDead2,
                xLargeFishDead3,xLargeFishDead3,xLargeFishDead3,xLargeFishDead3,xLargeFishDead3,
                xLargeFishDead4,xLargeFishDead4,xLargeFishDead4,xLargeFishDead4,xLargeFishDead4 };
        xLargeFishDeadAnimation = new Animation(1f, xlargeDead);
        xLargeFishDeadAnimation.setPlayMode(Animation.PlayMode.NORMAL);



        TextureRegion[] mediumDead = { mediumFishDead1,mediumFishDead1,mediumFishDead1,mediumFishDead1,mediumFishDead1,
                mediumFishDead2,mediumFishDead2,mediumFishDead2,mediumFishDead2,mediumFishDead2,
                mediumFishDead3,mediumFishDead3,mediumFishDead3,mediumFishDead3,mediumFishDead3,
                mediumFishDead4,mediumFishDead4,mediumFishDead4,mediumFishDead4,mediumFishDead4 };
        mediumFishDeadAnimation = new Animation(1f, mediumDead);
        mediumFishDeadAnimation.setPlayMode(Animation.PlayMode.NORMAL);



        coinPickUp = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
        healthgained = Gdx.audio.newSound(Gdx.files.internal("data/extralife.wav"));
        bite = Gdx.audio.newSound(Gdx.files.internal("data/bite.wav"));
        rip = Gdx.audio.newSound(Gdx.files.internal("data/ripfish.mp3"));
        puff = Gdx.audio.newSound(Gdx.files.internal("data/puff.mp3"));


        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("data/gamemusic.mp3"));






    }




    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
    }

}

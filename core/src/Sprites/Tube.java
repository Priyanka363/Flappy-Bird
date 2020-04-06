package Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    private static final int Fluctuation = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPEN = 120;
    private Texture topTube , bottomTube;
    private Vector2 posTopTube , posBotTube;
    private Random rand;
    public static final int TUBE_WIDTH = 52;
    private Rectangle boundsTop , boundsBot;



    public Tube(float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(Fluctuation) + TUBE_GAP + LOWEST_OPEN);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x , posTopTube.y , topTube.getWidth() , topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x , posBotTube.y , bottomTube.getWidth() , bottomTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(Fluctuation) + TUBE_GAP + LOWEST_OPEN);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x , posTopTube.y);
        boundsBot.setPosition(posBotTube.x , posBotTube.y);
    }

    public boolean collides(Rectangle player){
        return (player.overlaps(boundsTop) || player.overlaps(boundsBot));
     }

     public void dispose()
     {
         topTube.dispose();
         bottomTube.dispose();
     }
}

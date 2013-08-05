package com.me.ZGame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

/**
 * 游戏主屏幕,主要的逻辑都在这个类中
 * 
 * @author eddyli
 * @date 2013-08-04
 *
 */
public class GameScreen implements Screen {
	final ZGame game;
    SpriteBatch batch;
    Skin skin;
    
    PlayerSTB STB;
    PlayerTB TB;
    
    ZAudio audio;
    private float screenWidth = 0;
    private float scrrenHeight = 0;
    
    TextButton attackButton;
    
    public GameScreen(final ZGame gam) {
    	this.game = gam;
    	this.batch = this.game.batch;
    	this.screenWidth = Gdx.graphics.getWidth();
    	this.scrrenHeight = Gdx.graphics.getHeight();
    	
    	this.STB = new PlayerSTB(
    			this.screenWidth * 3 / 4,
    			this.scrrenHeight / 8,
    			batch);
    	this.TB = new PlayerTB(
    			this.screenWidth/12, 
    			this.scrrenHeight * 2 / 3,
    			batch);
    	
    	this.audio = new ZAudio();
    	//直接播放战斗音乐
    	this.audio.playFightBKMusic();
    	skin = new Skin();
    	
    	Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));
        skin.add("default", new BitmapFont());
        
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
    	attackButton = new TextButton("攻击", skin);
    
    	attackButton.setPosition(10, 10);
    }
    
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        batch.begin();
        STB.shake();
        TB.shake();
        batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

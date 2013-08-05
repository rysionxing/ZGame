/* 
 * @author eddyli
 * @date 2013-08-03
 * @desc 游戏主入口
 * */
package com.me.ZGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ZGame extends Game {
	SpriteBatch batch;
    BitmapFont font;
    
	@Override
	public void create() {
		// TODO Auto-generated method stub
		 batch = new SpriteBatch();
         //Use LibGDX's default Arial font.
         font = new BitmapFont();
         this.setScreen(new MainMenuScreen(this));
	}

	 public void render() {
		 super.render(); //important!
	 }
 
	 public void dispose() {
		 batch.dispose();
	     font.dispose();
	 }
}

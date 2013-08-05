package com.me.ZGame;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * 
 * @author eddyli
 * @category 玩家类
 *
 */
public class Player extends Object {
	
	//提前定义好的动作
	public final static int SHAKE  = 1;
	public final static int ATTACK = 2;
	
	//对象在屏幕上的初始位置
	private float posx = 0;
	private float posy = 0;
	
	//对象在屏幕上的当前位置
	private float currentx = 0;
	private float currenty = 0;
	
	//5帧以后移动到位置
	private int moveSpeed = 5;
	//每帧在xy上移动的距离
	private float moveSpeedx = 0;
	private float moveSpeedy = 0;
	
	//动作和动画的map
	private Map<Integer, Animation> action2Animation;
	
	//一个计时器
	private float stateTime = 0;
	
	//记录上次的动作
	private int   preAction = 0;
	
	//当前帧
	private TextureRegion currentFrame;
	
	public Player(final float x, final float y) {
		this.posx = this.currentx = x;
		this.posy = this.currenty = y;
		this.action2Animation = new HashMap<Integer,Animation>();
	}
	
	public void setRes(int action, String folder, int count) {
		TextureRegion[] frame = new TextureRegion[count];
		for(int i = 0; i < count ; i++) {
			String fileName = String.format("%s/%d.png",folder,i);
			Texture tx = new Texture(Gdx.files.internal(fileName));
			frame[i] = new TextureRegion(tx);
		}
		//TODO:0.2f不应该写死
		Animation animation = new Animation(0.2f, frame);
		animation.setPlayMode(Animation.LOOP);
		action2Animation.put(action, animation);	
	}
	
	public boolean play(int action, final SpriteBatch batch) {
		//一个人在一段时间只能做一个动作
		if (preAction == action) 
			stateTime += Gdx.graphics.getDeltaTime();
		else
			stateTime = 0;
		preAction = action;
		for (Map.Entry entry : action2Animation.entrySet()) {
			if ((Integer)entry.getKey() == action) {
				Animation tmpAnimation= (Animation)entry.getValue();
				this.currentFrame = tmpAnimation.getKeyFrame(stateTime, true);
				batch.draw(currentFrame, this.currentx, this.currenty);
				return tmpAnimation.isAnimationFinished(stateTime);
			}
		}
		return false;
	}
	
	
	public Boolean move(float x, float y, final SpriteBatch batch) {
		if (currentx == x && currenty == y)
			return true;
		if(this.posx == this.currentx 
				&& this.posy == this.currenty) {
			this.moveSpeedx = (x - this.posx)/this.moveSpeed;
			this.moveSpeedy = (y - this.posy)/this.moveSpeedy;
		} else {
			this.currentx += this.moveSpeedx;
			this.currenty += this.moveSpeedy;
			if (this.currentx > x )
				this.currentx = x;
			if (this.currenty > y)
				this.currenty = y;
		}
		batch.draw(currentFrame, this.currentx, this.currenty);
		return false;
	}
}

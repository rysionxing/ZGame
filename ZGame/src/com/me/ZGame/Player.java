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
 * @category �����
 *
 */
public class Player extends Object {
	
	//��ǰ����õĶ���
	public final static int SHAKE  = 1;
	public final static int ATTACK = 2;
	
	//��������Ļ�ϵĳ�ʼλ��
	private float posx = 0;
	private float posy = 0;
	
	//��������Ļ�ϵĵ�ǰλ��
	private float currentx = 0;
	private float currenty = 0;
	
	//5֡�Ժ��ƶ���λ��
	private int moveSpeed = 5;
	//ÿ֡��xy���ƶ��ľ���
	private float moveSpeedx = 0;
	private float moveSpeedy = 0;
	
	//�����Ͷ�����map
	private Map<Integer, Animation> action2Animation;
	
	//һ����ʱ��
	private float stateTime = 0;
	
	//��¼�ϴεĶ���
	private int   preAction = 0;
	
	//��ǰ֡
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
		//TODO:0.2f��Ӧ��д��
		Animation animation = new Animation(0.2f, frame);
		animation.setPlayMode(Animation.LOOP);
		action2Animation.put(action, animation);	
	}
	
	public boolean play(int action, final SpriteBatch batch) {
		//һ������һ��ʱ��ֻ����һ������
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

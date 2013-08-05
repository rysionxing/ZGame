package com.me.ZGame;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * ��ҵĻ��࣬Ҳ�������ɽӿ�
 * @author eddyli
 *
 */
public abstract class PlayerBase {
    protected float posx;
    protected float posy;
    protected SpriteBatch batch;
    
	public abstract void shake();
	public abstract void attack( List<PlayerBase> obj);
	public abstract Boolean move (float x , float y);
}

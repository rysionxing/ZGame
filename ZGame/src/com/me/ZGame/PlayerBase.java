package com.me.ZGame;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 玩家的基类，也可以理解成接口
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

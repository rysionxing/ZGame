package com.me.ZGame;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 神天兵
 * 
 * @author eddyli
 * @date 2013-08-04
 *
 */
public class PlayerSTB extends PlayerBase {
	
	//TODO:应该做成可配置
	private final int SHAKELEN = 7;
	private final String SHAKEFOLDER = "image/STB/shake";
	
	private Player player;
	
	public PlayerSTB(float x, float y, SpriteBatch batch) {
		this.posx = x;
		this.posy = y;
		this.batch = batch;
		player = new Player(x, y);
		player.setRes(Player.SHAKE, SHAKEFOLDER, SHAKELEN);
	}
	
	public void shake() {
		player.play(Player.SHAKE, batch);
	}
	
	public void attack(List<PlayerBase> obj) {
		for(PlayerBase oneObj : obj) {
			if (move(oneObj.posx, oneObj.posy)) {
				if (player.play(Player.ATTACK, batch)) {
					obj.remove(oneObj);
					break;
				}
			}
		}
	}
	
	public Boolean move(float x , float y) {
		return player.move(x, y, batch);
	}
}

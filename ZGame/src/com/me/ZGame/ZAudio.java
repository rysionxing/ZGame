package com.me.ZGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;

public class ZAudio {
	
	//TODO:����Ӧ����������ŵ�
	private Music  bkMusic;
	private String bkMusicFoler = "audio/fight/fight1.mp3";
	
	public void playFightBKMusic() {
		FileHandle musicFile = Gdx.files.internal(bkMusicFoler);
		bkMusic = Gdx.audio.newMusic(musicFile);
		bkMusic.setLooping(true);
		bkMusic.play();
	}
}

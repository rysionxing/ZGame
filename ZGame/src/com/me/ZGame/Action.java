package com.me.ZGame;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Action {
	
	private PlayerBase srcObject;
	private List<PlayerBase> destObject;
	private Method srcMethod;
	private Object[] srcParam;
	private Method destMethod;
	private Object[] destParam;
	
	public Action(PlayerBase src, List<PlayerBase> dest) {
		this.srcObject = src;
		this.destObject = dest;
	}
	
	public void setAction(Method src, Object[] srcParam, Method dest, Object[] destParam) {
		this.srcMethod  = src;
		this.srcParam   = srcParam;
		this.destMethod = dest;
		this.destParam  = destParam;
	}
	
	public void doit() {
		try {
			this.srcMethod.invoke(srcObject, srcParam);
			this.destMethod.invoke(destObject, destParam);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

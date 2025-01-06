package com.gn.wmmusic.controller;

import com.gn.wmmusic.model.dao.WmDao;

public class WmController {
	private WmDao wd = new WmDao();
	
	public int signUp(String id, String pw, String name) {
		return wd.signUp(id, pw, name);
	}
}

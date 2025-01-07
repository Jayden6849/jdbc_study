package com.gn.study.controller;

import com.gn.study.model.dao.ProjectDao;

public class ProjectController {
	private ProjectDao pd = new ProjectDao(); // controller <- model.dao
	
	public int insertProject(String projectName, String managerName) {
		return pd.insertProject(projectName, managerName);
	}
}

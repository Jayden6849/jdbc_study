package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.ProjectDao;
import com.gn.study.model.vo.ProjectVo;

public class ProjectController {
	private ProjectDao pd = new ProjectDao(); // controller <- model.dao
	
	public int insertProject(String projectName, String managerName) {
		return pd.insertProject(projectName, managerName);
	}
	
	public List<ProjectVo> selectProjectAll() {
		return pd.selectProjectAll();
	}
}

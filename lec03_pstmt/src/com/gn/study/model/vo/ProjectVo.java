package com.gn.study.model.vo;

import java.time.LocalDateTime;

public class ProjectVo {
	// field
	private int projectId;	// pk(번호)
	private String projectName;	// 프로젝트명
	private int projectManager;	// fk(employee.emp_id -> 관리자 사번)
	private LocalDateTime reg_date;	// 등록일
	private LocalDateTime mod_date;	// 수정일
	
	// constructor
	public ProjectVo() {
		super();
	}
	public ProjectVo(int projectId, String projectName, int projectManager) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
	}
	public ProjectVo(int projectId, String projectName, int projectManager, LocalDateTime reg_date,
			LocalDateTime mod_date) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
		this.reg_date = reg_date;
		this.mod_date = mod_date;
	}
	
	// getter, setter
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
	}
	public LocalDateTime getReg_date() {
		return reg_date;
	}
	public void setReg_date(LocalDateTime reg_date) {
		this.reg_date = reg_date;
	}
	public LocalDateTime getMod_date() {
		return mod_date;
	}
	public void setMod_date(LocalDateTime mod_date) {
		this.mod_date = mod_date;
	}
	
	@Override
	public String toString() {
		return "[projectId=" + projectId + ", projectName=" + projectName + ", projectManager="
				+ projectManager + ", reg_date=" + reg_date + ", mod_date=" + mod_date + "]";
	}
}

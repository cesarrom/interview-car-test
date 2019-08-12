package com.ctest.models.dto;


import java.util.Date;

import com.ctest.models.CommonModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class CommonModelDto {
	private Long id;
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date updatedAt;
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@JsonIgnore()
	public abstract CommonModel getCrudModel();
}

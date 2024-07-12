package com.medicalInfo.project.model;

import java.sql.Timestamp;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.medicalInfo.project.model.enu.MemberType;

import lombok.Data;
@Data
public class QaDTO {
	

	
	private int qa_id;
	private String writer;
	private int member_num;
	private String title;
	private Timestamp created_at;
	private String context;
	
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	private int prescript_no;
	
	public QaDTO() {};
	
	public QaDTO(String writer, int member_num, String title, String context, MemberType memberType,int prescript_no) {
		super();
		this.writer = writer;
		this.member_num = member_num;
		this.title = title;
		this.context = context;
		this.memberType = memberType;
		this.prescript_no = prescript_no;
	}

	public QaDTO(String writer, int member_num, String title, String context, MemberType memberType) {
		super();
		this.writer = writer;
		this.member_num = member_num;
		this.title = title;
		this.context = context;
		this.memberType = memberType;
	}
	
	
	
	
	
	
}

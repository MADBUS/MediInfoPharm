package com.medicalInfo.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.medicalInfo.project.model.QaDTO;

@Mapper
public interface QaMapper {
	// 게시판 전체조회
	public List<QaDTO> allList();
	
	//게시글이 내꺼인지 판단 
	public boolean isMine(int MemberNo);
	
	public int updateQa(QaDTO dto);
	
	public int deleteQa(int qa_id);
	
	//처방전 o
	public void insertQa(QaDTO dto);
	
	//처방전x
	public void  QaInsert(QaDTO dto);
	
	//한개의 게시글 
	public QaDTO getList(int qa_id);
}

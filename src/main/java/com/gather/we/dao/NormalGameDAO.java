package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.NormGameDTO;
import com.gather.we.dto.NormGameDetailDTO;
import com.gather.we.dto.NormGameListDTO;

public interface NormalGameDAO {
	// 일반경기 목록 선택
	public List<NormGameDTO> normGameListSelect(NormGameListDTO dto);
	// 일반경기 세부정보 선택
	public NormGameDetailDTO normGameDetailSelect(int no);
	// 일반경기 세부정보 목록
	public List<NormGameDetailDTO> normGameDetailAllSelect();
	// 일반경기 등록 (DB)
	public int normGameInsert(NormGameDTO dto);
	// 미개설 일반경기 정보 불러오기
	public List<NormGameDetailDTO> newNormGameList(int st_no);
	// 일반경기 사용자 개설 (DB)
	public int normGameUpdate(NormGameDTO dto);
	// 일반경기 개설 후 참여인원 증가
	public int normGameCountUp(int no);
	// 일반경기 현재인원수 업데이트
	public int currPeopleCount(int no);
}

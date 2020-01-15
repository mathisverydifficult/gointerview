package com.semi.offline.studymbr.dto;

//오프라인 스터디 참여 멤버 
public class TbStdMbrDto {

	// 스터디그룹SEQ
	private int stdSeq;

	// 아이디
	private String id;

	// 위도 위도못잡으면 디폴트 0으로
	private int stmbLat;

	// 경도 경도못잡으면 디폴트 0으로
	private int stmbLong;
	
	
	

	public TbStdMbrDto() {
		super();
	}

	public TbStdMbrDto(int stdSeq, String id, int stmbLat, int stmbLong) {
		super();
		this.stdSeq = stdSeq;
		this.id = id;
		this.stmbLat = stmbLat;
		this.stmbLong = stmbLong;
	}

	public int getStdSeq() {
		return stdSeq;
	}

	public void setStdSeq(int stdSeq) {
		this.stdSeq = stdSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStmbLat() {
		return stmbLat;
	}

	public void setStmbLat(int stmbLat) {
		this.stmbLat = stmbLat;
	}

	public int getStmbLong() {
		return stmbLong;
	}

	public void setStmbLong(int stmbLong) {
		this.stmbLong = stmbLong;
	}
}

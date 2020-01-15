package com.semi.offline.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.semi.offline.study.db.SqlMapConfig;
import com.semi.offline.study.dto.TbStudyDto;

public class TbStudyDao extends SqlMapConfig{
	
	private String namespace = "com.semi.offline.study.mapper.";
	
	public int insertTbStudy(TbStudyDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insert", dto);
			
			if(res > 0) {
				session.commit();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] : insertTbStudy");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return res;		
		
	}
	
	public List<TbStudyDto> getCalList(String stdId, String yyyyMMdd){
		
		
		
		SqlSession session = null;
		List<TbStudyDto> list = null;
		TbStudyDto dto = new TbStudyDto();
		
		try {
			
			session = getSqlSessionFactory().openSession(true);
			
			dto.setStdId(stdId);
			dto.setStdDt(yyyyMMdd);
			
			list = session.selectList(namespace+"getCalList", dto);
			
		}catch(Exception e) {
			System.out.println("[ERROR] : getCalList");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		
		return list;
	}
	
	// 3개 일정 보여주기 + row_number() sql
		public List<TbStudyDto> getCalViewList(String stdId, String yyyyMM){
			
			SqlSession session = null;
			List<TbStudyDto> list = null;
			TbStudyDto dto = new TbStudyDto();
			
			try {
				
				session = getSqlSessionFactory().openSession(true);
				
				dto.setStdId(stdId);
				dto.setStdDt(yyyyMM);
				
				list = session.selectList(namespace+"getCalViewList", dto);
				
			}catch(Exception e) {
				System.out.println("[ERROR] : getCalViewList");
				e.printStackTrace();
			}finally {
				session.close();
			}
			
			
			return list;
		}
		
		// ajax
		// DB 글 갯수 들고오는 메소드
		// 마우스 포인터하면 풍선처럼 나오는거
		public int getCalViewCount(String stdId, String yyyyMMdd) {
			
			SqlSession session = null;
			TbStudyDto dto = new TbStudyDto();
			int res = 0;
			
			try {
				
				session = getSqlSessionFactory().openSession(false);
				
				dto.setStdId(stdId);
				dto.setStdDt(yyyyMMdd);
				
				res = session.selectOne(namespace+"getCalViewCount", dto);
				
				if(res > 0) {
					session.commit();
				}
				
			}catch(Exception e) {
				System.out.println("[ERROR] : getCalViewList");
				e.printStackTrace();
			}finally {
				session.close();
			}
			
			return res;
		}
	
}

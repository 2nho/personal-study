package kr.co.goodee39.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.goodee39.vo.CommentVO;

@Service
public class CommentService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertComment(CommentVO vo) {
		sqlSessionTemplate.insert("comment.insertComment", vo);
	}
	
	public List<CommentVO> selectCommentList(CommentVO vo){
		return sqlSessionTemplate.selectList("comment.selectCommentList", vo);
	}
	
	public void deleteComment(CommentVO vo) {
		sqlSessionTemplate.delete("comment.deleteComment", vo);
	}
	
	public void updateComment(CommentVO vo) {
		sqlSessionTemplate.update("comment.updateComment", vo);
	}
}

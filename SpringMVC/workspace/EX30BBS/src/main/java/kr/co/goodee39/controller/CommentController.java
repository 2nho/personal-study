package kr.co.goodee39.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.goodee39.service.CommentService;
import kr.co.goodee39.vo.CommentVO;
import kr.co.goodee39.vo.MemberVO;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/set")
	public ResponseEntity<CommentVO> setComment(@RequestBody CommentVO vo, HttpSession session){
		
		System.out.println(vo.getComment());
		System.out.println(vo.getBnum());
		MemberVO mvo = (MemberVO)session.getAttribute("account");
		vo.setWriternum(mvo.getNum());
		vo.setWritername(mvo.getName());
		
		commentService.insertComment(vo);
		
		ResponseEntity<CommentVO> entity = new ResponseEntity<CommentVO>(vo,HttpStatus.OK);
		
		return entity;
	}
	
	@GetMapping("/get/{num}")
	public ResponseEntity<List<CommentVO>> getCommentList(@PathVariable int num){
		CommentVO vo = new CommentVO();
		vo.setBnum(num);
		
		List<CommentVO> list = commentService.selectCommentList(vo);
		
		ResponseEntity<List<CommentVO>> entity = new ResponseEntity<List<CommentVO>>(list, HttpStatus.OK);
		
		return entity;
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> dropComment(@RequestBody CommentVO vo, HttpSession session){
		
		System.out.println(vo.getNum());
		
		MemberVO mvo = (MemberVO)session.getAttribute("account");
		vo.setWriternum(mvo.getNum());
		
		commentService.deleteComment(vo);
		
		String str = "삭제되었습니다";
		
		ResponseEntity<String> entity = new ResponseEntity<String>(str , HttpStatus.OK);
		return entity;
	}
	
	@PatchMapping("/update")
	public ResponseEntity<CommentVO> patchComment(@RequestBody CommentVO vo, HttpSession session){
		
		System.out.println(vo.getNum());
		System.out.println(vo.getComment());
		
		MemberVO mvo = (MemberVO)session.getAttribute("account");
		vo.setWriternum(mvo.getNum());
		
		commentService.updateComment(vo);
		
		ResponseEntity<CommentVO> entity = new ResponseEntity<CommentVO>(vo, HttpStatus.OK);
		return entity;
	}
	
}







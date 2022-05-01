package kr.co.goodee39.controller;

import java.io.File;
import java.io.OutputStream;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.goodee39.vo.DataVO;

@Controller
public class TestController {
	
	@PostMapping("/test1")
	public String singleFileUpload(
			@RequestParam("mediaFile") MultipartFile file) throws Exception{
		
		if(!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File("D:/temp", file.getOriginalFilename()));
			System.out.println("잘 저장되었습니다.");
		}else {
			System.out.println("에러 발생");
		}
		
		return "test1_result";
	}
	
	@PostMapping("/test2")
	public String multipleFileUpload(
			@RequestParam("mediaFile") MultipartFile[] files) throws Exception{
		
		for(MultipartFile file : files) {
			if(!file.getOriginalFilename().isEmpty()) {
				file.transferTo(new File("D:/temp",file.getOriginalFilename()));
				System.out.println(file.getOriginalFilename() + " 저장 완료");
			}else {
				System.out.println("데이터가 존재하지 않습니다.");
			}
		}
		System.out.println("모든 데이터가 저장되었습니다.");
		return "test2_result";
	}
	
	@PostMapping("/test3")
	public String singleFileUploadWith(
			@RequestParam("mediaFile") MultipartFile file,
			@RequestParam String user,
			@RequestParam String url,
			Model model) throws Exception{
		
		if(!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File("D:/temp", file.getOriginalFilename()));
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		model.addAttribute("user",user);
		model.addAttribute("url",url);
		
		return "test3_result";
	}
	
	@PostMapping("/test4")
	public String singleFileUploadWith(@ModelAttribute DataVO vo, Model model) throws Exception{
		MultipartFile file = vo.getMediaFile();
		
		if(!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File("D:/temp", file.getOriginalFilename()));
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		model.addAttribute("user",vo.getUser());
		model.addAttribute("url",vo.getUrl());
		
		return "test4_result";
	}
	
	@PostMapping("/test5")
	public @ResponseBody String multipleFileUploadWithAjax(
								MultipartFile[] uploadFile) throws Exception{
		
		for(MultipartFile file : uploadFile) {
			if(!file.getOriginalFilename().isEmpty()) {
//				file.transferTo(new File("D:/temp", file.getOriginalFilename()));
				file.transferTo(new File("D:/temp", "camping.jpg"));
				System.out.println(file.getOriginalFilename() + " 저장 완료.");
			}else {
				System.out.println("파일이 존재하지 않습니다.");
			}
		}
		System.out.println("모든 데이터가 저장되었습니다.");
		return "test5에서 파일을 잘 받았습니다";
	}
	
	@GetMapping("/download")
	public void donwload(HttpServletResponse response) {
		try {
			String path = "D:/temp/camping.jpg";
			
			Path file = Paths.get(path);
			// 1. 헤더 작성
			response.setHeader("Content-Disposition", "attachment;filename="+file.getFileName());
			
			// 2. 파일 정보 및 상태 불러오기
			FileChannel fc = FileChannel.open(file, StandardOpenOption.READ);
			
			// 3. response로 file의 데이터를 전송하는 로직 만들기
			WritableByteChannel outputChannel = Channels.newChannel(response.getOutputStream());
			
			// 4. file에서 response로 데이터 전송
			fc.transferTo(0, fc.size(), outputChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



























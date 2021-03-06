package com.bupt.xrf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.xrf.service.ITaskService;

@Controller("taskController")
@RequestMapping("task")
public class TaskController {
	
	@Autowired
	private ITaskService taskService;
	
	/**
     * 文件下载
     * @Description: 
     * @param fileName
     * @param request
     * @param response
     * @return
     */
	@SuppressWarnings("resource")
	@RequestMapping("download")    
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
		String path = request.getServletContext().getRealPath("public/file/任务书.txt");
	    File file = new File(path);
	    byte[] body = null;
	    InputStream is = new FileInputStream(file);
	    body = new byte[is.available()];
	    is.read(body);
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attchement;filename=" + file.getName());
	    HttpStatus statusCode = HttpStatus.OK;
	    ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
	    return entity;
	}
	
	@RequestMapping("gettasktimeandcost") 
	@ResponseBody
	public Map<String, Object> gettasktimeandcost() {
		Map<String, Object> resultmap = new HashMap<>();
		resultmap = taskService.gettasktimeandcost();
		return resultmap;
	}
}

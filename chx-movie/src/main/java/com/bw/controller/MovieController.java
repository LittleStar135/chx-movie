package com.bw.controller;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Movie;
import com.bw.service.MovieService;
import com.bw.vo.MovieVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MovieController {

	
	@Autowired
	private MovieService service;
	
	@RequestMapping("list.do")
	public String list(MovieVo vo,Model m) {
		
		if (vo.getPageNum()==null || "".equals(vo.getPageNum())) {
			vo.setPageNum(1);
		}
		
		PageHelper.startPage(vo.getPageNum(), 2);
		List<Movie> list = service.list(vo);
		
		PageInfo<Movie> page = new PageInfo<Movie>(list);
		
		m.addAttribute("list",list);
		m.addAttribute("vo", vo);
		m.addAttribute("page", page);
		return "list";
		
	}
	
	@RequestMapping("del.do")
	@ResponseBody
	public int del(String ids) {
		
		int i = service.del(ids);
		
		return i;
		
	}
	
	
}

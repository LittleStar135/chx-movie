package com.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bw.dao.MovieDao;
import com.bw.entity.Movie;
import com.bw.service.MovieService;
import com.bw.vo.MovieVo;

@Service
@Transactional
public class MoviceServiceImpl implements MovieService{

	@Autowired
	private MovieDao dao;

	@Override
	public List<Movie> list(MovieVo vo) {
		// TODO Auto-generated method stub
		return dao.list(vo);
	}

	@Override
	public int del(String ids) {
		int i = dao.del(ids);
		return i;
	}

	
	
}

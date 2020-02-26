package com.bw.service;

import java.util.List;

import com.bw.entity.Movie;
import com.bw.vo.MovieVo;

public interface MovieService {

	List<Movie> list(MovieVo vo);
	
	int del(String ids);
	
}

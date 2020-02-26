package com.bw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.entity.Movie;
import com.bw.vo.MovieVo;

public interface MovieDao {

	
	List<Movie> list(MovieVo vo);
	
	int del(String ids);
	
	
}

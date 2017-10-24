package com.ideal.service;

import com.ideal.pojo.MovieInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/6.
 */
public interface QueryMovieInfoService {

    @Transactional(propagation= Propagation.REQUIRED)
    public List<MovieInfo> queryMovie();

}

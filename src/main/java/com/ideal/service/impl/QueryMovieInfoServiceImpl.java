package com.ideal.service.impl;

import com.ideal.dao.MovieInfoDao;
import com.ideal.pojo.MovieInfo;
import com.ideal.service.QueryMovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
=======

import java.util.ArrayList;
>>>>>>> 0f20d1b658da6a3bb0fdbefd72e57e05a22705ce
import java.util.List;

/**
 * Created by Administrator on 2017/10/6.
 */
@Service
public class QueryMovieInfoServiceImpl implements QueryMovieInfoService {

    @Autowired
    private MovieInfoDao movieInfo;

    @Override
    public List<MovieInfo> queryMovie(){
        List<MovieInfo> queryMovieInfo = new ArrayList<>();
        try{
            queryMovieInfo = movieInfo.queryMovieInfo();

        }catch (Exception e){
            e.printStackTrace();
        }
        return queryMovieInfo;
    }

}

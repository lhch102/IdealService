package com.ideal.service.impl;

import com.ideal.dao.MovieInfoDao;
import com.ideal.pojo.MovieInfo;
import com.ideal.service.QueryMovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/6.
 */
@Service("QueryMovieInfoService")
public class QueryMovieInfoServiceImpl implements QueryMovieInfoService {

    @Autowired
    private MovieInfoDao movieInfo;

    @Override
    public List<MovieInfo> queryMovie(){
        return movieInfo.queryMovieInfo();
    }

}

package com.ideal.rest;

import com.ideal.pojo.MovieInfo;
import com.ideal.service.QueryMovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 查询影片信息接口
 *
 * @author Administrator
 * @date 2017/10/6
 */
//@Singleton
@Path("/queryMovieInfo")
public class QueryMovieInfo {

    @Autowired
    private QueryMovieInfoService queryMovieInfoService;
    @GET
    //返回给client为json类型（application/json）
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovieInfo> queryMovieInfo() {
        return queryMovieInfoService.queryMovie();
    }

}

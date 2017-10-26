package com.ideal.rest;

import com.ideal.pojo.MovieInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Administrator on 2017/10/26.
 */
public class QueryMovieInfoTest {

    Logger logger = Logger.getLogger(this.getClass());
    @Test
    public void queryMovieInfo() throws Exception {
        QueryMovieInfo queryMovieInfo = new QueryMovieInfo();
        List<MovieInfo> movieInfos = queryMovieInfo.queryMovieInfo();
        logger.info(movieInfos);
    }

}
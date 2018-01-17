package com.ideal.dao;

import com.ideal.pojo.MovieInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MovieInfo record);

    int insertSelective(MovieInfo record);

    MovieInfo selectByPrimaryKey(Integer id);

    /**
     * 查询影片信息
     * @return
     */
    List<MovieInfo> queryMovieInfo();

    int updateByPrimaryKeySelective(MovieInfo record);

    int updateByPrimaryKeyWithBLOBs(MovieInfo record);

    int updateByPrimaryKey(MovieInfo record);
}
package com.tao.neo4jdemo.repository.movie;

import com.tao.neo4jdemo.entity.movie.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yehaitao01
 */
@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    // 自定义查询方法
    List<Movie> findByTitle(String title);
}

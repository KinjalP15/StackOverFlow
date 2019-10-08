package com.pnc.training.StackOverflow.DAO;

import com.pnc.training.StackOverflow.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagDao extends JpaRepository<Tag, Long> {

    @Query(value="Select count(*) from tag t where t.tagName = ?1 ", nativeQuery = true)
    int findTagCountByTagName(String tagName);

    @Query(value="SELECT * FROM tag t WHERE t.tagName = ?1", nativeQuery = true)
    Tag findByTagName(String tagName);
}

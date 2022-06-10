package org.revature.revbook.data;

import org.revature.revbook.entity.VotePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotePostRepository extends JpaRepository<VotePost, Long> {


    @Query(value = "SELECT * FROM vote_post where post_id = ?1", nativeQuery = true)
    public List<VotePost> findByPostIdIs(Long post_id);

    @Query(value = "SELECT * FROM vote_post where post_id = ?1 and voter_id = ?2", nativeQuery = true)
    public VotePost findByPostAndUser(Long post_id, Long user_id);

}

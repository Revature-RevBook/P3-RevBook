package org.revature.revbook.data;

import org.revature.revbook.entity.VotePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// VotePostRepository Interface Class
// This interface class will handle the data logic of the VotePost objects in the database for the application.
@Repository
public interface VotePostRepository extends JpaRepository<VotePost, Long> {

    public List<VotePost> findByPostId(long postId);
}

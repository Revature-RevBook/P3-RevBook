package org.revature.revbook.data;

import org.revature.revbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// PostRepository Interface Class
// This interface class will handle the data logic of the Post objects in the database for the application.
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> findByUserUserId(Long userId);
}

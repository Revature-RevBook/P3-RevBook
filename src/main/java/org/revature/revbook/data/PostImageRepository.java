package org.revature.revbook.data;

import org.revature.revbook.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// PostImageRepository Interface Class
// This interface class will handle the data logic of the PostImage objects in the database for the application.
@Repository
public interface PostImageRepository extends JpaRepository<PostImage, Long> {

    public PostImage findByPostId(Long postId);
}

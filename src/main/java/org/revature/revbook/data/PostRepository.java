package org.revature.revbook.data;

import org.revature.revbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

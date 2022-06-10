package org.revature.revbook.data;

import org.revature.revbook.entity.PostImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImageRepository extends JpaRepository<PostImages, Long> {

}

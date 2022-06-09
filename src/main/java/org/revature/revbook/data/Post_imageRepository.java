package org.revature.revbook.data;

import org.revature.revbook.entity.post_images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Post_imageRepository extends JpaRepository<post_images, Long> {

}

package org.revature.revbook.data;

import org.revature.revbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
=======

>>>>>>> e00470297e87e6a9623b08438f6ffb8d923b7c23
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

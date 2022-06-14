package org.revature.revbook.data;

import org.revature.revbook.entity.SubComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// SubCommentRepository Interface Class
// This interface class will handle the data logic of the SubComment objects in the database for the application.
@Repository
public interface SubCommentRepository extends JpaRepository<SubComment, Long> {

    public List<SubComment> findByCommentId(Long commentId);
}

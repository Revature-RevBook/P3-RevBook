package org.revature.revbook.data;

import org.revature.revbook.entity.VoteComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// VoteCommentRepository Interface Class
// This interface class will handle the data logic of the VoteComment objects in the database for the application.
@Repository
public interface VoteCommentRepository extends JpaRepository<VoteComment, Long> {

    public List<VoteComment> findByVoterId(Long voterId);

    public List<VoteComment> findByCommentId(Long commentId);
}

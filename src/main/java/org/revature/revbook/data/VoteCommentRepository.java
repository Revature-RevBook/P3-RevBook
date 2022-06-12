package org.revature.revbook.data;

import org.revature.revbook.entity.VoteComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteCommentRepository extends JpaRepository<VoteComment, Long> {
}

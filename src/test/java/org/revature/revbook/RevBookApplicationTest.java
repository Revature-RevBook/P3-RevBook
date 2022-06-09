package org.revature.revbook;


import org.junit.jupiter.api.*;
import org.revature.revbook.data.*;
import org.revature.revbook.entity.Message;
import org.revature.revbook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// Use the @TestMethodOrder annotation to set the test order to be ordered numerically:
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RevBookApplicationTest
{
    @Autowired
    CommentService commentService;

    @Autowired
    MessageService messageService;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    VoteCommentService voteCommentService;

    @Autowired
    VotePostService votePostService;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VoteCommentRepository voteCommentRepository;

    @Autowired
    VotePostRepository votePostRepository;




    //============================================================================================================
    //                                      EXAMPLE TESTS
    //============================================================================================================
    @Test
    // Use the @Order annotation to supply the test order for each specific test:
    @Order(1)
    public void shouldAnswerWithTrue()
    {
        System.out.println("Test 1");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(2)
    public void shouldAnswerWithFalse()
    {
        System.out.println("Test 2");
        Assertions.assertFalse(false);
    }

    @Test
    @Order(3)
    public void shouldAnswerWithEquals()
    {
        System.out.println("Test 3");
        Assertions.assertEquals(5, 5);
    }

    /*==================================================================================================================
                                               CREATE TESTS
     ==================================================================================================================*/
    @Test
    void testAddComment(){


    }

    @Test
    void testAddMessage(){

    }

    @Test
    void testAddPost(){

    }

    @Test
    void testAddUser(){

    }

    @Test
    void testAddVoteComment(){

    }

    @Test
    void testAddVotePost(){

    }

    /*==================================================================================================================
                                               READ TESTS
     ==================================================================================================================*/

    @Test
    void testGetComment(){

    }

    @Test
    void testGetMessage(){

    }

    @Test
    void testGetPost(){

    }

    @Test
    void testGetUser(){

    }

    @Test
    void testGetVoteComment(){

    }

    @Test
    void testGetVotePost(){

    }

    /*==================================================================================================================
                                               UPDATE TESTS
     ==================================================================================================================*/

    @Test
    void testUpdateComment(){

    }

    @Test
    void testUpdateMessage(){

    }

    @Test
    void testUpdatePost(){

    }

    @Test
    void testUpdateUser(){

    }

    @Test
    void testUpdateVoteComment(){

    }

    @Test
    void testUpdateVotePost(){

    }

    /*==================================================================================================================
                                               DELETE TESTS
     ==================================================================================================================*/

    @Test
    void testDeleteComment(){

    }

    @Test
    void testDeleteMessage(){

    }

    @Test
    void testDeletePost(){

    }

    @Test
    void testDeleteUser(){

    }

    @Test
    void testDeleteVoteComment(){

    }

    @Test
    void testDeleteVotePost(){

    }


    /*==================================================================================================================
                                               OTHER TESTS
     ==================================================================================================================*/

}

package org.revature.revbook;


import org.junit.jupiter.api.*;
import org.revature.revbook.data.*;
import org.revature.revbook.entity.Message;
import org.revature.revbook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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
   // @Order(1)
    public void shouldAnswerWithTrue()
    {
        System.out.println("Test 1");
        Assertions.assertTrue(true);
    }

    @Test
   // @Order(2)
    public void shouldAnswerWithFalse()
    {
        System.out.println("Test 2");
        Assertions.assertFalse(false);
    }

    @Test
  //  @Order(3)
    public void shouldAnswerWithEquals()
    {
        System.out.println("Test 3");
        Assertions.assertEquals(5, 5);
    }

    /*==================================================================================================================
                                               CREATE TESTS
     ==================================================================================================================*/
    @Test
    @Order(5)
    void testAddComment(){


    }

    @Test
    @Order(9)
    void testAddMessage(){

    }

    @Test
    @Order(13)
    void testAddPost(){

    }

    @Test
    @Order(1)
    void testAddUser(){


    }

    @Test
    @Order(17)
    void testAddVoteComment(){

    }

    @Test
    @Order(21)
    void testAddVotePost(){

    }

    /*==================================================================================================================
                                               READ TESTS
     ==================================================================================================================*/

    @Test
    @Order(6)
    void testGetComment(){

    }

    @Test
    @Order(10)
    void testGetMessage(){

    }

    @Test
    @Order(14)
    void testGetPost(){

    }

    @Test
    @Order(2)
    void testGetUser(){

    }

    @Test
    @Order(18)
    void testGetVoteComment(){

    }

    @Test
    @Order(22)
    void testGetVotePost(){

    }

    /*==================================================================================================================
                                               UPDATE TESTS
     ==================================================================================================================*/

    @Test
    @Order(7)
    void testUpdateComment(){

    }

    @Test
    @Order(11)
    void testUpdateMessage(){

    }

    @Test
    @Order(15)
    void testUpdatePost(){

    }

    @Test
    @Order(3)
    void testUpdateUser(){

    }

    @Test
    @Order(19)
    void testUpdateVoteComment(){

    }

    @Test
    @Order(23)
    void testUpdateVotePost(){

    }

    /*==================================================================================================================
                                               DELETE TESTS
     ==================================================================================================================*/

    @Test
    @Order(8)
    void testDeleteComment(){

    }

    @Test
    @Order(12)
    void testDeleteMessage(){

    }

    @Test
    @Order(16)
    void testDeletePost(){

    }

    @Test
    @Order(4)
    void testDeleteUser(){

    }

    @Test
    @Order(20)
    void testDeleteVoteComment(){

    }

    @Test
    @Order(24)
    void testDeleteVotePost(){

    }


    /*==================================================================================================================
                                               OTHER TESTS
     ==================================================================================================================*/

}

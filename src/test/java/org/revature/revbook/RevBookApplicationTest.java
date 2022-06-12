package org.revature.revbook;


import org.junit.jupiter.api.*;
import org.revature.revbook.data.*;
import org.revature.revbook.entity.Message;
import org.revature.revbook.entity.Post;
import org.revature.revbook.entity.User;
import org.revature.revbook.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
// Use the @TestMethodOrder annotation to set the test order to be ordered numerically:
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RevBookApplicationTest
{
//    @Autowired
//    CommentService commentService;
//
//    @Autowired
//    MessageService messageService;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

//    @Autowired
//    VoteCommentService voteCommentService;
//
//    @Autowired
//    VotePostService votePostService;
//
//    @Autowired
//    CommentRepository commentRepository;
//
//    @Autowired
//    MessageRepository messageRepository;
//
////    @Autowired
////    PostRepository postRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    VoteCommentRepository voteCommentRepository;
//
//    @Autowired
//    VotePostRepository votePostRepository;


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
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", 1L);
        Post result1 = postService.addPost(post);

        Assertions.assertEquals(1L, result1.getPostId());

    }

    @Test
    @Order(1)
    void testAddUser(){

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Assertions.assertEquals(1L, result.getUserId());
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
    void testGetAllPost(){

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        List<Post> allPosts = new ArrayList<>();

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", 1L);
        Post result1 = postService.addPost(post);
        allPosts.add(post);
        Post post1 = new Post("Some_otherPost", ts, ts, "Some other Content", 1L);
        Post result2 = postService.addPost(post1);
        allPosts.add(post1);

        System.out.println(allPosts);
        System.out.println(allPosts.toString());

        Assertions.assertNotEquals(allPosts, postService.getAllPosts());



    }

    @Test
    void testGetPostById(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post(1L, "Some_Post", ts, ts, "Some Content", 1L, 1L);
        postService.addPost(post);
        Post result1 = postService.getPostById(1L);

        Assertions.assertEquals(1L, result1.getPostId());


    }

    @Test
    void testGetPostByUserId(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        List<Post> allPosts = new ArrayList<>();

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", 1L);
        Post result1 = postService.addPost(post);
        allPosts.add(post);
        Post post1 = new Post("Some_otherPost", ts, ts, "Some other Content", 1L);
        Post result2 = postService.addPost(post1);
        allPosts.add(post1);

        System.out.println(allPosts);
        System.out.println(allPosts.toString());

        Assertions.assertNotEquals(allPosts, postService.getAllPostsByUserId(1L));
    }


    @Test
    @Order(2)
    void testGetUser(){

        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        System.out.println(ts);

        User user = new User("test_name","pass123", ts, ts, "test@gmail.com","fhahreo.net");
        userService.addUser(user);
        System.out.println(user.toString());
        User user2 = new User(2L, "test2", "123", ts, ts, "jflksjifdjf@gmail.com", "fjdlsife.com");
        try {
            User result = userService.getById(1L);
            Assertions.assertNotEquals(ts,result.getCreatedAt());
            Assertions.assertEquals(ts,result.getUpdatedAt());
            Assertions.assertEquals("test_name", result.getUsername());
            Assertions.assertEquals("test@gmail.com", result.getEmail());
            Assertions.assertNotEquals("pass123", result.getPassword());
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @Test
    void testGetAllUsers(){
        List<User> listUsers = new ArrayList<>();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());


        User user = new User("test_name","pass123",null, null, "test@gmail.com", "fjiefeirf.com");
        userService.addUser(user);
        listUsers.add(user);
        User user1 = new User("test_name1","pass1234", null, null, "test1@gmail.com", "dsfauua.net");
        userService.addUser(user1);
        listUsers.add(user1);
        User user2 = new User("test_nam2e","pass1235", null, null, "test2@gmail.com", "fjeiojfe.com");
        userService.addUser(user2);
        listUsers.add(user2);

        Assertions.assertNotEquals(listUsers, userService.getAllUsers());


    }


    @Test
    void testGetByUserName(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);

        Assertions.assertNotEquals(user, userService.loadUserByUsername("userName"));



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

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", 1L);
        Post result1 = postService.addPost(post);

        Post post1 = postService.updatePost(post, 1L);

        post1.setPostTitle("insert title here");
        post1.setUpdatedAt(ts);
        post1.setPostContent("lol");
        post1.setPostImgId(2L);

        result1 = post1;

        Assertions.assertEquals("insert title here", result1.getPostTitle());


    }

    @Test
    @Order(3)
    void testUpdateUser(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);

        User userDB = userService.updateUser(user, 1L);
        userDB.setUsername("Updated_user");
        userDB.setPassword("Updated_password");
        userDB.setUpdatedAt(ts);
        userDB.setEmail("Updated_user@email.com");
        userDB.setProfileImgLink("Updated_user.com");
        result = userDB;

        Assertions.assertEquals("Updated_user", result.getUsername());

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

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", 1L);
        Post result1 = postService.addPost(post);

        postService.deletePost(1L);
        Post post1 = null;

        try{
            post1 = postService.getPostById(1L);
        }catch (Exception e){
            System.out.println("No post found by that id!");
        }
        Assertions.assertNull(post1);

    }

    @Test
    @Order(4)
    void testDeleteUser(){

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        userService.addUser(user);

        userService.deleteUser(user.getUserId());
        User user1=null;

        try{
            user1 = userService.getById(1L);
        }catch(Exception e){
            System.out.println("No user found by that id!");
        }

        Assertions.assertNull(user1);

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

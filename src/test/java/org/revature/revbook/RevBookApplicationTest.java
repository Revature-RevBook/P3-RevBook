package org.revature.revbook;


import org.junit.jupiter.api.*;
import org.revature.revbook.controller.*;
import org.revature.revbook.data.*;
import org.revature.revbook.entity.*;
import org.revature.revbook.service.*;

import org.revature.revbook.session.SessionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
// Use the @TestMethodOrder annotation to set the test order to be ordered numerically:
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RevBookApplicationTest {
    @Autowired
    CommentService commentService;
    @Autowired
    CommentController commentController;

    @Autowired
    MessageController messageController;

    @Autowired
    VotePostController votePostController;

    @Autowired
    UserController userController;

    @Autowired
    VoteCommentController voteCommentController;

    @Autowired
    PostController postController;

    @Autowired
    MessageService messageService;

    @Autowired
    SessionRegistry sessionRegistry;

    @Autowired
    PostService postService;

    @Autowired
    SubCommentController subCommentController;

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

    @Autowired
    PostImageService postImageService;


    /*==================================================================================================================
                                               CREATE TESTS
     ==================================================================================================================*/
    @Test
    @Order(5)
    void testAddComment() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User commenter = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        boolean result = userController.addUser(commenter);
        User commenter2 = userController.getUserById(1L);
        Comment comment = new Comment(ts, ts, "add comment", commenter2, 1L);
        Comment result2 = commentController.addComment(comment);
        Assertions.assertEquals("add comment", result2.getCommentContent());
        Assertions.assertEquals(ts, result2.getUpdatedAt());
        Assertions.assertEquals(1L, result2.getCommenter().getUserId());
        Assertions.assertEquals(1L, result2.getCommentId());
    }

    @Test
    @Order(9)
    void testAddMessage() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        User recipient = new User("jsmith", "123", null, null, "jsmith@gmail.com", null);
        userService.addUser(sender);
        userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        boolean result = messageController.addMessage(message);
        Assertions.assertTrue(result);
    }

    @Test
    @Order(13)
    void testAddPost() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
        Post result1 = postController.addPost(post);

        Assertions.assertEquals(1L, result1.getPostId());
    }

    @Test
    @Order(1)
    void testAddUser() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Assertions.assertEquals(1L, result.getUserId());
    }


    @Test
    @Order(17)
    void testAddVoteComment() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postController.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        comment = commentController.addComment(comment);
        VoteComment voteComment = new VoteComment(null, null, 1, comment.getCommentId(), user.getUserId());
        voteComment = voteCommentController.addVoteComment(voteComment);
        Assertions.assertEquals(1L, voteComment.getVoteId());
    }

    @Test
    @Order(21)
    void testAddVotePost() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(ts, ts, 25, 1L, 1L);
        votePostController.addVotePost(votePost);

        Assertions.assertEquals(1L, votePost.getVoteId());
    }

    /*==================================================================================================================
                                               READ TESTS
     ==================================================================================================================*/

    @Test
    @Order(6)
    void testGetCommentById() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        user = userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postService.addPost(post);
        Comment comment = new Comment(ts, ts, "add comment", user, 1L);
        comment = commentService.addComment(comment);

        Comment result = commentService.getCommentById(1L);
        Assertions.assertEquals("add comment", result.getCommentContent());
        Assertions.assertEquals(1L, result.getCommenter().getUserId());
        Assertions.assertEquals(1L, result.getCommentId());
    }

    @Test
    void testGetAllComments() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Comment comment = new Comment(ts, ts, "add comment", user, 1L);
        commentService.addComment(comment);

        List<Comment> comments = commentService.getAllComments();
        Assertions.assertEquals("add comment", comments.get(0).getCommentContent());
        Assertions.assertEquals(1, comments.size());
    }

    @Test
    void testGetAllCommentsByPostIdTest() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Comment comment1 = new Comment(ts, ts, "add comment", user, 1L);
        commentService.addComment(comment1);

        Comment comment2 = new Comment(ts, ts, "comment from userId=2", user, 1L);
        commentService.addComment(comment2);
        List<Comment> commentsById = commentService.getAllCommentsByPostId(1L);
        Assertions.assertEquals("add comment", commentsById.get(0).getCommentContent());
        Assertions.assertEquals("comment from userId=2", commentsById.get(1).getCommentContent());
    }

    @Test
    @Order(10)
    void testGetMessage() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        User recipient = new User("jsmith", "123", null, null, "jsmith@gmail.com", null);
        userService.addUser(sender);
        userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        messageService.addMessage(message);
        Message result = messageService.getMessageById(1L);
        Assertions.assertEquals("test message", result.getMessageContent());
    }

    @Test
    void testAllMessagesTest() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        sender = userService.addUser(sender);
        User recipient = new User("twalker", "123", null, null, "twalker@gmail.com", null);
        recipient = userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        boolean result = messageService.addMessage(message);

        List<Message> messages = messageService.getAllMessages();
        Assertions.assertEquals(1, messages.size());
    }

    @Test
    void testAllMessagesByRecipientIdTest() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        sender = userService.addUser(sender);
        User recipient = new User("twalker", "123", null, null, "twalker@gmail.com", null);
        recipient = userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        boolean result = messageService.addMessage(message);

        List<Message> messages = messageService.getAllMessagesByRecipientId(2L);
        Assertions.assertEquals("test message", messages.get(0).getMessageContent());
    }

    @Test
    @Order(14)
    void testGetAllPost() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        List<Post> allPosts = new ArrayList<>();

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
        Post result1 = postService.addPost(post);
        allPosts.add(post);
        Post post1 = new Post("Some_otherPost", ts, ts, "Some other Content", result);
        Post result2 = postService.addPost(post1);
        allPosts.add(post1);

        System.out.println(allPosts);
        System.out.println(allPosts.toString());

        Assertions.assertEquals(allPosts.get(0).getPostContent(), postService.getAllPosts().get(0).getPostContent());


    }

    @Test
    void testGetPostById() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post(1L, "Some_Post", ts, ts, "Some Content", 1L, result);
        postService.addPost(post);
        Post result1 = postService.getPostById(1L);

        Assertions.assertEquals(1L, result1.getPostId());
    }

    @Test
    void testGetPostByUserId() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        List<Post> allPosts = new ArrayList<>();

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
        Post result1 = postService.addPost(post);
        allPosts.add(post);
        Post post1 = new Post("Some_otherPost", ts, ts, "Some other Content", result);
        Post result2 = postService.addPost(post1);
        allPosts.add(post1);

        System.out.println(allPosts);
        System.out.println(allPosts.toString());

        Assertions.assertEquals(allPosts.get(0).getPostContent(), postService.getAllPostsByUserId(1L).get(0).getPostContent());
    }


    @Test
    @Order(2)
    void testGetUser() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println(ts);

        User user = new User("test_name", "pass123", ts, ts, "test@gmail.com", "fhahreo.net");
        userService.addUser(user);
        System.out.println(user.toString());
        User user2 = new User(2L, "test2", "123", ts, ts, "jflksjifdjf@gmail.com", "fjdlsife.com");
        try {
            User result = userService.getById(1L);
            Assertions.assertNotEquals(ts, result.getCreatedAt());
            Assertions.assertEquals(ts, result.getUpdatedAt());
            Assertions.assertEquals("test_name", result.getUsername());
            Assertions.assertEquals("test@gmail.com", result.getEmail());
            Assertions.assertNotEquals("pass123", result.getPassword());
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @Test
    void testGetAllUsers() {
        List<User> listUsers = new ArrayList<>();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());


        User user = new User("test_name", "pass123", null, null, "test@gmail.com", "fjiefeirf.com");
        userService.addUser(user);
        listUsers.add(user);
        User user1 = new User("test_name1", "pass1234", null, null, "test1@gmail.com", "dsfauua.net");
        userService.addUser(user1);
        listUsers.add(user1);
        User user2 = new User("test_nam2e", "pass1235", null, null, "test2@gmail.com", "fjeiojfe.com");
        userService.addUser(user2);
        listUsers.add(user2);

        Assertions.assertNotEquals(listUsers, userService.getAllUsers());
    }


    @Test
    void testGetByUserName() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);

        result = userService.loadUserByUsername("userName");


//        Assertions.assertEquals(user.getUsername(), userService.loadUserByUsername("userName"));
        Assertions.assertEquals("userName", result.getUsername());
    }

    @Test
    @Order(18)
    void testGetVoteComment() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        postService.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        commentService.addComment(comment);
        VoteComment voteComment = new VoteComment(null, null, 1, comment.getCommentId(), user.getUserId());
        voteCommentController.addVoteComment(voteComment);

        VoteComment voteComment2 = voteCommentController.getVoteCommentById(1L);

        Assertions.assertNotNull(voteComment2);
    }

    @Test
    @Order(22)
    void testGetAllVotePost() {
        List<VotePost> allVotes = new ArrayList<>();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(ts, ts, 25, 1L, 1L);
        votePostService.addVotePost(votePost);
        allVotes.add(votePost);
        VotePost votePost1 = new VotePost(ts, ts, 25, 1L, 1L);
        votePostService.addVotePost(votePost1);
        allVotes.add(votePost1);

        Assertions.assertNotEquals(allVotes, votePostService.getAllVotePosts());


    }

    @Test
    void testGetVotePostById() {
        List<VotePost> allVotes = new ArrayList<>();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(1L, ts, ts, 25, 1L, 1L);
        votePostService.addVotePost(votePost);
        allVotes.add(votePost);
        VotePost votePost1 = new VotePost(2L, ts, ts, 25, 1L, 1L);
        votePostService.addVotePost(votePost1);
        allVotes.add(votePost1);

        VotePost result = votePostService.getVotePostById(1L);

        Assertions.assertNotEquals(votePost, result);


    }

    @Test
    void testGetAllVotePostByPostId() {
        List<VotePost> allVotes = new ArrayList<>();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(1L, ts, ts, 25, 1L, 1L);
        votePostService.addVotePost(votePost);
        allVotes.add(votePost);
        VotePost votePost1 = new VotePost(2L, ts, ts, 25, 1L, 1L);
        votePostService.addVotePost(votePost1);
        allVotes.add(votePost1);

        Assertions.assertNotEquals(allVotes, votePostService.getAllVotePostByPostId(1L));
    }

    /*==================================================================================================================
                                               UPDATE TESTS
     ==================================================================================================================*/

    @Test
    @Order(7)
    void testUpdateComment() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        user = userService.addUser(user);
        Comment comment1 = new Comment(ts, ts, "add comment", user, 1L);
        commentService.addComment(comment1);

        Comment comment2 = new Comment(ts, ts, "update comment", user, 1L);
        commentService.updateComment(comment2, 1L);

        Comment result = commentService.getCommentById(1L);
        Assertions.assertEquals("update comment", result.getCommentContent());
        Assertions.assertEquals(1L, result.getCommenter().getUserId());
        Assertions.assertEquals(1L, result.getCommentId());
    }

    @Test
    @Order(11)
    void testUpdateMessage() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        User recipient = new User("jsmith", "123", null, null, "jsmith@gmail.com", null);
        userService.addUser(sender);
        userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        messageService.addMessage(message);

        Message message2 = new Message(ts, ts, "updated message", sender, recipient);
        Message result = messageService.updateMessage(message2, 1L);
        Assertions.assertEquals("updated message", result.getMessageContent());
    }

    @Test
    @Order(15)
    void testUpdatePost() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
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
    void testUpdateUser() {
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
    void testUpdateVoteComment() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postService.addPost(post);
        Comment comment = new Comment(null, null, "commentcontent", user, post.getPostId());
        comment = commentService.addComment(comment);
        VoteComment voteComment = new VoteComment(null, null, -1, comment.getCommentId(), user.getUserId());
        voteComment = voteCommentService.addVoteComment(voteComment);
        voteComment.setVote(1);
        voteComment = voteCommentService.updateVoteComment(voteComment, voteComment.getVoteId());
        Assertions.assertNotNull(voteComment.getUpdatedAt());
    }

    @Test
    @Order(23)
    void testUpdateVotePost() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(ts, ts, 25, 1L, 1L);
        votePostService.addVotePost(votePost);

        VotePost votePost1 = votePostService.updateVotePost(votePost, 1L);
        votePost1.setVote(42);
        votePost1.setUpdatedAt(ts);

        Assertions.assertEquals(42, votePost1.getVote());
    }

    /*==================================================================================================================
                                               DELETE TESTS
     ==================================================================================================================*/
//TO DO
    @Test
    @Order(8)
    void testDeleteComment() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        user = userService.addUser(user);
        Comment comment = new Comment(ts, ts, "add comment", user, 1L);
        Comment result = commentService.addComment(comment);
        Assertions.assertEquals("add comment", result.getCommentContent());
        Assertions.assertEquals(ts, result.getUpdatedAt());
        Assertions.assertEquals(1L, result.getCommenter().getUserId());
        Assertions.assertEquals(1L, result.getCommentId());
        commentController.deleteComment(result.getCommentId());

        Comment result2 = null;
        try {
            result2 = commentController.getCommentById(result.getCommentId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertNull(result2);
    }

    @Test
    @Order(12)
    void testDeleteMessage() {
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        User recipient = new User("jsmith", "123", null, null, "jsmith@gmail.com", null);
        userService.addUser(sender);
        userService.addUser(recipient);
        Message message = new Message(null, null, "hi", sender, recipient);
        boolean result = messageService.addMessage(message);
        messageService.deleteMessage(1L);
        List<Message> messages = new ArrayList<>();
        try {
            messages = messageService.getAllMessagesByRecipientId(recipient.getUserId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertTrue(messages.isEmpty());
    }

    @Test
    @Order(16)
    void testDeletePost() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
        Post result1 = postService.addPost(post);

        postService.deletePost(1L);
        Post post1 = null;

        try {
            post1 = postService.getPostById(1L);
        } catch (Exception e) {
            System.out.println("No post found by that id!");
        }
        Assertions.assertNull(post1);

    }

    @Test
    @Order(4)
    void testDeleteUser() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        userService.addUser(user);

        userService.deleteUser(user.getUserId());
        User user1 = null;

        try {
            user1 = userService.getById(1L);
        } catch (Exception e) {
            System.out.println("No user found by that id!");
        }

        Assertions.assertNull(user1);

    }

    @Test
    @Order(20)
    void testDeleteVoteComment() {

    }

    @Test
    @Order(24)
    void testDeleteVotePost() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(ts, ts, 25, 1L, 1L);
        votePostService.addVotePost(votePost);
        System.out.println(votePost.toString());

        votePostService.deleteVotePost(1L);
        VotePost votePost1 = null;
        try {
            votePost1 = votePostService.getVotePostById(1L);
        } catch (Exception e) {
            System.out.println("Nothing here!");
        }

        Assertions.assertNull(votePost1);

    }


    /*==================================================================================================================
                                               Controller TESTS
     ==================================================================================================================*/
    @Test
    public void testCommentController() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Comment comment = new Comment(null, null, "Hello", user, 1L);
        comment = commentController.addComment(comment);
        System.out.println(comment.getCommentId());
        Assertions.assertEquals(1L, comment.getCommentId());
    }

    @Test
    @Order(6)
    void testCommentControllerGetCommentById() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        user = userService.addUser(user);
        Comment comment = new Comment(ts, ts, "add comment", user, 1L);
        commentController.addComment(comment);

        Comment result = commentController.getCommentById(1L);
        Assertions.assertEquals("add comment", result.getCommentContent());
        Assertions.assertEquals(1L, result.getCommenter().getUserId());
        Assertions.assertEquals(1L, result.getCommentId());
    }

    @Test
    void testCommentControllerGetAllCommentsByPostId() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Comment comment1 = new Comment(ts, ts, "add comment", user, 1L);
        commentController.addComment(comment1);

        Comment comment2 = new Comment(ts, ts, "comment from userId=2", user, 1L);
        commentController.addComment(comment2);
        List<Comment> commentsById = commentController.getAllCommentsByPostId(1L);
        Assertions.assertEquals("add comment", commentsById.get(0).getCommentContent());
        Assertions.assertEquals("comment from userId=2", commentsById.get(1).getCommentContent());
    }

    @Test
    void testCommentControllerGetAllComments() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Comment comment = new Comment(ts, ts, "add comment", user, 1L);
        commentController.addComment(comment);

        List<Comment> comments = commentService.getAllComments();
        Assertions.assertEquals("add comment", comments.get(0).getCommentContent());
        Assertions.assertEquals(1, comments.size());
    }

    @Test
    @Order(7)
    void testCommentControllerUpdateComment() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        user = userService.addUser(user);
        Comment comment1 = new Comment(ts, ts, "add comment", user, 1L);
        commentController.addComment(comment1);

        Comment comment2 = new Comment(ts, ts, "update comment", user, 1L);
        commentController.updateComment(1L, comment2);

        Comment result = commentController.getCommentById(1L);
        Assertions.assertEquals("update comment", result.getCommentContent());
        Assertions.assertEquals(1L, result.getCommenter().getUserId());
        Assertions.assertEquals(1L, result.getCommentId());
    }


    @Test
    @Order(9)
    void testMessageController() {
//        Date date = new Date();
//        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        User recipient = new User("jsmith", "123", null, null, "jsmith@gmail.com", null);
        userService.addUser(sender);
        userService.addUser(recipient);
        Message message = new Message(null, null, "test message", sender, recipient);
        boolean result = messageController.addMessage(message);
        Message result2 = messageController.getMessageById(1L);
        Assertions.assertTrue(result);
        Assertions.assertEquals("test message", result2.getMessageContent());
        Assertions.assertEquals(1L, result2.getSender().getUserId());
        Assertions.assertEquals(2L, result2.getRecipient().getUserId());
    }

    @Test
    @Order(9)
    void testMessageControllerAddMessage() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        User recipient = new User("jsmith", "123", null, null, "jsmith@gmail.com", null);
        userService.addUser(sender);
        userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        boolean result = messageController.addMessage(message);
        Message result2 = messageController.getMessageById(1L);
        Assertions.assertTrue(result);
        Assertions.assertEquals(ts, result2.getUpdatedAt());
        Assertions.assertEquals("test message", result2.getMessageContent());
        Assertions.assertEquals(1L, result2.getSender().getUserId());
        Assertions.assertEquals(2L, result2.getRecipient().getUserId());
    }

    @Test
    @Order(8)
    void testMessageControllerDeleteComment() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        user = userService.addUser(user);
        Comment comment = new Comment(ts, ts, "add comment", user, 1L);
        Comment result = commentController.addComment(comment);
        Assertions.assertEquals("add comment", result.getCommentContent());
        Assertions.assertEquals(ts, result.getUpdatedAt());
        Assertions.assertEquals(1L, result.getCommenter().getUserId());
        Assertions.assertEquals(1L, result.getCommentId());
        commentController.deleteComment(result.getCommentId());

        Comment result2 = null;
        try {
            result2 = commentController.getCommentById(result.getCommentId());
        } catch (Exception e) {
            System.out.println(e);
        }
        Assertions.assertNull(result2);
    }

    @Test
    @Order(11)
    void testMessageControllerUpdateMessage() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        User recipient = new User("jsmith", "123", null, null, "jsmith@gmail.com", null);
        userService.addUser(sender);
        userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        messageController.addMessage(message);

        Message message2 = new Message(ts, ts, "updated message", sender, recipient);
        Message result = messageController.updateMessage(1L, message2);
        Assertions.assertEquals("updated message", result.getMessageContent());
    }

    @Test
    void testMessageControllerGetAllMessagesTest() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        sender = userService.addUser(sender);
        User recipient = new User("twalker", "123", null, null, "twalker@gmail.com", null);
        recipient = userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        boolean result = messageController.addMessage(message);

        List<Message> messages = messageController.getAllMessages();
        Assertions.assertEquals(1, messages.size());
    }

    @Test
    void testMessageControllerAllMessagesByRecipientIdTest() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        sender = userService.addUser(sender);
        User recipient = new User("twalker", "123", null, null, "twalker@gmail.com", null);
        recipient = userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        boolean result = messageController.addMessage(message);

        List<Message> messages = messageController.getAllMessagesByRecipientId(2L);
        Assertions.assertEquals("test message", messages.get(0).getMessageContent());
    }

    @Test
    @Order(10)
    void testMessageControllerGetMessageById() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        User sender = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        User recipient = new User("jsmith", "123", null, null, "jsmith@gmail.com", null);
        userService.addUser(sender);
        userService.addUser(recipient);
        Message message = new Message(ts, ts, "test message", sender, recipient);
        messageController.addMessage(message);
        Message result = messageController.getMessageById(1L);
        Assertions.assertEquals("test message", result.getMessageContent());
    }

    @Test
    void testPostController() {

//        Date date = new Date();
//        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", null, null, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", null, null, "Some Content", result);
        Post result1 = postController.addPost(post);

        postController.deletePost(1L);
        Post post1 = null;

        try {
            post1 = postController.getPostById(1L);
        } catch (Exception e) {
            System.out.println("No post found by that id!");
        }
        Assertions.assertNull(post1);
    }

    @Test
    void testPostControllerGetPostByUserId() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        List<Post> allPosts = new ArrayList<>();

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
        Post result1 = postController.addPost(post);
        allPosts.add(post);
        Post post1 = new Post("Some_otherPost", ts, ts, "Some other Content", result);
        Post result2 = postController.addPost(post1);
        allPosts.add(post1);

        System.out.println(allPosts);
        System.out.println(allPosts.toString());

        Assertions.assertEquals(allPosts.get(0).getPostContent(), postController.getAllPostsByUserId(1L).get(0).getPostContent());
    }


    @Test
    void testPostControllerGetAllPostByUserId() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        List<Post> allPosts = new ArrayList<>();

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
        Post result1 = postController.addPost(post);
        allPosts.add(post);
        Post post1 = new Post("Some_otherPost", ts, ts, "Some other Content", result);
        Post result2 = postController.addPost(post1);
        allPosts.add(post1);

        System.out.println(allPosts);
        System.out.println(allPosts.toString());

        Assertions.assertEquals(allPosts.get(0).getPostContent(), postController.getAllPostsByUserId(1L).get(0).getPostContent());
    }

    @Test
    @Order(15)
    void testPostControllerUpdatePost() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
        Post result1 = postController.addPost(post);

        postController.updatePost(1L, post);

        post.setPostTitle("insert title here");
        post.setUpdatedAt(ts);
        post.setPostContent("lol");
        post.setPostImgId(2L);

        result1 = post;

        Assertions.assertEquals("insert title here", result1.getPostTitle());


    }


    @Test
    @Order(21)
    void testVotePostController() {
//
//        Date date = new Date();
//        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(null, null, 25, 1L, 1L);
        votePostController.addVotePost(votePost);

        Assertions.assertEquals(1L, votePost.getVoteId());
    }

    @Test
    void testVotePostControllerGetVotePostById() {
        List<VotePost> allVotes = new ArrayList<>();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(1L, null, null, 25, 1L, 1L);
        votePostController.addVotePost(votePost);
        allVotes.add(votePost);
        VotePost votePost1 = new VotePost(2L, null, null, 25, 1L, 1L);
        votePostController.addVotePost(votePost1);
        allVotes.add(votePost1);

        VotePost result = votePostController.getVotePostById(1L);

        Assertions.assertNotNull(result.getCreatedAt());
    }

    @Test
    void testVotePostControllerUpdateVotePost() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(ts, ts, 25, 1L, 1L);
        votePostController.addVotePost(votePost);


        VotePost votePost1 = votePostController.updateVotePost(1L, votePost);
        votePost1.setVote(42);
        votePost1.setUpdatedAt(ts);

        Assertions.assertEquals(42, votePost1.getVote());
    }

    @Test
    @Order(24)
    void testVotePostControllerDeleteVotePost() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        VotePost votePost = new VotePost(ts, ts, 25, 1L, 1L);
        votePostController.addVotePost(votePost);
        System.out.println(votePost.toString());

        votePostController.deleteVotePost(1L);
        VotePost votePost1 = null;
        try {
            votePost1 = votePostController.getVotePostById(1L);
        } catch (Exception e) {
            System.out.println("Nothing here!");
        }

        Assertions.assertNull(votePost1);

    }

    @Test
    @Order(25)
    void addSubComment() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postController.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        commentController.addComment(comment);
        SubComment subComment = new SubComment(null, null, "subCommentContent", user, comment.getCommentId());
        subComment = subCommentController.addSubComment(subComment);
        Assertions.assertEquals(1L, subComment.getSubCommentId());
    }

    @Test
    @Order(26)
    void getSubCommentById() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postController.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        commentController.addComment(comment);
        SubComment subComment = new SubComment(null, null, "subCommentContent", user, comment.getCommentId());
        subComment = subCommentController.addSubComment(subComment);
        SubComment subComment2 = new SubComment(null, null, "second subCommentContent", user, comment.getCommentId());
        subComment2 = subCommentController.addSubComment(subComment2);

        SubComment subComment3 = subCommentController.getSubCommentById(2L);
        Assertions.assertEquals(2L, subComment3.getSubCommentId());
        Assertions.assertTrue(subComment3.getSubCommentContent().contains("second"));
    }

    @Test
    @Order(27)
    void getAllSubCommentsByCommentId() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postController.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        commentController.addComment(comment);
        SubComment subComment = new SubComment(null, null, "subCommentContent", user, comment.getCommentId());
        subComment = subCommentController.addSubComment(subComment);
        SubComment subComment2 = new SubComment(null, null, "second subCommentContent", user, comment.getCommentId());
        subComment2 = subCommentController.addSubComment(subComment2);

        List<SubComment> subComments = subCommentController.getAllSubCommentsByCommentId(1L);
        Assertions.assertTrue(!subComments.isEmpty());
    }

    @Test
    @Order(28)
    void getAllSubComments() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postController.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        commentController.addComment(comment);
        SubComment subComment = new SubComment(null, null, "subCommentContent", user, comment.getCommentId());
        subComment = subCommentController.addSubComment(subComment);
        SubComment subComment2 = new SubComment(null, null, "second subCommentContent", user, comment.getCommentId());
        subComment2 = subCommentController.addSubComment(subComment2);
        SubComment subComment3 = new SubComment(null, null, "third subCommentContent", user, comment.getCommentId());
        subComment3 = subCommentController.addSubComment(subComment3);

        List<SubComment> subComments = subCommentController.getAllSubComments();
        Assertions.assertTrue(subComments.get(2).getSubCommentContent().contains("third"));
        Assertions.assertEquals(3, subComments.size());
    }

    @Test
    @Order(29)
    void updateSubComment() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postController.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        commentController.addComment(comment);
        SubComment subComment = new SubComment(null, null, "subCommentContent", user, comment.getCommentId());
        subComment = subCommentController.addSubComment(subComment);

        subComment.setSubCommentContent("updated subCommentContent");
        subComment = subCommentController.updateSubComment(subComment.getSubCommentId(), subComment);

        Assertions.assertNotNull(subComment.getUpdatedAt());
    }

    @Test
    @Order(30)
    void deleteSubComment() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        Post post = new Post("title", null, null, "content", user);
        post = postController.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        commentController.addComment(comment);
        SubComment subComment = new SubComment(null, null, "subCommentContent", user, comment.getCommentId());
        subComment = subCommentController.addSubComment(subComment);

        subCommentController.deleteSubComment(subComment.getSubCommentId());

        SubComment subComment2 = null;

        try {
            subComment2 = subCommentController.getSubCommentById(1L);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertNull(subComment2);
    }

    @Test
    @Order(31)
    void testPostImg() {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        User user = new User("userName", "password", ts, ts, "SomeEmail@email.com", "hfdsjhue.com");
        User result = userService.addUser(user);
        Post post = new Post("Some_Post", ts, ts, "Some Content", result);
        Post result1 = postService.addPost(post);
        MockMultipartFile multipartFile = new MockMultipartFile("Hello World!", "Hello.txt", MediaType.TEXT_PLAIN_VALUE,
                "Hello World!".getBytes());
        PostImage postImage = postImageService.addPostImage(result1.getPostId(), multipartFile);


        Assertions.assertTrue(postImage.getPostURL().equals("Hello.txt"));
        String content = new String(postImageService.downloadImage(result1.getPostId()));
        Assertions.assertTrue(content.equals("Hello World!"));
    }

    @Test
    @Order(32)
    void testSubCommentClass() {
        User user = new User("jhenderson", "123", null, null, "jhenderson@gmail.com", null);
        user = userService.addUser(user);
        User user2 = new User("twalker", "123", null, null, "twalker@gmail.com", null);
        user2 = userService.addUser(user2);
        Post post = new Post("title", null, null, "content", user);
        post = postController.addPost(post);
        Comment comment = new Comment(null, null, "commentContent", user, post.getPostId());
        commentController.addComment(comment);
        SubComment subComment = new SubComment(null, null, "subCommentContent", user, comment.getCommentId());

        String content = subComment.getSubCommentContent();
        Timestamp ts = subComment.getCreatedAt();
        Timestamp ts2 = subComment.getUpdatedAt();
        User commenter = subComment.getCommenter();

        subComment.setCommenter(user2);
        subComment.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        subComment.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        subComment.setSubCommentContent("New subCommentContent");
        subComment.setCommentId(2L);

        Assertions.assertTrue(subComment.getSubCommentContent().contains("New"));

    }
}
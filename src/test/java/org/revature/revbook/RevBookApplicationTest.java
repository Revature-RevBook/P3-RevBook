package org.revature.revbook;


import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// Use the @TestMethodOrder annotation to set the test order to be ordered numerically:
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RevBookApplicationTest
{
    //Autowire services here


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

    //Create tests here
}

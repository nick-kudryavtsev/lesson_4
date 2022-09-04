package nt.nick.junit_example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class JUnitExamplesTest {

    @BeforeAll
    static void preConditions(){
        System.out.println("pre-conditions");
    }

    @AfterAll
    static void postConditions(){
        System.out.println("post-conditions");
    }

    @AfterEach
    void resetSmth(){
        System.out.println("reset after each test");
    }

    @Test
    void check(){
        System.out.println("test 1");
    }

    @Test
    void check2(){
        System.out.println("test 2");
    }
}

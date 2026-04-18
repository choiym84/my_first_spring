package com.example.springstart.service;

import com.example.springstart.domain.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void blank_title(){

        Post post1 = new Post("","hello world","최열음");

        Assertions.assertThrows(IllegalArgumentException.class,()->postService.writePost(post1));

    }

    @Test
    void blank_content(){

        Post post1 = new Post("hello world","","최열음");

        Assertions.assertThrows(IllegalArgumentException.class,()->postService.writePost(post1));

    }

    @Test
    void blank_writer(){

        Post post1 = new Post("hello world","hello world","");


        Assertions.assertThrows(IllegalArgumentException.class,()->postService.writePost(post1));

    }

    @Test
    void findPosts_returnsLatestFirst() throws InterruptedException {
        Post post1 = new Post("old", "content", "writer");
        Thread.sleep(10);
        Post post2 = new Post("new", "content", "writer");

        postService.writePost(post1);
        postService.writePost(post2);

        List<Post> posts = postService.findPosts("latest");

        assertEquals("new", posts.get(0).getTitle());
        assertEquals("old", posts.get(1).getTitle());
    }


}
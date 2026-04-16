package com.example.springstart.repository;

import com.example.springstart.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void save() {
        Post post = new Post("title", "content", "writer");

        Post saved = postRepository.save(post);

        assertNotNull(saved.getId());
        assertEquals("title", saved.getTitle());
        assertEquals("content", saved.getContent());
        assertEquals("writer", saved.getWriter());
        assertNotNull(saved.getCreatedAt());
    }

    @Test
    void findAllByOrderByCreatedAtDesc() throws InterruptedException {
        Post post1 = new Post("title1", "content1", "writer1");
        Thread.sleep(10);
        Post post2 = new Post("title2", "content2", "writer2");

        postRepository.save(post1);
        postRepository.save(post2);

        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();

        assertEquals(2, posts.size());
        assertEquals("title2", posts.get(0).getTitle());
        assertEquals("title1", posts.get(1).getTitle());
    }
}

package com.example.springstart.service;


import com.example.springstart.domain.Post;
import com.example.springstart.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Transactional
    public Post writePost(Post post) {

        String title = post.getTitle();
        if (title == null || title.isBlank()) {
            //무슨 익셉션을 터뜨려야하지?
            throw new IllegalArgumentException("제목이 비어있습니다.");
        }

        String writer = post.getWriter();
        if (writer == null || writer.isBlank()) {
            //여기도 무슨 익셉션?
            throw new IllegalArgumentException("작성자가 비어있습니다.");
        }
        String content = post.getContent();
        if (content == null || content.isBlank()) {
            //사실 본문이 비어있는 것이 뭐가 문제인지 잘 모르겠음 그래도 까라니까 깐다.
            throw new IllegalArgumentException("본분이 비어있습니다.");
        }
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<Post> findPosts() {
        return postRepository.findAll();
//        return postRepository.findAllByOrderByCreatedAtDesc();
    }

}

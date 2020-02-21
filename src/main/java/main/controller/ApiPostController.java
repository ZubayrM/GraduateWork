package main.controller;

import main.model.ModerationStatus;
import main.model.Posts;
import main.model.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiPostController {

    @Autowired
    PostsRepository postsRepository;

    @GetMapping("/api/post/{offset},{limit},{status}")
    public List<Posts> postsList(int offset, int limit, ModerationStatus status){
        List<Posts> list = new ArrayList<>();
        Iterable<Posts> iterable = postsRepository.findAll();
        for (Posts post: iterable){
          list.add(post);
        }
        int count = list.size();




        return list;
    }

}

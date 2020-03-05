package main.controller;

import main.MySQL.SqlCommands;
import main.Repositories.PostsRepository;
import main.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ApiPostController {


    @Autowired
    PostsRepository postsRepository;


    @GetMapping("/api/post")
    public ResponseEntity postsList(Integer offset, Integer limit, Mode mode){
        int count = 0;

        List<Posts> list = postsRepository.findByMode(mode,1,ModerationStatus.ACCEPTED);

        if ((offset + limit) > list.size()) limit = list.size()-offset;
        List<Posts> posts = list.subList(offset, offset+limit);
        count += posts.size();

        Map<Object, Object> postMap = new TreeMap<>();

        for (Posts post: posts){
            postMap.put("id", post.getId());
            postMap.put("time", post.getTime());
            postMap.put("title", post.getTitle());
            postMap.put("announce", post.getText());
            postMap.put("liceCount", post.getText());
            postMap.put("dislikeCount", post.getText());
            postMap.put("commentCount", post.getText());
            postMap.put("viewCount", post.getText());
        }

        ///////////// export //////////////////////////////
        Map<Object,Object> map = new TreeMap<>();        //
        map.put("count", count);                         //
        map.put("posts", postMap);                         //
        ///////////////////////////////////////////////////

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/api/post/search/{query}")
    public ResponseEntity getPosts(String query, int limit){
        return null;
    }

    @GetMapping("/api/post/{id}")
    public ResponseEntity getPost(int id){
        return null;
    }

    @GetMapping("api/post/byDate/")
    public ResponseEntity getPostsByDate(LocalDate date){
        return null;
    }

    @GetMapping("/api/post/byTag")
    public ResponseEntity getPostsByTag(String tag){
        return null;
    }

    @GetMapping("/api/post/moderation/")
    public ResponseEntity getPostsModeration(int offset, int limit, ModerationStatus status){
        return null;
    }

    @GetMapping("/api/post/my")
    public ResponseEntity getMyPosts(int id){
        return null;
    }

    @PostMapping("/api/post/")
    public ResponseEntity addPost(LocalDate time, int active, String title, String text, String tags){
        return null;
    }

    @PostMapping("/api/image/")
    public String addImage(String path){
        return null;
    }

    @PutMapping("/api/post/{id}")
    public ResponseEntity update(LocalDate time, int active, String title, String text, String tags){
        return null;
    }

    @PostMapping("/api/comment/")
    public ResponseEntity addComment(int parentId, int postId, String text){
        return null;
    }

    @GetMapping("/api/tag/")
    public ResponseEntity getTags(String query){
        return null;
    }

    @PostMapping("/api/post/like/")
    public ResponseEntity like(int postId){
        return null;
    }

    @PostMapping("/api/post/dislike/")
    public ResponseEntity dislike(int postId){
        return null;
    }





}

package main.controller;

import com.mysql.cj.xdevapi.Collection;
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
    Repositories.PostsRepository postsRepository;


    @GetMapping("/api/post")
    public ResponseEntity postsList(Integer offset, Integer limit, String mode){
        int count;
        Iterable<Posts> iterator = postsRepository.findAll();
        List<Posts> list = new ArrayList<>();
        for (Posts post: iterator){
            list.add(post);
        }


        List<Posts> postsList = list.stream()
                .filter(post -> post.getIsActive() == 1)
                .filter(post -> post.getModerationStatus() == ModerationStatus.ACCEPTED)
                .collect(Collectors.toList());

        switch (mode){
            case "recent" : {
                postsList.sort(Comparator.comparing(Posts::getTime));
                Collections.reverse(postsList);
            }
            break;
            case "popular " : postsList.sort(Comparator.comparing(post -> post.getPostCommentsList().size()));
            break;
            case "best" : postsList.sort(Comparator.comparing(post -> post.getPostVotesList().size()));
            break;
            case "early" :postsList.sort(Comparator.comparing(Posts::getTime)) ;
        }

        count = postsList.size();
        if ((offset + limit) > count) limit = count;
        List<Posts> posts = postsList.subList(offset, offset+limit);

        ///////////// export //////////////////////////////
        Map<Object,Object> map = new TreeMap<>();        //
        map.put("count", list.size());                   //
        map.put("posts", posts);                         //
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

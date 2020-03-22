package main.controller;
import main.Repositories.PostCommentsRepository;
import main.Repositories.PostVotesRepository;
import main.Repositories.PostsRepository;
import main.Repositories.UsersRepository;
import main.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
public class ApiPostController {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostVotesRepository postVotesRepository;

    @Autowired
    PostCommentsRepository postCommentsRepository;

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/api/post")
    public ResponseEntity postsList(Integer offset, Integer limit, Mode mode){
        int count = 0;

        List<Posts> list = postsRepository.findByMode(mode,1,ModerationStatus.ACCEPTED);

        if ((offset + limit) > list.size()) limit = list.size()-offset;
        List<Posts> postsList = list.subList(offset, offset+limit);
        count += postsList.size();

        Set<Map> posts = new TreeSet<>(Comparator.comparing(o -> String.valueOf(o.get("id"))));

        for (Posts post: postsList){
            Map<String, Object> postMap = new TreeMap<>();
            Users user = usersRepository.findById(post.getUserId());

            postMap.put("id", post.getId());
            postMap.put("time", post.getTime());
            postMap.put("user",new TreeMap<String, Object>(){{
                put("id", user.getId());
                put("name", user.getName());
            }});
            postMap.put("title", post.getTitle());
            postMap.put("announce", post.getText());
            postMap.put("liceCount", postVotesRepository.findByPostIdAndValue(post.getId(),1).size());
            postMap.put("dislikeCount", postVotesRepository.findByPostIdAndValue(post.getId(), -1).size());
            postMap.put("commentCount", postCommentsRepository.findByPostId(post.getId()).size());
            postMap.put("viewCount", post.getViewCount());

            posts.add(postMap);
        }

        ///////////// export //////////////////////////////
        Map<Object,Object> result = new TreeMap<>();     //
        result.put("count", count);                      //
        result.put("posts", posts);                      //
        ///////////////////////////////////////////////////

        return ResponseEntity.status(HttpStatus.OK).body(result);
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

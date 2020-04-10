package main.controllers.api;
import main.Repositories.PostCommentsRepository;
import main.Repositories.PostVotesRepository;
import main.Repositories.PostsRepository;
import main.Repositories.UsersRepository;
import main.dto.respose.ListPostResponseDto;
import main.model.*;
import main.model.enums.Mode;
import main.model.enums.ModerationStatus;
import main.services.PostsService;
import main.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.*;

@RestController
public class ApiPostController {

    private PostsRepository postsRepository;
    private PostVotesRepository postVotesRepository;
    private PostCommentsRepository postCommentsRepository;
    private UsersRepository usersRepository;
    private PostsService postsService;
    private UsersService usersService;

    public ApiPostController(PostsRepository postsRepository, PostVotesRepository postVotesRepository, PostCommentsRepository postCommentsRepository, UsersRepository usersRepository, PostsService postsService) {
        this.postsRepository = postsRepository;
        this.postVotesRepository = postVotesRepository;
        this.postCommentsRepository = postCommentsRepository;
        this.usersRepository = usersRepository;
        this.postsService = postsService;
    }

    @GetMapping("/api/post")
    public ResponseEntity postsList(@DefaultValue("0") Integer offset,@DefaultValue("10") Integer limit, Mode mode){
        return ResponseEntity.ok(null);
}

    @GetMapping("/api/post/search/")
    public ResponseEntity getPosts(Integer offset, Integer limit, String query){

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

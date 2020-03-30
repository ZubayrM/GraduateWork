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

        ListPostResponseDto listPostResponseDto = postsService.getListPost(mode);

        usersService.getAuthor(listPostResponseDto);

        listPostResponseDto.builder()
                .count(postsService.getListPost(mode))




        /////////////////////////// внизу старый код////////////////////////
        int count = 0;
        List<Posts> list = postsRepository.findByMode(mode,1, ModerationStatus.ACCEPTED);

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

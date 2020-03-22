package main.services;

import main.Repositories.PostsRepository;
import main.Repositories.UsersRepository;
import main.dto.responseModel.ListPostResponseDto;
import main.dto.responseModel.PostResponseDto;
import main.dto.responseModel.UserResponseDto;
import main.model.Posts;
import main.model.enums.Mode;
import main.model.enums.ModerationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    UsersRepository usersRepository;


    public ListPostResponseDto getListPost(Mode mode, ModerationStatus moderationStatus){

        PostResponseDto postResponseDto;

        Iterable<Posts> posts = postsRepository.findByMode(mode,1,moderationStatus);
        List<PostResponseDto> responseDto = new ArrayList<>();
        for (Posts post : posts){
            UserResponseDto userDto = new UserResponseDto();
            userDto.setId(post.getUserId());
            userDto.setName(usersRepository.findById(post.getUserId()).getName());

            PostResponseDto response = new PostResponseDto();
            response.setId(post.getId());
            response.setTime(post.getTime());
            response.setUserResponseDto(userDto);
            response.setTitle(post.getTitle());
            response.setAnnounce("???");
            response.setLiceCount(1);
            response.setDislikeCount(1);
            response.setCommentCount(1);
            response.setViewCount(1);
        }

        ListPostResponseDto.builder()
                .count((int)postsRepository.count())
                .posts(responseDto)
                .build();
        return null;
    }

}

package main.services;

import main.Repositories.PostsRepository;
import main.dto.respose.ListPostResponseDto;
import main.dto.respose.PostResponseDto;
import main.dto.respose.UserResponseDto;
import main.model.Posts;
import main.model.enums.Mode;
import main.model.enums.ModerationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    PostsRepository postsRepository;

    public ListPostResponseDto getListPost(Mode mode){

        List<Posts> postsList = postsRepository.findByMode(mode,1, ModerationStatus.ACCEPTED);
        PostResponseDto postResponseDto = new PostResponseDto();
        ListPostResponseDto listPostResponseDto = new ListPostResponseDto();

        for (Posts request: postsList){
            postResponseDto = PostResponseDto.builder()
                    .id(request.getId())
                    .time(request.getTime())
                    .userResponseDto(null)
                    .title(request.getTitle())
                    .announce(null)
                    .liceCount(null)
                    .dislikeCount(null)
                    .viewCount(null)
                    .build();
            listPostResponseDto.getPosts().add(postResponseDto);
        }

        return ListPostResponseDto.builder()
                .count((int)postsRepository.count())
                .post(postResponseDto)
                .build();
    }

    public Integer countPosts(){
        return (int) postsRepository.count();
    }

}

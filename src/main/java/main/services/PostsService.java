package main.services;

import main.Repositories.PostsRepository;
import main.dto.respose.ListPostResponseDto;
import main.dto.respose.PostDto;
import main.dto.respose.PostLDCVDto;
import main.dto.respose.UserDto;
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
        PostDto postLDCVDto;
        ListPostResponseDto listPostResponseDto = new ListPostResponseDto();

        for (Posts request: postsList){
            postLDCVDto = new PostDto(request.getId(), request.getTime(), new UserDto(),request.getTitle(), request.getTitle());
            listPostResponseDto.getPosts().add(postLDCVDto);
        }

        return ListPostResponseDto.builder()
                .count((int)postsRepository.count())
                .build();
    }

    public Integer countPosts(){
        return (int) postsRepository.count();
    }

}

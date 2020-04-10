package main.services;

import main.Repositories.PostsRepository;
import main.dto.respose.ListPostResponseDto;
import main.dto.respose.PostDto;
import main.dto.respose.PostLDCVDto;
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
        PostDto postLDCVDto = new PostLDCVDto();
        ListPostResponseDto listPostResponseDto = new ListPostResponseDto();


        for (Posts request: postsList){
            postLDCVDto = PostLDCVDto.builder()
                    .id(request.getId())
                    .time(request.getTime())
                    .userResponseDto(null)
                    .title(request.getTitle())
                    .announce(null)
                    .liceCount(null)
                    .dislikeCount(null)
                    .viewCount(null)
                    .build();
            listPostResponseDto.getPosts().add(postLDCVDto);
        }

        return ListPostResponseDto.builder()
                .count((int)postsRepository.count())
                .post(postLDCVDto)
                .build();
    }

    public Integer countPosts(){
        return (int) postsRepository.count();
    }

}

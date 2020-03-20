package main.services;

import main.Repositories.PostsRepository;
import main.dto.responseModel.ListPostResponseDto;
import main.dto.responseModel.PostResponseDto;
import main.model.enums.Mode;
import main.model.enums.ModerationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    PostsRepository postsRepository;

    public ListPostResponseDto getListPost(Mode mode, ModerationStatus moderationStatus){

        PostResponseDto postResponseDto

        ListPostResponseDto.builder()
                .count((int)postsRepository.count())
                .posts(postsRepository.findByMode(mode,1, moderationStatus))
                .build();
        return null;
    }

}

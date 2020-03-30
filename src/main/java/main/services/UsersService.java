package main.services;

import main.Repositories.UsersRepository;
import main.dto.respose.ListPostResponseDto;
import main.dto.respose.PostResponseDto;
import main.dto.respose.UserResponseDto;
import main.model.Posts;
import main.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersService {

    private UsersRepository usersRepository;


    public ListPostResponseDto getAuthor(ListPostResponseDto response) {

        response.getPosts().stream().forEach(postResponseDto -> {

            postResponseDto.

        });



    }
}

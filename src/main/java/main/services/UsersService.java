package main.services;

import main.Repositories.UsersRepository;
import main.dto.respose.ListPostResponseDto;
import org.springframework.stereotype.Service;


@Service
public class UsersService {

    private UsersRepository usersRepository;


    public ListPostResponseDto getAuthor(ListPostResponseDto response) {

        response.getPosts().stream().forEach(postLDCVDto -> {

            postLDCVDto.

        });



    }
}

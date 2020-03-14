package main;
import main.Repositories.PostsRepository;
import main.model.ModerationStatus;
import main.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Main {

    @Autowired
    static PostsRepository postsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}

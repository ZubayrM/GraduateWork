package main;
import main.Repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    @Autowired
    static PostsRepository postsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}

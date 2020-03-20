import junit.framework.TestCase;
import main.Repositories.PostsRepository;
import main.controllers.api.ApiPostController;
import main.model.enums.Mode;
import main.model.enums.ModerationStatus;
import main.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class ApiPostControllerTest extends TestCase {

    @Autowired
    PostsRepository postsRepository;

    ApiPostController apiPostController;

    @Override
    protected void setUp() throws Exception {

//        for (int i = 0; i < 30; i++){
//
//            Posts.PostsBuilder posts = Posts.builder()
//                    .id(i)
//                    .isActive(1)
//                    .moderationId(1)
//                    .moderationStatus(ModerationStatus.NEW)
//                    .userId(i)
//                    .time(LocalDate.now())
//                    .title("текст")
//                    .text("собственно сам текст")
//                    .viewCount((int) Math.random() * 100 );
//
//            System.out.println(posts.build());
//
//            postsRepository.save(posts.build());
//        }

    }




    public void testPostsList(){
        ResponseEntity responseEntity = apiPostController.postsList(0, 10, Mode.BEST);

        assertEquals(200, responseEntity.getStatusCodeValue());


    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

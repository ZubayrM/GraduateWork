package main.Repositories;

import main.model.PostComments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentsRepository extends CrudRepository <PostComments, Integer> {

    List<PostComments> findByPostId(int postId);

}

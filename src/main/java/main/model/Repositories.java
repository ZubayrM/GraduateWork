package main.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositories {
    interface PostsRepository extends CrudRepository<Posts, Integer>{}
    interface CaptchaCodesRepository extends CrudRepository<CaptchaCodes, Integer>{}
    interface GlobalSettingsRepository extends CrudRepository<GlobalSettings, Integer>{}
    interface PostCommentsRepository extends CrudRepository<PostComments, Integer>{}
    interface PostVotesRepository extends CrudRepository<PostVotes, Integer>{}
    interface Tag2PostRepository extends CrudRepository<Tag2Post, Integer>{}
    interface TagsRepository extends CrudRepository<Tags, Integer>{}
    interface UsersRepository extends CrudRepository<Users, Integer>{}
}

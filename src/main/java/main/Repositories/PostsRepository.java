package main.Repositories;

import main.model.Mode;
import main.model.ModerationStatus;
import main.model.Posts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends CrudRepository<Posts,Integer> {


    default List<Posts> findByMode(Mode mode, int isActive, ModerationStatus status){
        if (mode == Mode.RECENT) return postsSortByRecent(isActive, status);
        else if (mode == Mode.POPULAR) return postsSortByPopular(isActive, status);
        else if (mode == Mode.BEST) return postsSortByBest(isActive, status);
        else if (mode == Mode.EARLY) return postsSortByEarly(isActive, status);
        else return null;
    }


    @Query(value = "SELECT * FROM Posts " +
            "WHERE is_active = :active moderation_status = :status " +
            "ORDER BY time DESC",
            nativeQuery = true )
    List<Posts> postsSortByRecent(@Param("active") int isActive, @Param("status") ModerationStatus status);

    @Query(value = "SELECT * FROM Posts p " +
            "JOIN Post_Comments pc ON pc.post_id = p.id " +
            "WHERE p.is_active = :active p.moderation_status = :status " +
            "GROUP BY p.id " +
            "ORDER BY count(pc.id)",
            nativeQuery = true )
    List<Posts> postsSortByPopular(@Param("active") int isActive, @Param("status") ModerationStatus status);

    @Query(value = "SELECT * FROM Posts p" +
            "JOIN Posts_Votes pv ON pv.post_id == p.id " +
            "WHERE p.is_active = :active p.moderation_status = :status " +
            "GROUP BY p.id" +
            "ORDER BY count(pv.Value) DESC",
            nativeQuery = true )
    List<Posts> postsSortByBest(@Param("active") int isActive, @Param("status") ModerationStatus status);

    @Query(value = "SELECT * FROM Posts " +
            "WHERE is_active = :active moderation_status = :status " +
            "ORDER BY time",
            nativeQuery = true )
    List<Posts> postsSortByEarly(@Param("active") int isActive, @Param("status") ModerationStatus status);


}

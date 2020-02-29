package main.MySQL;
import main.model.Posts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class SqlCommands {

    @Autowired
    private static SessionFactory sessionFactory; // ???

    private static Session session = sessionFactory.getCurrentSession();


    public static List getPostsList(String mode){
        List<Posts> list = null;
        String hql = null;

        String hqlRecent = "FROM Posts ORDER BY time DESC" ;
        String hqlPopular  = "FROM Posts " +
                "JOIN Post_Comments pc ON pc.post_id = Posts.id" +
                "GROUP BY Posts.id" +
                "ORDER BY count(pc.id)";
        String hqlBest = "FROM Posts " +
                "join Posts_Votes pv ON pv.post_id == Posts.id " +
                "GROUP BY Posts.id" +
                "ORDER BY count(pv.Value) DESC";
        String hqlEarly  = "FROM Posts ORDER BY time" ;

        String hqlFilter = " WHERE is_active = 1 AND " +
                "WHERE moderation_status = 'ACCEPTED'";

        switch (mode){
            case "recent":  hql = hqlRecent ;break;
            case "popular": hql = hqlPopular ;break;
            case "best": hql = hqlBest ;break;
            case "early": hql = hqlEarly ;break;
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }

        list = session.createQuery(hql + hqlFilter,Posts.class).getResultList();
        return list;
    }

}

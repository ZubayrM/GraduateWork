package main.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;

@Data
@Entity
@Table(name = "post_votes")
public class PostVotes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "post_id", nullable = false)
    private int postId;

    @Column(nullable = false)
    private Calendar time;

    @Column(nullable = false)
    private int value;

}

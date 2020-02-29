package main.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "is_active", nullable = false)
    private int isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status", columnDefinition = "enum", nullable = false)
    private ModerationStatus moderationStatus;

    @Column(name = "moderation_id")
    private int moderationId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(nullable = false)
    private LocalDate time;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(name = "view_count", nullable = false)
    private int viewCount;

//    private List<PostComments> postCommentsList;
//
//    private List<PostVotes> postVotesList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public ModerationStatus getModerationStatus() {
        return moderationStatus;
    }

    public void setModerationStatus(ModerationStatus moderationStatus) {
        this.moderationStatus = moderationStatus;
    }

    public int getModerationId() {
        return moderationId;
    }

    public void setModerationId(int moderationId) {
        this.moderationId = moderationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

//    public List<PostComments> getPostCommentsList() {
//        return postCommentsList;
//    }
//
//    public void setPostCommentsList(List<PostComments> postCommentsList) {
//        this.postCommentsList = postCommentsList;
//    }
//
//    public List<PostVotes> getPostVotesList() {
//        return postVotesList;
//    }
//
//    public void setPostVotesList(List<PostVotes> postVotesList) {
//        this.postVotesList = postVotesList;
//    }
}

package com.yasarplusback.YasarPlusBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private long id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "yasar_user_id"
    )

    private YasarUser user;
    @OneToMany
    @JoinColumn(
            name = "user_comment_id"
    )

    private List<UserComment> userComment;
    @Column
    private String postText;
    @Column(columnDefinition = "TEXT")
    private String postImage;
    @OneToMany
    @JoinColumn(
            name = "user_like_id"
    )

    private List<UserLike> userLike;

    public Post(YasarUser user, String postText, String postImage) {
        this.postText = postText;
        this.postImage = postImage;
        this.user = user;
    }
    public Post(YasarUser user, String postText) {
        this.postText = postText;
        this.user = user;
    }


}

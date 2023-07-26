package com.yasarplusback.YasarPlusBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserComment {
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    private long id;
    @Column
    private String text;
    @ManyToOne
    @JoinColumn(
            name = "yasar_user_id"
    )
    private YasarUser user;
    public UserComment(YasarUser user, String text) {
        this.text = text;
        this.user = user;
    }
}

package com.yasarplusback.YasarPlusBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserLike {
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

    @ManyToOne
    @JoinColumn(
            name = "yasar_user_id"
    )
    private YasarUser user;
    public UserLike(YasarUser user) {
        this.user = user;
    }
}

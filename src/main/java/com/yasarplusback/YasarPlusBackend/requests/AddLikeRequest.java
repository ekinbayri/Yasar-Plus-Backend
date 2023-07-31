package com.yasarplusback.YasarPlusBackend.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddLikeRequest {
    private final long userId;
    private final long postId;
}

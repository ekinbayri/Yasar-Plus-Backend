package com.yasarplusback.YasarPlusBackend.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddPostRequest {
    private final String image;
    private final String text;
    private final long id;
}

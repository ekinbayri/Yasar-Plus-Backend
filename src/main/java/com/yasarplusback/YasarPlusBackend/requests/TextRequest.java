package com.yasarplusback.YasarPlusBackend.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TextRequest {
    private final String text;
    private final long id;
}

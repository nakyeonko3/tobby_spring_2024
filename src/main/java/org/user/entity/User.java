package org.user.entity;

import lombok.*;

@Getter
@RequiredArgsConstructor
@Builder
public class User {
    private final String id;
    private final String name;
    private final String passWord;
}

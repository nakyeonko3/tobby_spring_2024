package org.user.entity;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@RequiredArgsConstructor
public class User {
    private final String id;
    private final String name;
    private final String passWord;

}

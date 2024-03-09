package com.parking.domain.spaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parking.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spaces")
@Getter
@Setter
@NoArgsConstructor
public class Spaces {
    @Id
    private String id;
    private String title;
    private String description;

    @JsonProperty("user_id")
    @DBRef
    private Users user;
}

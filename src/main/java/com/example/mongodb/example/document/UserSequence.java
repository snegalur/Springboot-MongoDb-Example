package com.example.mongodb.example.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userSequence")
@Getter
@Setter
public class UserSequence {

    @Id
    private String id;
    private int seq;
}

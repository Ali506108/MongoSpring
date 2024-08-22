package com.example.MongoSpring.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class PeopleStudent  {

    @Id
    private Integer id;

    @NonNull
    private String Full_Name;

    @NonNull
    private String email;

    @NonNull
    private String Faculty;

    @NonNull
    private int age;
}

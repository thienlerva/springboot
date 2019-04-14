package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogPost {

    String title;
    String author;
    BlogPostType type;
    Integer likes;
}

package com.kazeneko.SimpleBookmark.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bookmarks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name = "url", nullable = false)
    private String url;
    //BAD STYLE
    @Column(name = "tags", nullable = false)
    private List<String> tags;
}

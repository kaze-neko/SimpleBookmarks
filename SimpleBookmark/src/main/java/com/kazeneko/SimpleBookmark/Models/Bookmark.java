package com.kazeneko.SimpleBookmark.Models;

import jakarta.persistence.*;
import lombok.*;

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
}

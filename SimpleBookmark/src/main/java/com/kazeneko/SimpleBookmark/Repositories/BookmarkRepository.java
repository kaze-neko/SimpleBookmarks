package com.kazeneko.SimpleBookmark.Repositories;

import com.kazeneko.SimpleBookmark.Models.Bookmark;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {
    public List<Bookmark> findAll();
}

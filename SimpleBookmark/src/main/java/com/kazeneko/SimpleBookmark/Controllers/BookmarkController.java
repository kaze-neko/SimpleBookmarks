package com.kazeneko.SimpleBookmark.Controllers;

import com.kazeneko.SimpleBookmark.Models.Bookmark;
import com.kazeneko.SimpleBookmark.Repositories.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @GetMapping
    public List<Bookmark> getAll() {
        return bookmarkRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookmarkRepository.deleteById(id);
    }
    @PostMapping()
    public Bookmark create(@RequestBody Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }
}

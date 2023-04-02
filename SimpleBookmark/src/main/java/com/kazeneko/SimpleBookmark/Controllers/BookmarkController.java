package com.kazeneko.SimpleBookmark.Controllers;

import com.kazeneko.SimpleBookmark.Models.Bookmark;
import com.kazeneko.SimpleBookmark.Repositories.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
    @Autowired
    private BookmarkRepository bookmarkRepository;
    @GetMapping()
    public List<Bookmark> getAllByTags(@RequestParam(required = false) Optional<String[]>  tags) {
        if (tags.isEmpty()) return bookmarkRepository.findAll();
        //if there are any transmitted tag
        List<Bookmark>  suitableBookmarks = new ArrayList<>();
        List<Bookmark> bookmarks = bookmarkRepository.findAll();
        for (int i = 0; i < bookmarks.size(); i++) {
            Bookmark bookmark = bookmarks.get(i);
            List<String> allTagsInBookmark = bookmark.getTags();
            if (allTagsInBookmark.containsAll(Arrays.asList(tags.get()))) {
                suitableBookmarks.add(bookmark);
            }
        }
        return suitableBookmarks;
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

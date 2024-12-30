package ecommercespringlabs.springbootlabslab4.web;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemRequestDto;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemResponseDto;
import ecommercespringlabs.springbootlabslab4.mapper.NewsItemMapper;
import ecommercespringlabs.springbootlabslab4.mapper.NewsItemMapperDao;
import ecommercespringlabs.springbootlabslab4.service.NewsItemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/news")
@Validated
@AllArgsConstructor
public class NewsItemController {

    private final NewsItemService newsItemService;
    private final NewsItemMapper newsItemMapper;

    @GetMapping
    public ResponseEntity<List<NewsItemResponseDto>> getAllNewsItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(newsItemMapper.toNewsItemDtoList(newsItemService.findAllNewsItems(page, size)));
    }

    @GetMapping("/by-title/{title}")
    public ResponseEntity<List<NewsItemResponseDto>> getAllNewsItemsByTitle(@PathVariable String title) {
        return ResponseEntity.ok(newsItemMapper.toNewsItemDtoList(newsItemService.findAllNewsItemsByTitle(title)));
    }


    @GetMapping("/{newsId}")
    public ResponseEntity<NewsItem> getNewsItemById(@PathVariable String newsId) {
        return ResponseEntity.ok(newsItemService.findNewsItemById(newsId));
    }

    @PostMapping
    public ResponseEntity<NewsItem> addNewsItem(@RequestBody @Valid NewsItemRequestDto newsItemRequestDto) {
        NewsItem newsItem = newsItemService.addNewsItem(newsItemRequestDto);
        return ResponseEntity.ok(newsItem);
    }

    @DeleteMapping("/{newsId}")
    public ResponseEntity<Void> deleteNewsItem(@PathVariable UUID newsId) {
        newsItemService.deleteNewsItem(newsId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{newsId}")
    public ResponseEntity<NewsItem> updateNewsItem(@RequestBody @Valid NewsItemRequestDto newsItemRequestDto, @PathVariable String newsId) {
        NewsItem newsItem = newsItemService.updateNewsItem(newsItemRequestDto, newsId);
        return ResponseEntity.ok(newsItem);
    }
}

package ecommercespringlabs.springbootlabslab4.dao;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemRequestDto;

import java.util.List;
import java.util.UUID;

public interface NewsItemDao {
    NewsItem findById(UUID id);

    List<NewsItem> findAll(int size, int page);

    List<NewsItem> findByTitle(String title);

    void deleteById(UUID id);

    NewsItem save(NewsItemRequestDto newsItemRequestDto);

    NewsItem update(UUID id, NewsItemRequestDto newsItemRequestDto);
}

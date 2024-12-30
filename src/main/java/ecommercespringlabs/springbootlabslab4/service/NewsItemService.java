package ecommercespringlabs.springbootlabslab4.service;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemRequestDto;

import java.util.List;
import java.util.UUID;

public interface NewsItemService {
    List<NewsItem> findAllNewsItems(int page, int size);

    List<NewsItem> findAllNewsItemsByTitle(String title);

    NewsItem addNewsItem(NewsItemRequestDto newsItem);

    NewsItem updateNewsItem(NewsItemRequestDto newsItem, String id);

    void deleteNewsItem(UUID newsItemId);

    NewsItem findNewsItemById(String id);
}

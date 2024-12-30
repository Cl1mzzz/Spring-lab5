package ecommercespringlabs.springbootlabslab4.mapper;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemResponseDto;

import java.util.List;

public interface NewsItemMapper {
    NewsItemResponseDto toNewsItemDto(NewsItem newsItem);

    List<NewsItemResponseDto> toNewsItemDtoList(List<NewsItem> itemLists);
}

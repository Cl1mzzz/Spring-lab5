package ecommercespringlabs.springbootlabslab4.mapper;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsItemMapperImpl implements NewsItemMapper {
    @Override
    public NewsItemResponseDto toNewsItemDto(NewsItem newsItem) {
        return NewsItemResponseDto.builder()
                .id(newsItem.getId())
                .title(newsItem.getTitle())
                .description(newsItem.getDescription())
                .category(newsItem.getCategory())
                .build();
    }

    @Override
    public List<NewsItemResponseDto> toNewsItemDtoList(List<NewsItem> itemLists) {
        return itemLists.stream().map(this::toNewsItemDto).collect(Collectors.toList());
    }
}

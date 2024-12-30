package ecommercespringlabs.springbootlabslab4.dto.news;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class NewsItemResponseDto {
    UUID id;
    String title;
    String description;
    String category;
}

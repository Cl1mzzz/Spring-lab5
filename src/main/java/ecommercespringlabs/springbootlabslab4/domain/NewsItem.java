package ecommercespringlabs.springbootlabslab4.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class NewsItem{
    UUID id;
    String title;
    String description;
    String category;
}

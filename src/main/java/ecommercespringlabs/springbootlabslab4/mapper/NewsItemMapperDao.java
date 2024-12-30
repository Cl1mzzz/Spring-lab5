package ecommercespringlabs.springbootlabslab4.mapper;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class NewsItemMapperDao implements RowMapper<NewsItem> {
    @Override
    public NewsItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return NewsItem.builder()
                .id(UUID.fromString(rs.getString("id")))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .category(rs.getString("category"))
                .build();
    }
}

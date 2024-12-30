package ecommercespringlabs.springbootlabslab4.dao;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemRequestDto;
import ecommercespringlabs.springbootlabslab4.mapper.NewsItemMapperDao;
import ecommercespringlabs.springbootlabslab4.service.exception.NewsItemNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class NewsItemDaoImpl implements NewsItemDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<NewsItem> findAll(int size, int page) {
        String sql = "SELECT * FROM news";
        return jdbcTemplate.query(sql, new NewsItemMapperDao());
    }

    @Override
    public List<NewsItem> findByTitle(String title) {
        String sql = "SELECT * FROM news WHERE LOWER(title) LIKE ?";
        return jdbcTemplate.query(sql, new NewsItemMapperDao(), "%" + title.toLowerCase() + "%");
    }

    @Override
    public void deleteById(UUID id) {
        String sql = "DELETE FROM news WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected == 0) {
            throw new NewsItemNotFoundException(id.toString());
        }
    }

    @Override
    public NewsItem findById(UUID id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new NewsItemMapperDao(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new NewsItemNotFoundException(id.toString());
        }
    }

    @Override
    public NewsItem save(NewsItemRequestDto newsItemRequestDto) {
        String sql = "INSERT INTO news (id, title, description, category) VALUES (?, ?, ?, ?) RETURNING id";
        UUID id = UUID.randomUUID();
        UUID returnedId = jdbcTemplate.queryForObject(sql, UUID.class,
                id,
                newsItemRequestDto.getTitle(),
                newsItemRequestDto.getDescription(),
                newsItemRequestDto.getCategory());

        if (returnedId == null) {
            throw new RuntimeException("Failed to save the news item.");
        }

        return findById(returnedId);
    }


    @Override
    public NewsItem update(UUID id, NewsItemRequestDto newsItemRequestDto) {
        String sql = "UPDATE news SET title = ?, description = ?, category = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql,
                newsItemRequestDto.getTitle(),
                newsItemRequestDto.getDescription(),
                newsItemRequestDto.getCategory(),
                id
        );
        if (rowsAffected == 0) {
            throw new NewsItemNotFoundException(id.toString());
        }

        return findById(id);
    }
}
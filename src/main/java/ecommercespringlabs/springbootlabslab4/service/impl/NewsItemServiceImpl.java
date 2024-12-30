package ecommercespringlabs.springbootlabslab4.service.impl;

import ecommercespringlabs.springbootlabslab4.dao.NewsItemDao;
import ecommercespringlabs.springbootlabslab4.dao.NewsItemDaoImpl;
import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemRequestDto;
import ecommercespringlabs.springbootlabslab4.service.NewsItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NewsItemServiceImpl implements NewsItemService {

    private final NewsItemDaoImpl newsItemDao;

    @Override
    @Transactional(readOnly = true)
    public List<NewsItem> findAllNewsItems(int page, int size) {
        return newsItemDao.findAll(page, size);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewsItem> findAllNewsItemsByTitle(String title) {
        return newsItemDao.findByTitle(title);
    }

    @Override
    @Transactional(readOnly = true)
    public NewsItem findNewsItemById(String id) {
        return newsItemDao.findById(UUID.fromString(id));
    }

    @Override
    @Transactional
    public NewsItem addNewsItem(NewsItemRequestDto newsItemRequestDto) {
        try {
            return newsItemDao.save(newsItemRequestDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    @Transactional
    public NewsItem updateNewsItem(NewsItemRequestDto newsItemRequestDto, String id) {
        try {
            return newsItemDao.update(UUID.fromString(id), newsItemRequestDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    @Transactional
    public void deleteNewsItem (UUID id){
        try {
            newsItemDao.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
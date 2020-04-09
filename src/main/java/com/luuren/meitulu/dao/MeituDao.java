package com.luuren.meitulu.dao;

import com.luuren.meitulu.entity.MeituEntity;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MeituDao {

    @Resource
    private MongoTemplate mongoTemplate;

    public PageImpl<MeituEntity> findMeituByName(String name, int pageIndex, int pageSize) {
        Query query = new Query(Criteria.where("model.model_title").is(name));
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        query.with(pageable);
        List<MeituEntity> meituEntities = mongoTemplate.find(query, MeituEntity.class);
        return (PageImpl<MeituEntity>) PageableExecutionUtils.getPage(meituEntities, pageable, () -> 0);
    }

    public PageImpl<MeituEntity> findPageMeitus(int pageIndex, int pageSize) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        query.with(pageable);
        List<MeituEntity> meituEntities = mongoTemplate.find(query, MeituEntity.class);
        return (PageImpl<MeituEntity>) PageableExecutionUtils.getPage(meituEntities, pageable, () -> 0);
    }

    public PageImpl<MeituEntity> findPageMeitusFromTag(String tag, int pageIndex, int pageSize) {
        Query query = new Query(Criteria.where("tags.tag_title").in(tag));
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        query.with(pageable);
        List<MeituEntity> meituEntities = mongoTemplate.find(query, MeituEntity.class);
        return (PageImpl<MeituEntity>) PageableExecutionUtils.getPage(meituEntities, pageable, () -> 0);
    }
}

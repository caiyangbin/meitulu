package com.luuren.meitulu;

import com.luuren.meitulu.dao.MeituDao;
import com.luuren.meitulu.entity.MeituEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@SpringBootTest
@Component
class MeituluApplicationTests {

    @Resource
    private MeituDao dao;

    @Test
    void contextLoads() {
//        List<MeituEntity> meituByName = dao.findMeituByName("王雨纯");
//        for (MeituEntity entity : meituByName) {
//            System.out.println(entity.getTitle());
//        }
        PageImpl<MeituEntity> entities = dao.findPageMeitusFromTag("美臀", 0, 20);
        for (MeituEntity entity : entities) {
            System.out.println(entity.getTags());
        }
    }
}

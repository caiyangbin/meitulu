package com.luuren.meitulu.controller;

import com.luuren.meitulu.base.BaseController;
import com.luuren.meitulu.dao.MeituDao;
import com.luuren.meitulu.entity.MeituEntity;
import com.luuren.meitulu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Component
@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {

    @Resource
    private MeituDao dao;

    @RequestMapping("/findMeituByName")
    public R findMeituByName(String name, Integer pageIndex, Integer pageSize) {
        PageImpl<MeituEntity> meituByName = dao.findMeituByName(name, pageIndex, pageSize);
        if (meituByName == null) {
            return R.error(301, "查询无数据");
        }
        return R.ok().put("data", meituByName);
    }

    @RequestMapping("/findPageMeitusFromTag")
    public R findPageMeitusFromTag(String tag, Integer pageIndex, Integer pageSize) {
        PageImpl<MeituEntity> pageMeitusFromTag = dao.findPageMeitusFromTag(tag, pageIndex, pageSize);
        if (pageMeitusFromTag == null) {
            return R.error(301, "查询无数据");
        }
        return R.ok().put("data", pageMeitusFromTag);
    }

    @RequestMapping("/findAllPageMeitus")
    public R findAllPageMeitus(Integer pageIndex, Integer pageSize) {
        PageImpl<MeituEntity> pageMeitus = dao.findPageMeitus(pageIndex, pageSize);
        if (pageMeitus == null) {
            return R.error(301, "查询无数据");
        }
        return R.ok().put("data", pageMeitus);
    }
}

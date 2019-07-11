package com.iflytek.tms.service.impl;

import com.iflytek.tms.mapper.CoursePlanDao;
import com.iflytek.tms.pojo.CoursePlan;
import com.iflytek.tms.pojo.CoursePlanVo;
import com.iflytek.tms.service.CoursePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/4 - 6:15
 */
@Service
public class CoursePlanServiceImpl implements CoursePlanService {
    @Autowired
    private CoursePlanDao coursePlanDao;

    @Override
    @Transactional
    public void addCoursePlan(CoursePlan coursePlan) {
        coursePlanDao.addCoursePlan(coursePlan);
    }

    @Override
    public List<CoursePlanVo> getCoursePlanByType(Map map) {
        return coursePlanDao.getCoursePlanByType(map);
    }

    @Override
    @Transactional
    public void deleteCoursePlan(Integer id) {
        coursePlanDao.deleteCoursePlan(id);
    }


}

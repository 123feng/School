package com.iflytek.tms.service;

import com.iflytek.tms.pojo.CoursePlan;
import com.iflytek.tms.pojo.CoursePlanVo;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/4 - 6:15
 */
public interface CoursePlanService {
    public  void  addCoursePlan(CoursePlan coursePlan);
    public List<CoursePlanVo> getCoursePlanByType(Map map);
    public void  deleteCoursePlan(Integer id);
}

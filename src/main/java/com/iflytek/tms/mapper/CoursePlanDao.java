package com.iflytek.tms.mapper;

import com.iflytek.tms.pojo.CoursePlan;
import com.iflytek.tms.pojo.CoursePlanVo;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/4 - 6:14
 */
public interface CoursePlanDao {
    /**
     * 新增用户
     * @param coursePlan
     */
    public  void  addCoursePlan(CoursePlan coursePlan);

    /**
     * 根据条件查询排课
     * @param map  id  乐器id
     * @return
     */
    public List<CoursePlanVo> getCoursePlanByType(Map map);
    public void  deleteCoursePlan(Integer id);
}

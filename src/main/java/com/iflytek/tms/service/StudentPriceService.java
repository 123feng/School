package com.iflytek.tms.service;



import com.iflytek.tms.pojo.StudentPrice;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/2 - 12:11
 */
public interface StudentPriceService {
    public List<StudentPrice> getPageAll(Map map);
    public  int getAllStudentPriceCount();
    public int getStudentPriceByNameAndTypeCount(Map map);
    public  List<StudentPrice> getStudentPriceByNameAndType(Map map);
    public  void  addStudentPrice(StudentPrice studentPrice);
    public  void updateLeftclass(StudentPrice studentPrice);
    public  StudentPrice getStudentPriceById(Integer id);
}

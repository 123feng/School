package com.iflytek.tms.service.impl;


import com.iflytek.tms.mapper.StudentPriceDao;
import com.iflytek.tms.pojo.StudentPrice;
import com.iflytek.tms.service.StudentPriceService;
import com.iflytek.tms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/2 - 12:11
 */
@Service
public class StudentPriceServiceImpl implements StudentPriceService {
    @Autowired
    private StudentPriceDao studentPriceDao;
    @Override
    public List<StudentPrice> getPageAll(Map map) {
        return studentPriceDao.getPageAll(map);
    }

    @Override
    public int getAllStudentPriceCount() {
        return studentPriceDao.getAllStudentPriceCount();
    }

    @Override
    public int getStudentPriceByNameAndTypeCount(Map map) {
        return studentPriceDao.getStudentPriceByNameAndTypeCount(map);
    }

    @Override
    public List<StudentPrice> getStudentPriceByNameAndType(Map map) {
        return studentPriceDao.getStudentPriceByNameAndType(map);
    }

    @Override
    @Transactional
    public void addStudentPrice(StudentPrice studentPrice) {
        studentPriceDao.addStudentPrice(studentPrice);
    }

    @Override
    @Transactional
    public void updateLeftclass(StudentPrice studentPrice) {
        studentPriceDao.updateLeftclass(studentPrice);
    }

    @Override
    public StudentPrice getStudentPriceById(Integer id) {
        return studentPriceDao.getStudentPriceById(id);
    }
}

package com.iflytek.tms.service.impl;

import com.iflytek.tms.mapper.MusicTypeDao;
import com.iflytek.tms.pojo.MusicType;
import com.iflytek.tms.service.MusicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/4/30 - 15:39
 */
@Service
public class MusicTypeServiceImpl implements MusicTypeService {
    @Autowired
     private MusicTypeDao  musicTypeDao;

    @Override
    public List<MusicType> getAllMusicType() {
        return musicTypeDao.getAllMusicType();
    }

    @Override
    public MusicType getMusicTypeById(int id) {
        return musicTypeDao.getMusicTypeById(id);
    }
}

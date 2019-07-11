package com.iflytek.tms.service;

import com.iflytek.tms.pojo.MusicType;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/4/30 - 15:33
 */
public interface MusicTypeService {
    public List<MusicType> getAllMusicType();
    public MusicType getMusicTypeById(int id);
}

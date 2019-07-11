package com.iflytek.tms.mapper;

import com.iflytek.tms.pojo.MusicType;

import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/4/30 - 15:34
 */
public interface MusicTypeDao {
    public List<MusicType> getAllMusicType();
    public MusicType getMusicTypeById(int id);
}

package com.iflytek.tms.mapper;

import com.iflytek.tms.pojo.Menu;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/6 - 16:34
 */
public interface MenuDao {
    public List<Menu> getAllMenu(Map map);
}

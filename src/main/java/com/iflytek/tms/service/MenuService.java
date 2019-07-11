package com.iflytek.tms.service;

import com.iflytek.tms.pojo.Menu;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/6 - 19:05
 */
public interface MenuService {
    public List<Menu> getAllMenu(Integer auth, Integer parentid);

}

package com.iflytek.tms.service.impl;

import com.iflytek.tms.mapper.MenuDao;
import com.iflytek.tms.pojo.Menu;
import com.iflytek.tms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/5/6 - 19:06
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> getAllMenu(Integer auth, Integer parentid) {
        Map map=new HashMap();
        map.put("auth",auth);
        map.put("parentid",parentid);
        return menuDao.getAllMenu(map);
    }
}

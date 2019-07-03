package com.djl.ssh.daily.service.impl;

import com.djl.ssh.daily.dao.DailyDao;
import com.djl.ssh.daily.dto.DailyDto;
import com.djl.ssh.daily.entity.Daily;
import com.djl.ssh.daily.service.DailyService;
import com.djl.ssh.daily.vo.PageBean;
import com.djl.ssh.daily.vo.R;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * @author DJL
 * @create 2019-07-03 11:14
 * @desc ${DESCRIPTION}
 **/
@Service
public class DailyServiceImpl implements DailyService {

    @Autowired
    private DailyDao dailyDao;

    @Override
    public R save(DailyDto dailyDto, String ip) throws InvocationTargetException, IllegalAccessException {
        Daily daily = new Daily();
        BeanUtils.copyProperties(dailyDto,daily);
        daily.setIpAddr(ip);
        int ret = dailyDao.save(daily);
        return R.exec(ret > 0, daily);
    }

    @Override
    public PageBean<Daily> queryPage() {
        return PageBean.setOK(dailyDao.selectCount(), dailyDao.page());
    }

    @Override
    public PageBean<Daily> queryPageSelf() {
        return PageBean.setOK(dailyDao.selectCount(), dailyDao.page());
    }
}

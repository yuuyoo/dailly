package com.djl.ssh.daily.service;

import com.djl.ssh.daily.dto.DailyDto;
import com.djl.ssh.daily.entity.Daily;
import com.djl.ssh.daily.vo.PageBean;
import com.djl.ssh.daily.vo.R;

import java.lang.reflect.InvocationTargetException;

/**
 * @author DJL
 * @create 2019-07-03 11:13
 * @desc ${DESCRIPTION}
 **/
public interface DailyService {

    R save(DailyDto dailyDto, String ip) throws InvocationTargetException, IllegalAccessException;

    PageBean<Daily> queryPage();

    PageBean<Daily> queryPageSelf();
}

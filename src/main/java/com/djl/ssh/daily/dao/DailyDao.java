package com.djl.ssh.daily.dao;

import com.djl.ssh.daily.entity.Daily;

import java.util.List;

/**
 * @author DJL
 * @create 2019-07-03 11:02
 * @desc ${DESCRIPTION}
 **/
public interface DailyDao {

    /**
     * 保存日报
     * @param daily
     * @return
     */
    int save(Daily daily);

    /**
     * 分页查询所有人的日报
     * @return
     */
    List<Daily> page();

    /**
     * 分页查询自己的日报
     * @return
     */
    List<Daily> pageSelf();

    /**
     * 获取日报总条数
     * @return
     */
    int selectCount();


}

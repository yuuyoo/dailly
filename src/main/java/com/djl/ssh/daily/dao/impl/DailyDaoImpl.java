package com.djl.ssh.daily.dao.impl;

import com.djl.ssh.daily.dao.DailyDao;
import com.djl.ssh.daily.entity.Daily;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * @author DJL
 * @create 2019-07-03 11:08
 * @desc 数据操作实现类
 **/
@Repository
public class DailyDaoImpl implements DailyDao {

    // 基于模板引擎 实现Hibernate操作的封装
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public int save(Daily daily) {
        return hibernateTemplate.save(daily) != null ? 1 : 0;
    }

    @Override
    public List<Daily> page() {
        // 动态条件拼接对象
        DetachedCriteria dc = DetachedCriteria.forClass(Daily.class);
        // 创建日期降序
        dc.addOrder(Order.desc("ctime"));
        return (List<Daily>) hibernateTemplate.findByCriteria(dc);
    }

    @Override
    public List<Daily> pageSelf() {
        // 动态条件拼接对象
        DetachedCriteria dc = DetachedCriteria.forClass(Daily.class);
        // 创建日期降序
        dc.addOrder(Order.desc("ctime"));
        return (List<Daily>) hibernateTemplate.findByCriteria(dc);
    }

    @Override
    public int selectCount() {
        /*
         hibernate提供的hql语句
         Query<Daily> query=hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from Daily",Daily.class);
          */

        // hibernate 提供操作原生sql语句
        NativeQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery("select count(*) from t_daily");
        BigInteger result = (BigInteger) query.getSingleResult();
        return result != null ? result.intValue() : 0;
    }
}

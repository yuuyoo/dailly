package com.djl.ssh.daily.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author DJL
 * @create 2019-07-03 10:52
 * @desc ${DESCRIPTION}
 **/
@Entity
@Table(name = "t_daily") // 标记数据库表
@Data
public class Daily {
    @Id // 标记位主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键增长策略 自增
    private Integer id;

    // 姓名
    @Column(length = 20) // 设置数据库表的字段和类中属性的关系
    private String name;

    // 部门
    @Column(length = 20)
    private String deptName;

    // 日报日期
    private Date dayDate;

    // 日报添加日期
    private Date ctime;

    // 添加日报的IP地址
    @Column(length = 20)
    private String ipAddr;

    // 日报内容
    @Column(length = 200)
    private String content;
}

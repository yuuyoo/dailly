package com.djl.ssh.daily.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author DJL
 * @create 2019-07-03 11:12
 * @desc 数据传输对象
 **/
@Data
public class DailyDto {

    // 姓名
    private String name;

    // 部门名称
    private String deptName;

    // 日报日期
    private Date dayDate;

    // 日报内容
    private String content;
}

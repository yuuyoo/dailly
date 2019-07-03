package com.djl.ssh.daily.action;

import com.djl.ssh.daily.dto.DailyDto;
import com.djl.ssh.daily.entity.Daily;
import com.djl.ssh.daily.service.DailyService;
import com.djl.ssh.daily.vo.PageBean;
import com.djl.ssh.daily.vo.R;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * @author DJL
 * @create 2019-07-03 11:13
 * @desc 日报控制器类
 **/
@Controller
public class DailyAction implements ModelDriven<DailyDto> {

    @Autowired
    private DailyService dailyService;

    // 前端与后台交换的传输对象
    private DailyDto dailyDto;

    // 后端返回前台的Json对象
    private R r;

    private PageBean<Daily> pageBean;

    // 构造方法,创建dailyDto对象
    public DailyAction() {
        this.dailyDto = new DailyDto();
    }

    public DailyDto getDailyDto() {
        return dailyDto;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public PageBean<Daily> getPageBean() {
        return pageBean;
    }

    @Override
    public DailyDto getModel() {
        return dailyDto;
    }

    /**
     * 新增日报
     * @return
     */
    public String save() {
        // 获取请求对象
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            dailyService.save(dailyDto, request.getRemoteAddr());
            return Action.SUCCESS;

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return Action.ERROR;
    }

    /**
     * 分页查询日报信息
     * @return
     */
    public String page() {
        pageBean = dailyService.queryPage();
        return Action.SUCCESS;
    }

}

package com.springboot.demo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.springboot.demo.entity.Application;
import com.springboot.demo.mapper.ApplicationMapper;
import com.springboot.demo.service.IApplicationService;
import com.springboot.demo.util.UUIDTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create By SINYA
 * Create Date 2019/3/1
 * Description:
 */
@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Resource
    private ApplicationMapper applicationMapper;

    /**
     * 获取部门下所有记录
     * @param pageSize
     * @param pageNum
     * @param application
     * @return
     */
    @Override
    public List<Application> getAllFormByDept(Integer pageSize, Integer pageNum, Application application) {
        //分页
        PageHelper.startPage(pageSize,pageNum);
        //
        List<Application> result = applicationMapper.getAllFormByDept(application);
        return result;
    }

    @Override
    public List<Application> getFormInfoByFormId(Integer pageSize, Integer pageNum,Application application) {
        PageHelper.startPage(pageSize,pageNum);
        List<Application> result = applicationMapper.getFormInfoByFormId(application);
        return result;
    }

    /**
     * 获取个人所有申请记录
     * @param application
     * @return
     */
    @Override
    public List<Application> getAllFormByUser(Application application) {
        List<Application> result = applicationMapper.getAllFormByUser(application);
        return result;
    }

    /**
     * 修改表单审核状态
     * @param application
     */
    @Override
    public void modifyFormStatusByFormId(Application application) {

        applicationMapper.modifyFormStatusByFormId(application);

    }

    /**
     * 修改表单信息
     * @param application
     */
    @Override
    public void modifyFormInfoByFormId(Application application) {

        applicationMapper.modifyFormInfoByFormId(application);

    }

    /**
     * 新增表单
     * @param application
     */
    @Override
    public void createAppForm(Application application) {
        //表单ID自动生成
        application.setFormId(UUIDTool.getUUID());
        //用户、部门ID直接获取当前用户的数据
//        session.getuserId();
//        session.getgroupId();
        //内容校验框架

        //执行新增操作
        applicationMapper.createAppForm(application);

    }

    /**
     * 获取所有场地
     * @param application
     * @return
     */
    @Override
    public List<Application> getPlaceList(Application application) {
        List<Application> result = applicationMapper.getPlaceList(application);
        return result;
    }
}

package com.springboot.demo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.springboot.demo.entity.Place;
import com.springboot.demo.mapper.PlaceMapper;
import com.springboot.demo.service.IPlaceService;

import com.springboot.demo.util.SnowFlake;
import com.springboot.demo.util.TimeHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create By SINYA
 * Description:
 */
@Service
public class PlaceServiceImpl implements IPlaceService {

    @Resource
    private PlaceMapper placeMapper;


    private SnowFlake snowFlake = new SnowFlake(1,9);


    /**
     * 获取场地清单
     * @param pageNum
     * @param pageSize
     * @param place
     * @return
     */
    @Override
    public List<Place> getPlaceListByPage(Integer pageNum, Integer pageSize, Place place) {
        //分页
        PageHelper.startPage(pageNum,pageSize);

        List<Place> result = placeMapper.getPlaceListByPage(place);
        return result;
    }

    /**
     * 新增场地
     * @param place
     * @return
     */
    @Override
    public String createPlace(Place place) {
        //生成ID
        place.setPlaceId(String.valueOf(snowFlake.nextId()));

        //设置更新时间
        place.setCreateTime(TimeHelper.getNowTime());
        //执行
        placeMapper.createPlace(place);
        //返回
        return "SUCCESS";
    }

    /**
     * 修改资源信息
     * @param place
     * @return
     */
    @Override
    public String modifyPlace(Place place) {
        //设置更新时间
        place.setUpdateTime(TimeHelper.getNowTime());
        //执行
        placeMapper.modifyPlace(place);
        //返回
        return "SUCCESS";
    }

    /**
     * 逻辑删除资源
     * @param place
     * @return
     */
    @Override
    public String deletePlace(Place place) {
        //设置更新时间
        place.setUpdateTime(TimeHelper.getNowTime());
        //执行
        placeMapper.deletePlace(place);
        //返回
        return "SUCCESS";
    }

}

package com.bluemountain.modules.good.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import com.bluemountain.modules.good.entity.ChannelEntity;
import com.bluemountain.modules.good.service.ChannelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 频道
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
@RestController
@RequestMapping("good/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("good:channel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = channelService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/getChannelList")
    @RequiresPermissions("good:channel:list")
    public R getChannelList(){
    	ChannelEntity channelEntity = new ChannelEntity();
    	EntityWrapper< ChannelEntity> ew = new EntityWrapper< ChannelEntity>();
    	ew.orderBy("sort", true);
        List page = channelService.selectList(ew);

        return R.ok().put("data", page);
    }

    

    /**
     * 信息
     */
    @RequestMapping("/info/{channelId}")
    @RequiresPermissions("good:channel:info")
    public R info(@PathVariable("channelId") Long channelId){
        ChannelEntity channel = channelService.selectById(channelId);

        return R.ok().put("channel", channel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("good:channel:save")
    public R save(@RequestBody ChannelEntity channel){
    	ValidatorUtils.validateEntity(channel);
        channelService.insert(channel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("good:channel:update")
    public R update(@RequestBody ChannelEntity channel){
        ValidatorUtils.validateEntity(channel);
        channelService.updateAllColumnById(channel);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("good:channel:delete")
    public R delete(@RequestBody Long[] channelIds){
        channelService.deleteBatchIds(Arrays.asList(channelIds));

        return R.ok();
    }

}

package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.GoodSpecValueEntity;


import java.util.Map;

/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-23 12:01:16
 */
public interface GoodSpecValueService extends IService<GoodSpecValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


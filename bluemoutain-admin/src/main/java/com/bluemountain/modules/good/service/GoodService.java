package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.GoodEntity;
import com.bluemountain.modules.good.entity.view.GoodView;
import com.bluemountain.modules.good.entity.vo.GoodVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 09:01:38
 */
public interface GoodService extends IService<GoodEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodVO> selectListVO(Wrapper<GoodEntity> wrapper);
   	
   	GoodVO selectVO(@Param("ew") Wrapper<GoodEntity> wrapper);
   	
   	List<GoodView> selectListView(Wrapper<GoodEntity> wrapper);
   	
   	GoodView selectView(@Param("ew") Wrapper<GoodEntity> wrapper);
   	
    Page<GoodView> queryPage(Map<String, Object> params, Wrapper<GoodEntity> wrapper);

	//PageUtils queryGoodPage(Map<String, Object> params,@Param("ew") Wrapper<GoodEntity> wrapper);

}


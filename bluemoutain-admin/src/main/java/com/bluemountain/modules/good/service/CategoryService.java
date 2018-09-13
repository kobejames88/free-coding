package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.CategoryEntity;
import com.bluemountain.modules.good.entity.view.CategoryView;
import com.bluemountain.modules.good.entity.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 分类表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CategoryVO> selectListVO(Wrapper<CategoryEntity> wrapper);
   	
   	CategoryVO selectVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
   	
	List<CategoryView> selectListView(Wrapper<CategoryEntity> wrapper);
   	
   	CategoryView selectView(@Param("ew") Wrapper<CategoryEntity> wrapper);
}


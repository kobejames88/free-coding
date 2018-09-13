package com.bluemountain.modules.adverts.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.adverts.dao.AdvertsDao;
import com.bluemountain.modules.adverts.entity.AdvertsEntity;
import com.bluemountain.modules.adverts.entity.view.AdvertsView;
import com.bluemountain.modules.adverts.entity.vo.AdvertsVO;
import com.bluemountain.modules.adverts.service.AdvertsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("advertsService")
public class AdvertsServiceImpl extends ServiceImpl<AdvertsDao, AdvertsEntity> implements AdvertsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AdvertsEntity> page = this.selectPage(
                new Query<AdvertsEntity>(params).getPage(),
                new EntityWrapper<AdvertsEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AdvertsEntity> wrapper) {
		  Page<AdvertsView> page =new Query<AdvertsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<AdvertsVO> selectListVO(Wrapper<AdvertsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AdvertsVO selectVO( Wrapper<AdvertsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AdvertsView> selectListView(Wrapper<AdvertsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AdvertsView selectView(Wrapper<AdvertsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

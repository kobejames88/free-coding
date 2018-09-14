package com.bluemountain.modules.pc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.pc.dao.StudentDao;
import com.bluemountain.modules.pc.entity.StudentEntity;
import com.bluemountain.modules.pc.entity.view.StudentView;
import com.bluemountain.modules.pc.entity.vo.StudentVO;
import com.bluemountain.modules.pc.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StudentEntity> page = this.selectPage(
                new Query<StudentEntity>(params).getPage(),
                new EntityWrapper<StudentEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<StudentEntity> wrapper) {
		  Page<StudentView> page =new Query<StudentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<StudentVO> selectListVO(Wrapper<StudentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public StudentVO selectVO( Wrapper<StudentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<StudentView> selectListView(Wrapper<StudentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public StudentView selectView(Wrapper<StudentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

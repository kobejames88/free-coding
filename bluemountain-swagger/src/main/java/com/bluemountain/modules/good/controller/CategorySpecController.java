package com.bluemountain.modules.good.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import com.bluemountain.modules.good.entity.CategorySpecEntity;
import com.bluemountain.modules.good.entity.view.CategorySpecSearch;
import com.bluemountain.modules.good.service.CategorySpecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-23 10:29:33
 */
@RestController
@RequestMapping("categorySpec")
@Api(tags="分类规格接口")
public class CategorySpecController {
    @Autowired
    private CategorySpecService categorySpecService;
 
	
    /**
     * 查询
     */
    @GetMapping("/goodspec/search")
    @ApiOperation("查询")
    public R search(CategorySpecSearch categorySpecSearch){
        EntityWrapper<CategorySpecEntity> ew = new EntityWrapper<CategorySpecEntity>();
		CategorySpecEntity goodSpec = new CategorySpecEntity( categorySpecSearch);
		ew.setEntity(goodSpec);
		categorySpecService.selectList(ew);
		return R.ok("查询成功").put("data", categorySpecService.selectList(ew));
    }

	

    /**
     * 信息
     */
    @GetMapping("/goodspec/info/{id}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("id") Integer id){
        CategorySpecEntity goodSpec = categorySpecService.selectById(id);

        return R.ok().put("goodSpec", goodSpec);
    }

    /**
     * 保存
     */
    @PostMapping("/goodspec/save/json")
    @ApiOperation("添加数据")
    public R saveJson(@RequestBody CategorySpecEntity goodSpec){
    	ValidatorUtils.validateEntity(goodSpec);
        categorySpecService.insert(goodSpec);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/goodspec/save/form")
    @ApiOperation("添加数据 （参数：表单格式）")
    public R saveForm(CategorySpecEntity goodSpec){
    	ValidatorUtils.validateEntity(goodSpec);
        categorySpecService.insert(goodSpec);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/goodspec/update/json")
    @ApiOperation("修改数据（参数：json格式）")
    public R updateJson(@RequestBody CategorySpecEntity goodSpec){
        ValidatorUtils.validateEntity(goodSpec);
        categorySpecService.updateAllColumnById(goodSpec);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/goodspec/update/form")
    @ApiOperation("修改数据（参数：表单格式）")
    public R updateForm(CategorySpecEntity goodSpec){
        ValidatorUtils.validateEntity(goodSpec);
        categorySpecService.updateAllColumnById(goodSpec);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/goodspec/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Integer[] ids){
        categorySpecService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 根据类别id查询该类别下所有的规格
     */
    @GetMapping("/getSpecByCategoryId")
    @ApiOperation("类别id获取分类规格列表")
    public R getSpecByCategoryId(Integer categoryId){
        EntityWrapper<CategorySpecEntity> entityWrapper=new EntityWrapper<CategorySpecEntity>();
        Wrapper wrapper=entityWrapper.eq("category_id",categoryId);
        List<CategorySpecEntity> list=categorySpecService.selectList(wrapper);
        return R.ok().put("data",list);
    }



}

package com.bluemountain.modules.good.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.bluemountain.common.utils.R;
import com.bluemountain.modules.good.entity.CategorySpecEntity;
import com.bluemountain.modules.good.entity.GoodSpecNameValueEntity;
import com.bluemountain.modules.good.entity.GoodSpecValueEntity;
import com.bluemountain.modules.good.service.CategorySpecService;
import com.bluemountain.modules.good.service.GoodSpecValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-23 12:01:16
 */
@RestController
@RequestMapping("goodspecvalue")
@Api(tags="商品规格值接口")
public class GoodSpecValueController {
    @Autowired
    private GoodSpecValueService goodSpecValueService;
    @Autowired
    private CategorySpecService categorySpecService;
 


    /**
     * 根据商品id查询该商品规格
     */
    @GetMapping("/getSpecByGoodId")
    @ApiOperation("商品id获取规格值列表")
    public  R getSpecBygood(Integer goodId ){
        EntityWrapper<GoodSpecValueEntity> entityWrapper=new EntityWrapper<GoodSpecValueEntity>();
        Wrapper wrapper=entityWrapper.eq("good_id",goodId);
        List<GoodSpecValueEntity>  list=goodSpecValueService.selectList(wrapper);
        return R.ok().put("goodSpecValueList",list);
    }

    /**
     * 根据商品id获取商品规格名称+值列表
     */
    @GetMapping("/getSpecNameValueListByGoodId")
    @ApiOperation("商品规格名值列表")
    public R getSpecValueListByGoodId(String goodId){
        EntityWrapper<GoodSpecValueEntity> entityWrapper=new EntityWrapper<GoodSpecValueEntity>();
        Wrapper wrapper=entityWrapper.eq("good_id",goodId);
        List<GoodSpecValueEntity>  list=goodSpecValueService.selectList(wrapper);
        Iterator it=list.iterator();
        List<GoodSpecNameValueEntity> resultList=new ArrayList<GoodSpecNameValueEntity>();
        Set categorySpecIdSet=new HashSet();
        while(it.hasNext()){
            GoodSpecValueEntity goodSpecValueEntity=(GoodSpecValueEntity) it.next();
            categorySpecIdSet.add(goodSpecValueEntity.getCategorySpecId());
        }
        Iterator categorySpecIdIterator=categorySpecIdSet.iterator();
        while(categorySpecIdIterator.hasNext()){
            GoodSpecNameValueEntity goodSpecNameValueEntity=new GoodSpecNameValueEntity();
            Integer categorySpecId=(Integer)categorySpecIdIterator.next();
            String specName=getSpecNameByCategorySpecId(categorySpecId);
            EntityWrapper<GoodSpecValueEntity> goodSpecValueEntityWrapper=new EntityWrapper<GoodSpecValueEntity>();
            Wrapper<GoodSpecValueEntity> gsvew=goodSpecValueEntityWrapper.eq("category_spec_id",categorySpecId);
            List<GoodSpecValueEntity> list1=goodSpecValueService.selectList(gsvew);
            List<Map> mapList=new ArrayList<Map>();
            Map map =new HashMap();
            Iterator list1Itertor=list1.iterator();

            while (list1Itertor.hasNext()){
                GoodSpecValueEntity goodSpecValueEntity=(GoodSpecValueEntity) list1Itertor.next();
                Integer goodSpecValueId=goodSpecValueEntity.getId();
                String specValue=goodSpecValueEntity.getSpecValue();
                map.put("goodSpecValueId",goodSpecValueId);
                map.put("specValue",specValue);
                mapList.add(map);
            }
            goodSpecNameValueEntity.setCategorySpecId(categorySpecId);
            goodSpecNameValueEntity.setSpecName(specName);
            goodSpecNameValueEntity.setMapList(mapList);
            resultList.add(goodSpecNameValueEntity);

        }
        return R.ok().put("data",resultList);
    }


    public String getSpecNameByCategorySpecId(Integer categorySpecId){
        EntityWrapper<CategorySpecEntity> entityWrapper=new EntityWrapper<CategorySpecEntity>();
        Wrapper<CategorySpecEntity> wrapper=entityWrapper.eq("id",categorySpecId);
        CategorySpecEntity categorySpecEntity=categorySpecService.selectOne(wrapper);
        return  categorySpecEntity.getSpecName();
    }




}

package com.bluemountain.modules.pc.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;

import com.bluemountain.modules.pc.entity.PcEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 14:56:33
 */
@TableName("t_pc")
@ApiModel(value = "Pc")
public class PcView  extends PcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PcView(){
	}
 
 	public PcView(PcEntity pcEntity){
 	try {
			BeanUtils.copyProperties(this, pcEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

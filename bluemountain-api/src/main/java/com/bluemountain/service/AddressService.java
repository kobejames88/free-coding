/****************************************************
 * Description: Service for 地址
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/
package com.bluemountain.service;


import com.bluemountain.customer.address.entity.AddressEntity;
import com.bluemoutain.service.XjjService;

import java.util.List;

public interface AddressService  extends XjjService<AddressEntity> {
	
	/**
	 * 查询用户的地址
	 * @param customerId
	 * @return
	 */
	public List<AddressEntity> findListByCustomerId(Long customerId);
	
	/**
	 * 重置其他收获地址的默认选项
	 * @param userId
	 */
	public void resetDefault(Long userId);
	
	
	/**
	 * 获得默认地址
	 * @param userId
	 */
	public AddressEntity getDefault(Long userId);
}

package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;

/***
 * 
 * 
 * @author liuty
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem GetItemById(long id) {
		//根据主键查询
		//TbItem item = itemMapper.selectByPrimaryKey(id);
		
		//根据条件查询
		TbItemExample example = new TbItemExample();
	    Criteria cr=example.createCriteria();
	    
	    cr.andIdEqualTo(id);   
	    
		List<TbItem> list=itemMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			TbItem item=list.get(0);
			return item;
		}		
		return null;
	}

}

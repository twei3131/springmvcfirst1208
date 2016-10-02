package cn.itcast.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.service.ItemsService;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;


@Controller
public class ItemController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping(value="/queryItems.action")
	public ModelAndView queryItems()throws Exception{
		
		//调用service查找 数据库，查询商品列表，这里使用静态数据模拟
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		//返回ModelAndView
		ModelAndView modelAndView =  new ModelAndView();
		//相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		
		//指定视图
		//下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		//上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/itemsList");
		
		return modelAndView;
		
	}
}

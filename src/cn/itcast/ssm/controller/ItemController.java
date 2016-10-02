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
		
		//����service���� ���ݿ⣬��ѯ��Ʒ�б�����ʹ�þ�̬����ģ��
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		//����ModelAndView
		ModelAndView modelAndView =  new ModelAndView();
		//�൱ ��request��setAttribut����jspҳ����ͨ��itemsListȡ����
		modelAndView.addObject("itemsList", itemsList);
		
		//ָ����ͼ
		//�±ߵ�·�����������ͼ������������jsp·����ǰ׺��jsp·���ĺ�׺���޸�Ϊ
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		//�ϱߵ�·�����ÿ��Բ��ڳ�����ָ��jsp·����ǰ׺��jsp·���ĺ�׺
		modelAndView.setViewName("items/itemsList");
		
		return modelAndView;
		
	}
}

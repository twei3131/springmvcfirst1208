package cn.itcast.ssm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.service.ItemsService;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;


@Controller
@RequestMapping(value="/items")
public class ItemController {
	private static Logger logger = Logger.getLogger(ItemController.class); 
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
	
	@RequestMapping(value="editItems.action")
	public ModelAndView editItems(@RequestParam(value="id") Integer id)throws Exception{
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsCustom", itemsCustom);
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}
	
	@RequestMapping(value="editItemsSubmit.action",method={RequestMethod.POST})
	public ModelAndView editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom)throws Exception{
		logger.debug("�ɹ���");
		itemsService.updateItems(id, itemsCustom);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
}

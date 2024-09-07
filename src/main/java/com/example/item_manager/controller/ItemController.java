package com.example.item_manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.item_manager.entity.Item;
import com.example.item_manager.form.ItemForm;
import com.example.item_manager.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;
	
	// 商品一覧ページ
	@GetMapping
	public String index(Model uiModel) {
		List<Item> items = this.itemService.findAll();
		uiModel.addAttribute("items", items);
		return "item/index";
	}
	
	// 商品登録ページ
	@GetMapping("toroku")
	public String torokuPage(@ModelAttribute("itemForm") ItemForm itemForm) {
		return "item/torokuPage";
	}
	
	// 商品登録
	@PostMapping("toroku")
	public String toroku(ItemForm itemForm) {
		return "redirect:/item";
	}
	
	// 商品編集ページ
	@GetMapping("hensyu/{id}")
	public String henshuPage(
			@PathVariable("id") int id,
			Model uiModel,
			@ModelAttribute("itemForm") ItemForm itemForm) {
		return "item/henshuPage";
	}
	
	// 商品編集
	@PostMapping("henshu/{id}")
	public String henshu(@PathVariable("id") int id, @ModelAttribute("itemForm") ItemForm itemForm) {
		return "redirect:/item";
	}
	
	// 商品削除
	@PostMapping("sakujo/{id}")
	public String sakujo(@PathVariable("id") int id) {
		return "redirect:/item";
	}
}

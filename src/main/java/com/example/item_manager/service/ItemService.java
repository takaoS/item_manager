package com.example.item_manager.service;

import org.springframework.stereotype.Service;

import com.example.item_manager.entity.Item;
import com.example.item_manager.mapper_repository.ItemMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService {
	private final ItemMapper itemDao;
	
    /*
    @RequiredArgsConstructor のおかげで、finalフィールドを持つ全てのフィールドに対応する引数を持つコンストラクタを自動作成してくれる。
    このアノテーションを使わない場合は、以下のようなコンストラクタが必要。
    
    @Autowired
    public ItemService(ItemMapper itemDao) {
        this.itemDao = itemDao;
    }
    */
	
	public Item findById(int id) {
		return itemDao.findById(id);
	}
}

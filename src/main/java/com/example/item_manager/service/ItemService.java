package com.example.item_manager.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.item_manager.entity.Item;
import com.example.item_manager.form.ItemForm;
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
	
	public List<Item> findAll() {
		return itemDao.findAll();
	}
	
	public int save(ItemForm itemForm) {
		Item item = new Item(); // Entityクラスのインスタンスを生成
		
		item.setName(itemForm.getName()); // 値をセット
		item.setPrice(itemForm.getPrice());
		
		return itemDao.save(item);
	}
	
	public int update(int id, ItemForm itemForm) {
		Item item = new Item();
		
		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		
		return itemDao.update(id, item);
	}
	
	public int delete(int id) {
		return itemDao.delete(id);
	}
	
	public List<Item> findByDeletedAtIsNull() {
		return itemDao.findByDeletedAtIsNull();
	}
	
	public int softDelete(int id) {
		Item item = this.findById(id);
		item.setDeletedAt(LocalDateTime.now());
		
		return itemDao.softDelete(id, item);
	}
}

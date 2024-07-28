package com.example.item_manager.mapper_repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.item_manager.entity.Item;

@Mapper
public interface ItemMapper {
	
	// @Select("SELECT * FROM items WHERE id = #{id}") // 今回は XMLマッピングを利用するので不要
    Item findById(int id);
    
}

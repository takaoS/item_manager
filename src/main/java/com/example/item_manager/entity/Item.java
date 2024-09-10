package com.example.item_manager.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Item {
	private int id;  // null は入らないので、Integer型にする必要はない
	private String name;
	private int price;
	private LocalDateTime deletedAt; // 論理削除用
}

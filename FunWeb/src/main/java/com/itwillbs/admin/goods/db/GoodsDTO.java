package com.itwillbs.admin.goods.db;

import java.sql.Timestamp;

public class GoodsDTO {
	private int gno;				// 상품 번호
	private String category;		// 상품 카테고리
	private String name;			// 상품명
	private String content;			// 상품 상세설명
	private String size;			// 상품 옵션(크기)
	private String color;			// 상품 옵션(색상)
	private int amount;				// 상품 수량
	private int price;				// 상품 가격
	private String image;			// 상품 이미지
	private int best;				// 인기상품
	private Timestamp date;			// 상품 등록일
	
	// getter&setter 생성 => ctrl shift s + r 
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getBest() {
		return best;
	}
	public void setBest(int best) {
		this.best = best;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	// alt shift s + s
	@Override
	public String toString() {
		return "GoodsDTO [gno=" + gno + ", category=" + category + ", name=" + name + ", content=" + content + ", size="
				+ size + ", color=" + color + ", amount=" + amount + ", price=" + price + ", image=" + image + ", best="
				+ best + ", date=" + date + "]";
	}

}

package com.servme.todo.todoapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_TBL")
public class Item {

	@Id
	@SequenceGenerator(name = "item_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id")
	private Long itemId;
	private String name;
	private String description;
	private String dateTime;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String category;
	private Long userMappingId;

	public Item() {
	}

	public Item(Long itemId, String name, String description, String dateTime, Status status, String category,
			Long userMappingId, User user) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.dateTime = dateTime;
		this.status = status;
		this.category = category;
		this.userMappingId = userMappingId;
		this.user = user;
	}

	public Long getUserMappingId() {
		return userMappingId;
	}

	public void setUserMappingId(Long userMappingId) {
		this.userMappingId = userMappingId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", description=" + description + ", dateTime=" + dateTime
				+ ", status=" + status + ", category=" + category + "]";
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

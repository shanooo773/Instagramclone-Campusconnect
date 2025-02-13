package com.camp.campusconnect.modal;

import java.time.LocalDateTime;
import java.util.*;

import com.camp.campusconnect.dto.UserDto;

import jakarta.persistence.*;
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
@Embedded
@AttributeOverrides({
	@AttributeOverride(name="id",column=@Column(name="user_id")),
	@AttributeOverride(name="email",column=@Column(name="user_email"))

})
	private UserDto user;
	private String content;
	@Embedded
	@ElementCollection
	private Set<UserDto> likedByUser=new HashSet<UserDto>();
	private LocalDateTime createdAt;
	public Comment(Integer id, UserDto user, String content, Set<UserDto> likedByUser, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.likedByUser = likedByUser;
		this.createdAt = createdAt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Set<UserDto> getLikedByUser() {
		return likedByUser;
	}
	public void setLikedByUser(Set<UserDto> likedByUser) {
		this.likedByUser = likedByUser;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}

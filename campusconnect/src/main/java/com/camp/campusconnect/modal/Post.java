package com.camp.campusconnect.modal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.camp.campusconnect.dto.UserDto;

import jakarta.persistence.*;
@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)           
	private Integer id;
	private String caption;
	private String image;
	private String location;
	private LocalDateTime createdAt;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="user_id")),
		@AttributeOverride(name="email",column=@Column(name="user_email"))
	
	})
	private UserDto user;
	@OneToMany
	private List<Comment> comments=new ArrayList<>();
	@Embedded
	@ElementCollection
	@JoinTable(name="likedByUser",joinColumns=@JoinColumn(name="user id"))
	private Set<UserDto> LikedByUser=new HashSet<>();
	public Post(Integer id, String caption, String image, String location, LocalDateTime createdAt, UserDto user,
			List<Comment> comments, Set<UserDto> likedByUser) {
		super();
		this.id = id;
		this.caption = caption;
		this.image = image;
		this.location = location;
		this.createdAt = createdAt;
		this.user = user;
		this.comments = comments;
		LikedByUser = likedByUser;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Set<UserDto> getLikedByUser() {
		return LikedByUser;
	}
	public void setLikedByUser(Set<UserDto> likedByUser) {
		LikedByUser = likedByUser;
	}

}

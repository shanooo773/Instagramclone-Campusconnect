package com.camp.campusconnect.modal;

import java.util.*;
import com.camp.campusconnect.dto.UserDto;
import jakarta.persistence.*;

@Entity
@Table(name = "users") // Avoid reserved keywords like "user"
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String name;
    private String email;
    private String mobile;
    private String website;
    private String bio;
    private String gender;
    private String image;
    private String password;

    @ElementCollection
    private Set<UserDto> follower = new HashSet<>();

    @ElementCollection
    private Set<UserDto> following = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Story> stories = new ArrayList<>();

    @ManyToMany
    private List<Post> savedPost = new ArrayList<>();

    // No-argument constructor (required by JPA)
    public User() {}

    // Partial constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Full constructor
    public User(Integer id, String username, String name, String email, String mobile, String website, String bio,
                String gender, String image, String password, Set<UserDto> follower, Set<UserDto> following,
                List<Story> stories, List<Post> savedPost) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.website = website;
        this.bio = bio;
        this.gender = gender;
        this.image = image;
        this.password = password;
        this.follower = follower;
        this.following = following;
        this.stories = stories;
        this.savedPost = savedPost;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserDto> getFollower() {
        return follower;
    }

    public void setFollower(Set<UserDto> follower) {
        this.follower = follower;
    }

    public Set<UserDto> getFollowing() {
        return following;
    }

    public void setFollowing(Set<UserDto> following) {
        this.following = following;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<Post> getSavedPost() {
        return savedPost;
    }

    public void setSavedPost(List<Post> savedPost) {
        this.savedPost = savedPost;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + ", mobile="
                + mobile + ", website=" + website + ", bio=" + bio + ", gender=" + gender + ", image=" + image
                + ", password=" + password + ", follower=" + follower + ", following=" + following + "]";
    }
}

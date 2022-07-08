package com.example.user.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long likeId;
	private int noOfLike;
	private List<User> likedUser;

	public Like() {
		super();
	}

	public Like(long likeId, int noOfLike, List<User> likedUser) {
		super();
		this.likeId = likeId;
		this.noOfLike = noOfLike;
		this.likedUser = likedUser;
	}

	public long getLikeId() {
		return likeId;
	}

	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}

	public int getNoOfLike() {
		return noOfLike;
	}

	public void setNoOfLike(int noOfLike) {
		this.noOfLike = noOfLike;
	}

	public List<User> getLikedUser() {
		return likedUser;
	}

	public void setLikedUser(List<User> likedUser) {
		this.likedUser = likedUser;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", noOfLike=" + noOfLike + ", likedUser=" + likedUser + "]";
	}

}

package com.example.user.service;

import com.example.user.model.User;
import com.example.user.repository.LikeRepository;

public class LikeService {
	private final LikeRepository likerepository;
	
	public LikeService(LikeRepository likerepo) {
		this.likerepository=likerepo;
	}
	
	public User addLike(User user) {
		return likerepository.save(user);
	}
	
	public void deleteLike(User user) {
		likerepository.delete(user);
	}
}


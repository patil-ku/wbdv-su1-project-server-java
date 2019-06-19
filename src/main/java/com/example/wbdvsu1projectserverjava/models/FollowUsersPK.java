package com.example.wbdvsu1projectserverjava.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FollowUsersPK implements Serializable {

  private static final long serialVersionUID = -6790693372846798580L;
  private int userId;
  private int followingUserId;

  public FollowUsersPK(int userId, int followingUserId) {
    this.userId = userId;
    this.followingUserId = followingUserId;
  }

  public FollowUsersPK() {
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getFollowingUserId() {
    return followingUserId;
  }

  public void setFollowingUserId(int followingUserId) {
    this.followingUserId = followingUserId;
  }
}
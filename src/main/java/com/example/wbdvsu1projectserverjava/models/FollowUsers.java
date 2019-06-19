package com.example.wbdvsu1projectserverjava.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class FollowUsers {

  @EmbeddedId
  private FollowUsersPK followUsersPK;

  public FollowUsersPK getFollowUsersPK() {
    return followUsersPK;
  }

  public void setFollowUsersPK(FollowUsersPK followUsersPK) {
    this.followUsersPK = followUsersPK;
  }

  @Embeddable
  private class FollowUsersPK implements Serializable {
    private int userId;
    private int followingUserId;

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
}

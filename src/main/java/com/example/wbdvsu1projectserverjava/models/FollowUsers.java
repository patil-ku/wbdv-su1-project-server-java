package com.example.wbdvsu1projectserverjava.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class FollowUsers {

  @EmbeddedId
  private FollowUsersPK followUsersPK;

  public FollowUsers() {
  }

  public FollowUsers(FollowUsersPK followUsersPK) {
    this.followUsersPK = followUsersPK;
  }

  public FollowUsersPK getFollowUsersPK() {
    return followUsersPK;
  }

  public void setFollowUsersPK(FollowUsersPK followUsersPK) {
    this.followUsersPK = followUsersPK;
  }


}

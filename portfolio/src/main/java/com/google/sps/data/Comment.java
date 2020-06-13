package com.google.sps.data;

/** An item on a todo list. */
public final class Comment {

  private final long id;
  private final String title;
  private final long timestamp;

  public Comment(long id, String title, long timestamp) {
    this.id = id;
    this.title = title;
    this.timestamp = timestamp;
  }
}
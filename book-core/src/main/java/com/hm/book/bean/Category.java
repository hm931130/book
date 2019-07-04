package com.hm.book.bean;

import java.util.Date;

public class Category {
 private Long id;

 private String name;

 private Date createTime;

 private Date updateTime;

 public Category(Long id, String name, Date createTime, Date updateTime) {
  this.id = id;
  this.name = name;
  this.createTime = createTime;
  this.updateTime = updateTime;
 }

 public Category() {
  super();
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name == null ? null : name.trim();
 }

 public Date getCreateTime() {
  return createTime;
 }

 public void setCreateTime(Date createTime) {
  this.createTime = createTime;
 }

 public Date getUpdateTime() {
  return updateTime;
 }

 public void setUpdateTime(Date updateTime) {
  this.updateTime = updateTime;
 }

 @Override
 public String toString() {
  return "Category{" +
   "id=" + id +
   ", name='" + name + '\'' +
   ", createTime=" + createTime +
   ", updateTime=" + updateTime +
   '}';
 }
}
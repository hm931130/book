package com.hm.book.bean;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
 private Long id;

 private Long categoryId;

 private String name;

 private Integer level;

 private Integer price;

 private String imgPath;

 private Date createTime;

 private Date updateTime;

 public Book(Long id, Long categoryId, String name, Integer level, Integer price, String imgPath, Date createTime, Date updateTime) {
  this.id = id;
  this.categoryId = categoryId;
  this.name = name;
  this.level = level;
  this.price = price;
  this.imgPath = imgPath;
  this.createTime = createTime;
  this.updateTime = updateTime;
 }

 public Book() {
  super();
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public Long getCategoryId() {
  return categoryId;
 }

 public void setCategoryId(Long categoryId) {
  this.categoryId = categoryId;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name == null ? null : name.trim();
 }

 public Integer getLevel() {
  return level;
 }

 public void setLevel(Integer level) {
  this.level = level;
 }

 public Integer getPrice() {
  return price;
 }

 public void setPrice(Integer price) {
  this.price = price;
 }

 public String getImgPath() {
  return imgPath;
 }

 public void setImgPath(String imgPath) {
  this.imgPath = imgPath == null ? null : imgPath.trim();
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
  return "Book{" +
   "id=" + id +
   ", categoryId=" + categoryId +
   ", name='" + name + '\'' +
   ", level=" + level +
   ", price=" + price +
   ", imgPath='" + imgPath + '\'' +
   ", createTime=" + createTime +
   ", updateTime=" + updateTime +
   '}';
 }
}
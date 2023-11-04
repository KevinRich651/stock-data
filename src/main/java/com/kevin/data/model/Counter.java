package com.kevin.data.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "counter")
public class Counter implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Integer count;

  @Column(nullable = false)
  private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}

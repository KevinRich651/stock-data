package com.kevin.data.dal.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "counter")
class Counter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int=0,

    @Column(nullable = false)
    var count: Int=0,

    @Column(nullable = false, name = "create_time")
    val createTime: Timestamp = Timestamp(System.currentTimeMillis())
)

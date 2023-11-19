package com.kevin.data.dal.entity

import org.springframework.data.annotation.Id
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "counter")
data class Counter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    var count: Int,

    @Column(nullable = false, name = "create_time")
    val createTime: Timestamp = Timestamp(System.currentTimeMillis())
)

package com.github.huangsuixin.testapi.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author suixin
 * @version 1.0
 * @className ApiInfoDO
 * @date 2018/11/16 10:02
 * @description //TODO
 * @program test-api
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ApiInfoDO implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 内容
     */
    @Column(name = "content", length = 10000)
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    @CreatedDate
    private Long gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Long gmtModified;
}

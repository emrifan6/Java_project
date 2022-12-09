// Java Program to Demonstrate Department File

// Importing package module to this code fragment 
package com.amiya.springbootstarterweb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Importing required classes 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Class
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
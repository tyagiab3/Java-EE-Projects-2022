package com.practice.dao;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.pojo.Customers;

public interface CustomerDAO extends MongoRepository<Customers, Integer>{

}

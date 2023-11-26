package com.example.labweek7.repositories;

import com.example.labweek7.models.Order;
import com.example.labweek7.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Order>, JpaSpecificationExecutor<OrderDetail> {
}
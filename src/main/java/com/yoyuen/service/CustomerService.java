package com.yoyuen.service;

import com.yoyuen.entity.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer getCustomer(Long id);
}

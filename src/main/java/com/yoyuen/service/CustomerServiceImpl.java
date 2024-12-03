package com.yoyuen.service;

import com.yoyuen.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<Long, Customer> customerMap = new HashMap<Long, Customer>();
    public CustomerServiceImpl(){
    }
    @Override
    public Customer addCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
        return customer;
    }
    @Override
    public Customer getCustomer(Long id) {
        return customerMap.get(id);
    }

}

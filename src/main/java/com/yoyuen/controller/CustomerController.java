package com.yoyuen.controller;

import com.yoyuen.entity.Customer;
import com.yoyuen.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private static final Log logger = LogFactory.getLog(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/input-customer")
    public String inputCustomer() {
        logger.info("inputCustomer called");
        return "inputCustomer";
    }

    @RequestMapping(value = "/save-customer", method = RequestMethod.POST)
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        logger.info("saveCustomer called");
        Customer savedCustomer = customerService.addCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "The product was successfully added.");
        return "redirect:/view-customer/" + savedCustomer.getId();
    }

    @RequestMapping(value = "/view-customer/{id}")
    public String viewCustomer(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "showCustomer";
    }
}

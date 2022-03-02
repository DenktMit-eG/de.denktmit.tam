package de.denktmit.tam.webapp.web.controller;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import de.denktmit.tam.webapp.service.CustomerService;
import de.denktmit.tam.webapp.web.Routes;
import de.denktmit.tam.webapp.web.mapper.CustomerMapper;
import de.denktmit.tam.webapp.web.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = Routes.COSTUMER_SIMPLE)
    public String getCustomers(Model model) {
        List<CustomerEntity> customers = customerService.findAll(Sort.by(Sort.Direction.ASC, "companyName"));
        List<CustomerDTO> customerDTOs = CustomerMapper.INSTANCE.toDTOs(customers);
        model.addAttribute("customers", customerDTOs);
        return "listcustomers.html";
    }
}

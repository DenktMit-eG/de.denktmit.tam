package de.denktmit.tam.webapp.web.controller;

import de.denktmit.tam.webapp.web.PageAttributeValidator;
import de.denktmit.tam.webapp.web.Routes;
import de.denktmit.tam.webapp.web.model.CustomerDTO;
import de.denktmit.tam.webapp.web.service.CustomerWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {

    private final CustomerWebService customerWebService;

    @Autowired
    public CustomerController(CustomerWebService customerWebService) {
        this.customerWebService = customerWebService;
    }

    @GetMapping(value = Routes.CUSTOMER)
    public String getCustomerCRUDTableView(Model model,
                                           @PathVariable(value = "currentPage", required = false) Optional<Integer> pageFromPath) {

        int page = PageAttributeValidator.checkPageId(pageFromPath);

        model.addAttribute("currentPage", page);
        model.addAttribute("newCustomer", new CustomerDTO());
        model.addAttribute("customersPage", customerWebService.getCustomersPageable(PageRequest.of(page - 1, 25)));
        model.addAttribute("viewName", "customers");
        return "customer";
    }

    @PostMapping(value = Routes.CUSTOMER)
    public ModelAndView postNewCustomer(ModelAndView modelAndView, RedirectAttributes redirectAttributes,
                                        @Valid @ModelAttribute("customer") CustomerDTO customerDTO) {
        customerWebService.createCustomer(customerDTO);
        //TODO: catch exceptions and display text to suer
        modelAndView.setViewName(Routes.prependRedirect(Routes.CUSTOMER));
        return modelAndView;
    }

    @GetMapping(value = Routes.DELETE_CUSTOMER)
    public ModelAndView deleteCustomer(ModelAndView modelAndView, RedirectAttributes redirectAttributes,
                                       @PathVariable(name = "customerId") Long customerId) {
        customerWebService.deleteCustomer(customerId);
        modelAndView.setViewName(Routes.prependRedirect(Routes.CUSTOMER));
        return modelAndView;

    }

    @PostMapping(value = Routes.PATCH_CUSTOMER)
    public ModelAndView patchCustomer(ModelAndView modelAndView, RedirectAttributes redirectAttributes,
                                      @Valid CustomerDTO customerDTO) {
        customerWebService.updateCustomer(customerDTO);
        modelAndView.setViewName(Routes.prependRedirect(Routes.CUSTOMER));
        return modelAndView;
    }

}

package de.denktmit.tam.webapp.web.controller;

import de.denktmit.tam.webapp.web.PageAttributeChecker;
import de.denktmit.tam.webapp.web.Routes;
import de.denktmit.tam.webapp.web.model.CustomerDTO;
import de.denktmit.tam.webapp.web.service.impl.CustomerWebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {

    private CustomerWebServiceImpl customerWebServiceImpl;

    @Autowired
    public CustomerController(CustomerWebServiceImpl customerWebServiceImpl) {
        this.customerWebServiceImpl = customerWebServiceImpl;
    }

    @GetMapping(value = Routes.COSTUMER)
    public String getCustomerCRUDTableView(Model model,
                                           @PathVariable(value = "currentPage", required = false) Optional<Integer> pageFromPath) {

        int page = PageAttributeChecker.checkPageId(pageFromPath);

        model.addAttribute("currentPage", page);
        model.addAttribute("newCustomer", new CustomerDTO());
        model.addAttribute("customersPage", customerWebServiceImpl.getCustomersPageable(PageRequest.of(page - 1, 25)));
        model.addAttribute("viewName", "customers");
        return "customer";
    }

    @PostMapping(value = Routes.COSTUMER)
    public ModelAndView postCustomer(ModelAndView modelAndView, RedirectAttributes redirectAttributes,
                                     @Valid @ModelAttribute("customer") CustomerDTO customerDTO) {
        customerWebServiceImpl.createCustomer(customerDTO);
        //TODO: catch exceptions and display text to suer
        modelAndView.setViewName(Routes.prependRedirect(Routes.COSTUMER));
        return modelAndView;
    }

}

package de.denktmit.tam.webapp.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String companyName;
    private String contactName;
    private String addressCountryIsoCode;
    private String addressZip;
    private String addressCity;
    private String addressStreet;
}

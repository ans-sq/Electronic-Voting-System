package com.project.voting_system.controller;

import com.project.voting_system.models.Address;
import com.project.voting_system.requests.AddAddressRequest;
import com.project.voting_system.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evs")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public ResponseEntity<?> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/address/city/{city}")
    public ResponseEntity<?> getAllCityAddresses(@PathVariable String city) {
        return ResponseEntity.ok(addressService.getAddressesByCity(city));
    }

    @GetMapping("/address/province/{province}")
    public ResponseEntity<?> getAllProvinceAddresses(@PathVariable String province) {
        return ResponseEntity.ok(addressService.getAddressesByProvince(province));
    }

    @GetMapping("/addresses/country/{country}")
    public ResponseEntity<?> getAllCountryAddresses(@PathVariable String country) {
        return ResponseEntity.ok(addressService.getAddressesByCountry(country));
    }

    @PostMapping("/address")
    public ResponseEntity<?> addNewAddress(@RequestBody AddAddressRequest addAddressRequest) {
        if (addressService.addressExists(addAddressRequest.getStreet(), addAddressRequest.getCity(),
                addAddressRequest.getProvince(), addAddressRequest.getCountry())) {
            return ResponseEntity.badRequest().body("Address already exists");
        }

        Address address = new Address();
        address.setStreet(addAddressRequest.getStreet());
        address.setCity(addAddressRequest.getCity());
        address.setProvince(addAddressRequest.getProvince());
        address.setCountry(addAddressRequest.getCountry());
        address.setPostalCode(addAddressRequest.getPostalCode());
        address = addressService.createAddress(address);

        return ResponseEntity.ok(address);
    }

}

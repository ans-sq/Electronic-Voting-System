package com.project.voting_system.services;

import com.project.voting_system.models.Address;
import com.project.voting_system.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    private final AddressRepository addressRepository;

    @Autowired
    AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Long addressID) {
        return addressRepository.findById(addressID).orElse(null);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public List<Address> getAddressesByCity(String city) {
        return addressRepository.findByCity(city);
    }

    public List<Address> getAddressesByProvince(String province) {
        return addressRepository.findByProvince(province);
    }

    public List<Address> getAddressesByCountry(String country) {
        return addressRepository.findByCountry(country);
    }

    public Boolean addressExists(String street, String city, String province, String country) {
        return addressRepository.existsByStreetAndCityAndProvinceAndCountry(street, city, province, country);
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long addressID) {
        addressRepository.deleteById(addressID);
    }
}

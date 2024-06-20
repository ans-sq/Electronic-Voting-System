package com.project.voting_system.repository;

import com.project.voting_system.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCity(String city);
    List<Address> findByProvince(String province);
    List<Address> findByCountry(String country);
    Boolean existsByStreetAndCityAndProvinceAndCountry(String street, String city, String province, String country);
}


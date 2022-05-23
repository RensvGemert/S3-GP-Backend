package com.example.PIM.repositories;

import com.example.PIM.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICompanyRepository extends JpaRepository<Company, Integer>
{
    @Query(value = "SELECT `id` FROM `company` WHERE `role` = ?1", nativeQuery = true)
    int companyResponse(int role);

}

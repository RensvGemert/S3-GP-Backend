package com.example.PIM.repositories;

import com.example.PIM.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Integer>
{

}

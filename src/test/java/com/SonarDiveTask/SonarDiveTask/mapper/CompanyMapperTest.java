package com.SonarDiveTask.SonarDiveTask.mapper;

import com.SonarDiveTask.SonarDiveTask.dtos.CompanyDto;
import com.SonarDiveTask.SonarDiveTask.dtos.CountryDto;
import com.SonarDiveTask.SonarDiveTask.entities.Company;
import com.SonarDiveTask.SonarDiveTask.entities.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyMapperTest {

    @Autowired
    private CompanyMapper companyMapper;

    @Test
    public void toCompanyDto() {

        Country country = new Country();
        country.setId(12);
        country.setIsoCode("NZ");

        Company company = new Company();
        company.setId(20);
        company.setName("SonarDive");
        company.setCountry(country);

        CompanyDto companyDto = companyMapper.toCompanyDto(company);

        assertNotNull(companyDto);
        assertEquals(20, companyDto.id());
        assertEquals("SonarDive", companyDto.name());
        assertNotNull(companyDto.country());
        assertEquals(12, companyDto.country().id());
        assertEquals("NZ", companyDto.country().name());
    }

    @Test
    public void toCompanyDtoHandleNullCountry(){
        Company company = new Company();
        company.setId(70);
        company.setName("SonarDive");
        company.setCountry(null);
        CompanyDto companyDto = companyMapper.toCompanyDto(company);

        assertNotNull(companyDto);
        assertEquals(70, companyDto.id());
        assertEquals("SonarDive", companyDto.name());
        assertNull(companyDto.country());
    }

    @Test
    public void toCompanyDtoHandleNullCompany(){
        CompanyDto companyDto = companyMapper.toCompanyDto(null);

        assertNull(companyDto);
    }

    @Test
    public void toCompany() {

        CountryDto countryDto = new CountryDto(10, "NZ");

        CompanyDto companyDto = new CompanyDto(300, "SonarDive", countryDto);

        Company company = companyMapper.toCompany(companyDto);

        assertNotNull(company);
        assertEquals(300, company.getId());
        assertEquals("SonarDive", company.getName());
        assertNotNull(company.getCountry());
        assertEquals(10, company.getCountry().getId());
        assertEquals("NZ", company.getCountry().getIsoCode());
    }
    @Test
    public void toCompanyHandleNullCompanyDto(){
        Company company = companyMapper.toCompany(null);
        assertNull(company);
    }
    @Test
    public void toCompanyHandleNullCountry(){
        CompanyDto companyDto = new CompanyDto(20, "SonarDive",null);
        Company company = companyMapper.toCompany(companyDto);
        assertNotNull(companyDto);
        assertEquals(20, company.getId());
        assertEquals("SonarDive", company.getName());
        assertNull(company.getCountry());
    }

}
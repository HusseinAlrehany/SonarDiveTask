package com.SonarDiveTask.SonarDiveTask.mapper;
import com.SonarDiveTask.SonarDiveTask.dtos.CompanyDto;
import com.SonarDiveTask.SonarDiveTask.entities.Company;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = CountryMapper.class, injectionStrategy =
        InjectionStrategy.CONSTRUCTOR)
public interface CompanyMapper {

   // CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
    @Mapping(target = "country", source = "country")
    CompanyDto toCompanyDto(Company company);

    @Mapping(target = "country", source = "country")
    Company toCompany(CompanyDto companyDto);

}

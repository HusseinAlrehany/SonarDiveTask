package com.SonarDiveTask.SonarDiveTask.mapper;
import com.SonarDiveTask.SonarDiveTask.dtos.CountryDto;
import com.SonarDiveTask.SonarDiveTask.entities.Country;
import com.SonarDiveTask.SonarDiveTask.services.CountryService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = CountryService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CountryMapper {
    @Mapping(target = "name", source = "isoCode")
    CountryDto toCountryDto(Country country);
    @Mapping(target = "isoCode", source = "name")
    Country toCountry(CountryDto countryDto);
}

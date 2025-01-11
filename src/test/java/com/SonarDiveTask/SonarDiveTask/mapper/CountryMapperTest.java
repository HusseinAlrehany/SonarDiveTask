package com.SonarDiveTask.SonarDiveTask.mapper;
import com.SonarDiveTask.SonarDiveTask.dtos.CountryDto;
import com.SonarDiveTask.SonarDiveTask.entities.Country;
import com.SonarDiveTask.SonarDiveTask.services.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CountryMapperTest {

    private final CountryMapper countryMapper = new CountryMapperImpl(new CountryService());
    @MockBean
    private CountryService countryService;

    @Test
    public void toCountryDto() {

        Country country = new Country();
        country.setId(2);
        country.setIsoCode("NZ");

        CountryDto countryDto = countryMapper.toCountryDto(country);

        System.out.println("COUNTRY DTO -> -> " + countryDto);

        assertNotNull(countryDto);
        assertEquals(2, countryDto.id());
        assertEquals("NZ", countryDto.name());
    }

    @Test
    public void toCountryDtoHandleNullCountry(){
        CountryDto countryDto = countryMapper.toCountryDto(null);
        assertNull(countryDto, "CountryDto is Null");
    }

    @Test
    public void ToCountry() {

        CountryDto countryDto = new CountryDto(10, "EGY");

        Country country = countryMapper.toCountry(countryDto);

        assertNotNull(country);
        assertEquals(10, country.getId());
        assertEquals("EGY", country.getIsoCode());
    }
    @Test
    public void toCountryHandleNullCountryDto(){
        Country country = countryMapper.toCountry(null);
        assertNull(country);
    }

    @Test
    public void usingCountryServiceInCountryMapping() {

        Country country = new Country();
        country.setId(1);
        country.setIsoCode("NJI");

        when(countryService.getName("US")).thenReturn(country.getIsoCode());

        CountryDto countryDto = countryMapper.toCountryDto(country);

        assertNotNull(countryDto);
        assertEquals("NJI", countryDto.name());
    }

    @Test
    public void handleNullCountryServiceInCountryMapping(){
        Country country = new Country();
        country.setId(10);
        country.setIsoCode(null);

        when(countryService.getName("US")).thenReturn(null);

        CountryDto countryDto = countryMapper.toCountryDto(country);
        assertNotNull(countryDto);
        assertNull(countryDto.name());
    }


    }

package com.fantasy.tbs.service.mapper;

import com.fantasy.tbs.domain.TimeBookDTO;
import com.fantasy.tbs.domain.TimeBooking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TimeBookMapper {
    @Mapping(target = "booking", source = "timeStamp")
    TimeBooking toTimeBooking(TimeBookDTO timeBookDTO);
}

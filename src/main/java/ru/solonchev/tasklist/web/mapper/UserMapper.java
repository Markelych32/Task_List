package ru.solonchev.tasklist.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.solonchev.tasklist.domain.user.User;
import ru.solonchev.tasklist.web.dto.user.UserDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}

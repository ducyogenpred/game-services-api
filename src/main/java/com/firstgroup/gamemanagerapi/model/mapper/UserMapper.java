package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.UserDTO;
import com.firstgroup.gamemanagerapi.model.entity.User;
import com.firstgroup.gamemanagerapi.model.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.model.request.UserRO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", source = "ro.description")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    User toEntity(UserRO ro);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    void updateFromPutRo(UserRO ro, @MappingTarget User entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    void updateFromPatchRo(UserPatchRO ro, @MappingTarget User entity);
}
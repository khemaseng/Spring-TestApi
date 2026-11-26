//package kh.edu.istad.springrestapi.mapper;
//
//import kh.edu.istad.springrestapi.dto.UserResponse;
//import kh.edu.istad.springrestapi.model.User;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper ( componentModel ="spring")
//public interface UserMapper {
//
//    UserResponse mapUserToUserResponse( User user );
//}
package kh.edu.istad.springrestapi.mapper;

import kh.edu.istad.springrestapi.dto.UserResponse;
import kh.edu.istad.springrestapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse mapUserToUserResponse(User user);
}
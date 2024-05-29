package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.UpdateUserRequest;
import org.dnyanyog.dto.UserData;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.encryption.EncryptionService;
import org.dnyanyog.entity.Users;
import org.dnyanyog.enums.ErrorCode;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserServiceImpl implements UserService {

  @Autowired UsersRepository userRepo;

  @Autowired UserResponse userResponse;

  @Autowired Users userTable;

  @Autowired EncryptionService encryptionService;

  @Override
  public UserResponse addUser(AddUserRequest addRequest) {

    userTable = new Users();

    userTable.setUserName(addRequest.getUserName());
    userTable.setEmail(addRequest.getEmail());
    userTable.setMobileNumber(addRequest.getMobileNumber());
    try {
      userTable.setPassword(encryptionService.encrypt(addRequest.getPassword()));
    } catch (Exception e) {
      e.printStackTrace();
    }

    userTable.setUserRole(addRequest.getRole());

    userTable = userRepo.save(userTable);
    userResponse.setStatus(ErrorCode.USER_ADD_SUCCESS.getCode());
    userResponse.setMessage(ErrorCode.USER_ADD_SUCCESS.getMessage());

    userResponse.getUserData().setUserId(userTable.getUserId());
    userResponse.getUserData().setUserName(userTable.getUserName());
    userResponse.getUserData().setMobileNumber(userTable.getMobileNumber());
    userResponse.getUserData().setEmail(userTable.getEmail());
    userResponse.getUserData().setPassword((userTable.getPassword()));
    userResponse.getUserData().setMobileNumber(userTable.getMobileNumber());
    userResponse.getUserData().setRole(userTable.getUserRole());

    return (userResponse);
  }

  @Override
  public UserResponse updateUser(UpdateUserRequest updateRequest) {
    Optional<Users> optionalUser = userRepo.findById(updateRequest.getUserId());
    if (optionalUser.isPresent()) {
      try {
        Users user = optionalUser.get();
        user.setUserName(updateRequest.getUserName());
        user.setEmail(updateRequest.getEmail());
        user.setMobileNumber(updateRequest.getMobileNumber());
        user.setPassword(encryptionService.encrypt(updateRequest.getPassword()));
        user.setUserRole(updateRequest.getRole());

        user = userRepo.save(user);

        userResponse.setStatus(ErrorCode.USER_UPDATE_SUCCESS.getCode());
        userResponse.setMessage(ErrorCode.USER_UPDATE_SUCCESS.getMessage());

        userResponse.getUserData().setUserId(userTable.getUserId());
        userResponse.getUserData().setUserName(userTable.getUserName());
        userResponse.getUserData().setMobileNumber(userTable.getMobileNumber());
        userResponse.getUserData().setEmail(userTable.getEmail());

      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      userResponse.setStatus(ErrorCode.USER_NOT_FOUND.getCode());
      userResponse.setMessage(ErrorCode.USER_NOT_FOUND.getMessage());
    }
    return userResponse;
  }

  @Override
  public UserResponse deleteUser(String userId) {
    Optional<Users> optionalUser = userRepo.findById(userId);

    if (optionalUser.isPresent()) {
      Users user = optionalUser.get();
      user.setStatus(Users.INACTIVE);

      userRepo.save(user);

      UserResponse userResponse = new UserResponse();
      userResponse.setStatus(ErrorCode.USER_DELETE_SUCCESS.getCode());
      userResponse.setMessage(ErrorCode.USER_DELETE_SUCCESS.getMessage());

      return (userResponse);
    } else {
      UserResponse userResponse = new UserResponse();
      userResponse.setStatus(ErrorCode.USER_NOT_FOUND.getCode());
      userResponse.setMessage(ErrorCode.USER_NOT_FOUND.getMessage());

      return (userResponse);
    }
  }
  
  @Override
  public UserResponse getUserById(@PathVariable String userId) {
      Optional<Users> optionalUser = userRepo.findById(userId);

      if (optionalUser.isPresent()) {
          Users user = optionalUser.get();

          UserResponse userResponse = new UserResponse();
          userResponse.setStatus(ErrorCode.USER_FOUND.getCode());
          userResponse.setMessage(ErrorCode.USER_FOUND.getMessage());

          UserData  userData = userResponse.getUserData();
          userData.setUserId(user.getUserId());
          userData.setUserName(user.getUserName());
          userData.setEmail(user.getEmail());
          userData.setMobileNumber(user.getMobileNumber());
          userData.setRole(user.getUserRole());

          return (userResponse);
      } else {
          UserResponse userResponse = new UserResponse();
          userResponse.setStatus(ErrorCode.USER_NOT_FOUND.getCode());
          userResponse.setMessage(ErrorCode.USER_NOT_FOUND.getMessage());

          return (userResponse);
      }
  }
}

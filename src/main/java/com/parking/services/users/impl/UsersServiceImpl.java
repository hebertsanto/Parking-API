package com.parking.services.users.impl;
import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import com.parking.repository.users.UsersRepository;
import com.parking.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsersServiceImpl implements IUserService {
  private UsersRepository repository;

  @Autowired
  public void UsersService(UsersRepository repository){
    this.repository = repository;
  }

  public Users CreateUser(UsersDTO user){

      String encrypter = new BCryptPasswordEncoder().encode(user.password());

      Users newUser = new Users(user);

      return  this.repository.save(newUser);
  };

  public Users getUser(String id) throws Exception {

      if(id == null || id.isEmpty()){
          throw new IllegalArgumentException();
      }

      Optional<Users> optionalUsers = this.repository.findById(id);
      return  optionalUsers.orElseThrow(() -> new EmptyResultDataAccessException(1));
  }
}

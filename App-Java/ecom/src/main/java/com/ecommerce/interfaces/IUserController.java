package com.ecommerce.interfaces;

import com.ecommerce.models.User;

public interface IUserController {
  public User create();

  public void remove();

  public void findClientById();

  public void update(User cliente);

  public boolean login(boolean end);
}

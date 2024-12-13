package com.jotahdev.ediaristas.web.dtos;

import org.hibernate.annotations.NotFound;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateForm {

  @NotFound
  @Size(min = 3, max = 255)
  private String fullName;

  @NotNull
  @Size(min = 3, max = 255)
  @Email
  private String email;

  @NotNull
  @NotEmpty
  private String password;

  @NotNull
  @NotEmpty
  private String confirmPassword;
  
}

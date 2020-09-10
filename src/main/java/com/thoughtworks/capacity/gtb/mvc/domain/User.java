package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Validated
public class User {
    @NotNull
    @Pattern(regexp = "[0-9A-Za-z_]*")
    @Length(min = 3, max = 10)
    private String userName;
    @NotNull
    @Length(min = 3, max = 10)
    private String passWord;
    @Email
    private String email;
    private int id;

}

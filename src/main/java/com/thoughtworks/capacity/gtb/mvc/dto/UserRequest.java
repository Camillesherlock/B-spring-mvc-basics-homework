package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotNull(message="用户名不能为空")
    @Size(min=3, max=10, message="用户名长度需为3-10位")
    @Pattern(regexp = "^[0-1a-zA-Z_]{1,}$", message="用户名需由字母，数字和下划线组成")
    private String username;

    @NotNull(message="密码不能为空")
    @Size(min=5, max=12, message="密码不合法，长度为5-12位")
    private String password;

    @Email(message="邮箱地址不合法")
    private String email;
}

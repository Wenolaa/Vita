package shop.shoes.portal.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RenewVo {
    @NotBlank(message = "帳號不得為空!")
    private String username;
    @NotBlank(message = "密碼不得為空!")
    @Pattern(regexp = "^\\w{3,20}$", message = "密碼是3到20個英文.數字._")
    private String password;
    @NotBlank(message = "手機號碼不得為空!")
    @Pattern(regexp = "^09\\d{8}$", message = "必須是手機號碼")
    private String phone;
}

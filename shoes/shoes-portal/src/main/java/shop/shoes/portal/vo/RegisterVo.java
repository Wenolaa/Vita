package shop.shoes.portal.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegisterVo {
    @NotBlank(message = "帳號不得為空!")
    @Pattern(regexp = "^\\w{3,10}$", message = "帳號是3到10個英文.數字._")
    private String username;
    @NotBlank(message = "密碼不得為空!")
    @Pattern(regexp = "^\\w{3,20}$", message = "密碼是3到20個英文.數字._")
    private String password;
    @NotBlank(message = "確認密碼不得為空!")
    private String confirm;
    @NotBlank(message = "信箱不得為空!")
    private String email;
    @NotBlank(message = "生日不得為空!")
    private String birthday;
    @NotBlank(message = "手機號碼不得為空!")
    @Pattern(regexp = "^09\\d{8}$", message = "必須是手機號碼")
    private String phone;
}

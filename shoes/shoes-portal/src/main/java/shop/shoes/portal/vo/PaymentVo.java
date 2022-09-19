package shop.shoes.portal.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class PaymentVo {
    @NotBlank(message = "姓名不得為空!")
    private String username;
    @NotBlank(message = "地址不得為空!")
    private String address;
    @NotBlank(message = "手機號碼不得為空!")
    private String phone;
    @NotBlank(message = "信箱不得為空!")
    private String email;
    @NotBlank(message = "信用卡持卡人不得為空!")
    private String cardName;
    @NotBlank(message = "卡號不得為空!")
    private String cardNumber;
    @NotBlank(message = "卡號不得為空!")
    private String cardNumber1;
    @NotBlank(message = "卡號不得為空!")
    private String cardNumber2;
}

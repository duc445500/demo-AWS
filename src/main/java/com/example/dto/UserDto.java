package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @Min(0)
    @Max(100)
    private int age;
    private String address;

    @Length(min = 9, max = 11,message = "so dien thoai khong hop le (9-11 so) !")
    private String phoneNumber;
}

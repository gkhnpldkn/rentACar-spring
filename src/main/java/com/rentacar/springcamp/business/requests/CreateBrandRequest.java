package com.rentacar.springcamp.business.requests;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBrandRequest {
    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String name;

}

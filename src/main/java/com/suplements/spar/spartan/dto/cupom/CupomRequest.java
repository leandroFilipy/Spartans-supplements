package com.suplements.spar.spartan.dto.cupom;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public record CupomRequest (
        @NotBlank(message = "The code field must not be empty")
        @Length(min = 3, max = 10)
       String codigo,

       @Positive(message = "The discount must be positive")
       @Max(99)
       @Min(1)
       @NotBlank(message = "The discount must not be empty")
       double porcentagemDesconto,
       boolean ativo
){
}

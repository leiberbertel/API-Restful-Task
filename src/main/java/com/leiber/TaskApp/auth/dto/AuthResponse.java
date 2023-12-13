package com.leiber.TaskApp.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    @Schema(description = "token of user", example = "jkfdsbajkdwehdh78wrhdb3uidfsf")
    String token;
}

package com.leiber.TaskApp.persistence.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Schema(description = "user name", example = "john")
    private String username;

    @Schema(description = "user email", example = "john@example.com")
    private String email;

    @Schema(description = "user password", example = "6324673tdyawed")
    private String password;
}

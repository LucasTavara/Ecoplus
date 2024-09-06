package com.app.ecoplus.dto.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public record EmailDto( String email, String nome) {
}
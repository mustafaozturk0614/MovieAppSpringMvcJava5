package com.bilgeadam.dto.response;

import com.bilgeadam.repository.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieAdminPageResponseDto {
    private Long id;
    private  String language;
    private  String name;
    private LocalDate premiered;


}

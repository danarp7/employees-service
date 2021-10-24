package com.employees.interfaces.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitlesRequestDto {

    @NotNull(message = "empNo is mandatory")
    private Integer empNo;

    @NotBlank(message = "title is mandatory")
    private String title;

    @NotNull(message = "fromDate is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

}

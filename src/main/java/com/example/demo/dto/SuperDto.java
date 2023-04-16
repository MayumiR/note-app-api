package com.example.demo.dto;

import com.example.demo.entity.SuperEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public abstract class SuperDto<E extends SuperEntity> {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createdDate;
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "IST")

    public abstract E toEntity();
}

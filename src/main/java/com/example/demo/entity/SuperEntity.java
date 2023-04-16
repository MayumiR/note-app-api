package com.example.demo.entity;

import com.example.demo.dto.SuperDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@Audited
@EntityListeners(AuditingEntityListener.class)
public abstract class SuperEntity<D extends SuperDto> {

    @CreatedDate
    private Date createdDate;

    public abstract D toDto();

    protected void setAuditDetail(D d) {


        d.setCreatedDate(createdDate);

    }

}

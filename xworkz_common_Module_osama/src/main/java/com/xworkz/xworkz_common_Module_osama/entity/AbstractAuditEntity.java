package com.xworkz.xworkz_common_Module_osama.entity;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class AbstractAuditEntity {

    private String createdBy;

    private LocalDateTime createdDate;

    private String updatedBy;

    private LocalDateTime updatedDate;
}

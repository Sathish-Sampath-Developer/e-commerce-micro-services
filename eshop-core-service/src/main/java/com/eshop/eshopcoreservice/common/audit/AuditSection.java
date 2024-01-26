package com.eshop.eshopcoreservice.common.audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Embeddable
public class AuditSection {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATED")
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;

    @Column(name = "CREATE_ID", length = 60)
    private String createdBy;

    @Column(name = "UPDATED_ID", length = 60)
    private String modifiedBy;
}

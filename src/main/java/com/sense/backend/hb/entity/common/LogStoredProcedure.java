package com.sense.backend.hb.entity.common;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Table(name = "LOG_STORED_PROCEDURE")
@Entity
@Data
public class LogStoredProcedure implements Serializable {

    private static final long serialVersionUID = 650659179392385749L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long logId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOG_DT")
    private Date logDt;

    @Column(name = "SP_NAME")
    private String spName;

    @Column(name = "SP_PARAMETER")
    private String spParameter;

    @Column(name = "LOG_MESSAGE")
    private String logMessage;

    @Column(name = "LOG_TYPE")
    private String logType;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.logId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LogStoredProcedure other = (LogStoredProcedure) obj;
        if (!Objects.equals(this.logId, other.logId)) {
            return false;
        }
        return true;
    }

}

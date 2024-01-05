package com.sense.backend.hb.entity.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "CORE_CONFIG")
public class CoreConfig implements Serializable {

    private static final long serialVersionUID = 4082030846151949291L;

    @Id
    @Column(name = "VAR_CODE")
    private String varCode;

    @Column(name = "VAR_VALUE")
    private String varValue;

    @Column(name = "UPDATE_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDt;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name = "ISDELETED")
    private Integer isDeleted;
    
    public CoreConfig() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (varCode != null ? varCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CoreConfig)) {
            return false;
        }
        CoreConfig other = (CoreConfig) object;
        if ((this.varCode == null && other.varCode != null) || (this.varCode != null && !this.varCode.equals(other.varCode))) {
            return false;
        }
        return true;
    }

}

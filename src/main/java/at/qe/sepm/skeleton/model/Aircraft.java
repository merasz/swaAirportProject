package at.qe.sepm.skeleton.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.domain.Persistable;


/**
 *
 * Entity representing an aircraft
 */

@Entity
public class Aircraft implements Persistable<String>, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length =100)
	private String aircraftId;

	@ManyToOne(optional = false)
	private Aircraft createAircraft;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@ManyToOne(optional = true)
	private Aircraft updateAircraft;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	private String aircraftType;
	private int requiredPilotsAircraft;
	private int requiredBoardpersonalAircraft;
	private int capacityAircraft;
	


	public String getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(String aircraftId) {
		this.aircraftId = aircraftId;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public int getRequiredPilotsAircraft() {
		return requiredPilotsAircraft;
	}

	public void setRequiredPilotsAircraft(int requiredPilotsAircraft) {
		this.requiredPilotsAircraft = requiredPilotsAircraft;
	}

	public int getRequiredBoardpersonalAircraft() {
		return requiredBoardpersonalAircraft;
	}

	public void setRequiredBoardpersonalAircraft(int requiredBoardpersonalAircraft) {
		this.requiredBoardpersonalAircraft = requiredBoardpersonalAircraft;
	}

	public int getCapacityAircraft() {
		return capacityAircraft;
	}

	public void setCapacityAircraft(int capacityAircraft) {
		this.capacityAircraft = capacityAircraft;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Aircraft getUpdateAircraft() {
		return updateAircraft;
	}

	public void setUpdateAircraft(Aircraft updateAircraft) {
		this.updateAircraft = updateAircraft;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Aircraft getCreateAircraft() {
		return createAircraft;
	}

	public void setCreateAircraft(Aircraft createAircraft) {
		this.createAircraft = createAircraft;
	}

	@Override
	public String toString() {
		return "at.qe.sepm.skeleton.model.Aircraft[ id=" + aircraftId + " ]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Aircraft)) {
			return false;
		}
		final Aircraft other = (Aircraft) obj;
		if (!Objects.equals(this.aircraftId, other.aircraftId)) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		return java.util.Objects.hash(super.hashCode(), aircraftId, aircraftType, requiredPilotsAircraft, requiredBoardpersonalAircraft, capacityAircraft);
	}


	@Override
	public String getId() {
		return getAircraftId();
	}

	public void setId(String id) {
		setAircraftId(id);
	}

	@Override
	public boolean isNew() {
		return (null == createDate);
	}
}

package at.qe.sepm.skeleton.model;

public class Aircraft {
	private int aircraftId;
	private String aircraftType;
	private int requiredPilotsAircraft;
	private int requiredBoardpersonalAircraft;
	private int capacityAircraft;
	
	public Aircraft(String aircraftType, int requiredPilotsAircraft, int requiredBoardpersonalAircraft, int capacityAircraft) {
		this.aircraftType = aircraftType;
		this.requiredPilotsAircraft = requiredPilotsAircraft;
		this.requiredBoardpersonalAircraft = requiredBoardpersonalAircraft;
		this.capacityAircraft = capacityAircraft;
	}

	public int getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(int aircraftId) {
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
	
	
	
	
}

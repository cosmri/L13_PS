package sg.edu.rp.c346.id21001096.l13_ps;

public class Carpark {
    private String totalLots;
    private String lotType;
    private String lotsAvailble;
    private String carparkNumber;
    private String updatedTime;

    public Carpark(String totalLots, String lotType, String lotsAvailble, String carparkNumber, String updatedTime) {
        this.totalLots = totalLots;
        this.lotType = lotType;
        this.lotsAvailble = lotsAvailble;
        this.carparkNumber = carparkNumber;
        this.updatedTime = updatedTime;
    }

    public String getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(String totalLots) {
        this.totalLots = totalLots;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public String getLotsAvailble() {
        return lotsAvailble;
    }

    public void setLotsAvailble(String lotsAvailble) {
        this.lotsAvailble = lotsAvailble;
    }

    public String getCarparkNumber() {
        return carparkNumber;
    }

    public void setCarparkNumber(String carparkNumber) {
        this.carparkNumber = carparkNumber;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Carpark\n" +
                "Carpark Number= " + carparkNumber + '\n' +
                "Updated Time= " + updatedTime + '\n' +
                "Total Lots= " + totalLots + '\n' +
                "Lot Type= " + lotType + '\n' +
                "Lots Availble= " + lotsAvailble + '\n';
    }
}

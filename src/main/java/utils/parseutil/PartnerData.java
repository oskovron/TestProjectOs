package utils.parseutil;

public class PartnerData {
    private String comparingPeriods;
    private String partnerName;
    private String locationName;
    private String earnedMoney;
    private String usedKW;
    private String parsingDateTime;

    public PartnerData(String comparingPeriods, String partnerName, String locationName, String earnedMoney,
                       String usedKW, String parsingDateTime) {
        this.comparingPeriods = comparingPeriods;
        this.partnerName = partnerName;
        this.locationName = locationName;
        this.earnedMoney = earnedMoney;
        this.usedKW = usedKW;
        this.parsingDateTime = parsingDateTime;
    }

    public String getComparingPeriods() {
        return comparingPeriods;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getEarnedMoney() {
        return earnedMoney;
    }

    public String getUsedKW() {
        return usedKW;
    }

    public String getParsingDateTime() {
        return parsingDateTime;
    }

}

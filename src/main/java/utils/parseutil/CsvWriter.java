package utils.parseutil;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    public static void saveToCSV(PartnerData partnerData) throws IOException {
        try (FileWriter writer = new FileWriter("partner_data.csv", true)) {
            writer.append(String.join(";", partnerData.getComparingPeriods(), partnerData.getPartnerName(),
                    partnerData.getLocationName(), partnerData.getEarnedMoney(), partnerData.getUsedKW(),
                    partnerData.getParsingDateTime()));
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

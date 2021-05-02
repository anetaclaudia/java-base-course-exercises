package ee.taltech.iti0200.greenhouse.plantingstrategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PlantInColumns implements PlantingStrategy {

    @Override
    public String[][] plantPlants(int length, int width, Map<String, Integer> plants) {
        String[][] field = new String[length][width];
        Map<String, Integer> sortedPlants = sortedPlants(plants);
        int columnCount = 0, rowCount = 0, plantedCount = 0;

        for (Map.Entry<String, Integer> entry : sortedPlants.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                field[columnCount][rowCount] = entry.getKey();
                columnCount++;
                plantedCount++;
                if (columnCount == length) {
                    columnCount = 0;
                    rowCount++;
                }
                if (plantedCount == (length * width)) {
                    return field;
                }
            }
        }

        return field;
    }

    @Override
    public Map<String, Integer> sortedPlants(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}

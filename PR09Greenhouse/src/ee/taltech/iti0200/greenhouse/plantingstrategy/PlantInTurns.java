package ee.taltech.iti0200.greenhouse.plantingstrategy;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PlantInTurns implements PlantingStrategy {

    @Override
    public String[][] plantPlants(int length, int width, Map<String, Integer> plants) {
        String[][] field = new String[length][width];
        Map<String, Integer> sortedPlants = sortedPlants(plants);
        int plantedCount = 0, row = 0, col = 0;
        while (plantedCount < (length * width)) {
            for (Map.Entry<String, Integer> entry : sortedPlants.entrySet()) {
                if (!(entry.getValue() == 0)) {
                    plantedCount++;
                    field[row][col] = entry.getKey();
                    sortedPlants.replace(entry.getKey(), entry.getValue() - 1);
                    col++;
                    if (col == width) {
                        col = 0;
                        row++;
                    }
                    if (plantedCount == (length * width)) {
                        return field;
                    }
                }
            }
        }
        return field;
    }

    @Override
    public Map<String, Integer> sortedPlants(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}

package ee.taltech.iti0200.greenhouse;

import ee.taltech.iti0200.greenhouse.gardener.Gardener;
import ee.taltech.iti0200.greenhouse.plantingstrategy.PlantInColumns;
import ee.taltech.iti0200.greenhouse.plantingstrategy.PlantInRows;
import ee.taltech.iti0200.greenhouse.plantingstrategy.PlantInTurns;
import ee.taltech.iti0200.greenhouse.plantingstrategy.PlantingStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Greenhouse {

    public static void main(String[] args) {
        PlantingStrategy strategy1 = new PlantInTurns();
        PlantingStrategy strategy2 = new PlantInRows();
        PlantingStrategy strategy3 = new PlantInColumns();

        Gardener gardener = new Gardener("Clara", strategy1);

        Map<String, Integer> plants = new HashMap<>();
        plants.put("tomato", 2);
        plants.put("dill", 3);
        plants.put("rosemary", 2);

        String[][] plantedPlants = gardener.plantPlants(3, 4, plants);

        System.out.println(Arrays.stream(plantedPlants).
                map(x -> String.join(",", x))
                .collect(Collectors.joining("\n"))
        );
        Map<String, Integer> test = Map.ofEntries(
                Map.entry("rosmariin", 1),
                Map.entry("petersell", 3),
                Map.entry("tomat", 2)
        );
        String[][] x = strategy1.plantPlants(2, 3, test);
        System.out.println(Arrays.stream(x).
                map(e -> String.join(",", e))
                .collect(Collectors.joining("\n"))
        );
    }

//    Output:
//    tomato,dill,rosemary,tomato
//    dill,rosemary,tomato,dill
//    tomato,tomato,tomato,tomato
}

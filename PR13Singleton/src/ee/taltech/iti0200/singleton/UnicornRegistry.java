package ee.taltech.iti0200.singleton;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class UnicornRegistry {
    Map<Unicorn, UnicornObserver> discoveredUnicorns = new LinkedHashMap<>();
    private static UnicornRegistry instance = null;

    private UnicornRegistry() {
    }

    public static UnicornRegistry getInstance() {
        if (instance == null) {
            instance = new UnicornRegistry();
        }
        return instance;
    }

    public void registerUnicorn(Unicorn unicorn, UnicornObserver discoverer) {
        if (!discoveredUnicorns.containsKey(unicorn)) {
            discoveredUnicorns.put(unicorn, discoverer);
        }
    }

    public Set<Unicorn> getAllDiscoveredUnicorns() {
        return discoveredUnicorns.keySet();
    }

    public int getUnicornRarityIndex(Unicorn unicorn) {
        Set<Unicorn> unicorns = discoveredUnicorns.keySet();
        if (!unicorns.contains(unicorn)) {
            return 0;
        }
        List<Unicorn> sorted = unicorns.stream()
                .sorted(Comparator.comparing(Unicorn::getLocation)
                        .thenComparing(Unicorn::getColor)
                        .thenComparing(Unicorn::getHornLength)
                        .thenComparing(Unicorn::getSize)).collect(Collectors.toList());
        return sorted.indexOf(unicorn) + 1;
    }

    public Set<Unicorn> getUnicornsDiscoveredBy(UnicornObserver observer) {
        Set<Unicorn> unicorns = new HashSet<>();
        for (Map.Entry<Unicorn, UnicornObserver> entry : discoveredUnicorns.entrySet()) {
            if (entry.getValue().equals(observer)) {
                unicorns.add(entry.getKey());
            }
        }
        return unicorns;
    }

    public void forgetAllUnicorns() {
        discoveredUnicorns = new LinkedHashMap<>();
    }
}

package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> itemsOnPlanet = planet.getItems();
        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && !itemsOnPlanet.isEmpty()) {
                astronaut.breath();
                String foundItem = itemsOnPlanet.iterator().next();
                astronaut.getBag().getItems().add(foundItem);
                itemsOnPlanet.remove(foundItem);
            }

        }

    }
}

package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;

    public ControllerImpl() {
        this.planetRepository = new PlanetRepository();
        this.astronautRepository = new AstronautRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type){
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        this.astronautRepository.add(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_ADDED,type,astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        Collection<String> planetItems = planet.getItems();
        Collections.addAll(planetItems, items);
        this.planetRepository.add(planet);
        return String.format(PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut removedAstronaut = this.astronautRepository.findByName(astronautName);

        if(removedAstronaut == null){
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST,astronautName));
        }
        this.astronautRepository.remove(removedAstronaut);

        return String.format(ASTRONAUT_RETIRED,astronautName);
    }

    private int exploredPlanetsCount = 0;

    @Override
    public String explorePlanet(String planetName) {

        Planet planet = this.planetRepository.findByName(planetName);
        List<Astronaut> astronauts = this.astronautRepository.getModels().stream().filter(e -> e.getOxygen()>60).collect(Collectors.toList());

        if(astronauts.isEmpty()){
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(planet,astronauts);

        exploredPlanetsCount++;
        long deadAstronautsCount = astronauts.stream().filter(e -> e.getOxygen() == 0).count();

        return String.format(PLANET_EXPLORED,planetName,deadAstronautsCount) ;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED,this.exploredPlanetsCount))
                .append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());

        Collection<Astronaut> astronauts = this.astronautRepository.getModels();

        for (Astronaut astronaut: astronauts){
            sb.append(String.format(REPORT_ASTRONAUT_NAME,astronaut.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(REPORT_ASTRONAUT_OXYGEN,astronaut.getOxygen()))
                    .append(System.lineSeparator());

            String items = "none";
            if(!astronaut.getBag().getItems().isEmpty()){
                items= String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems());
            }

            sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,items))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}

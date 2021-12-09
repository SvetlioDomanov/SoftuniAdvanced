package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        Collection<String> stateExhibits = state.getExhibits();
        Collections.addAll(stateExhibits, exhibits);
        stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    private int statesExploredCount = 0;

    @Override
    public String exploreState(String stateName) {
        State state = this.stateRepository.byName(stateName);
        List<Explorer> explorers = this.explorerRepository.getCollection().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(state, explorers);

        long retiredExplorers = explorers.stream().filter(e -> e.getEnergy() == 0).count();
        this.statesExploredCount++;
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_STATE_EXPLORED, this.statesExploredCount))
                .append(System.lineSeparator())
                .append(FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());

        Collection<Explorer> explorers = this.explorerRepository.getCollection();
        for (Explorer explorer : explorers) {
            sb.append(String.format(FINAL_EXPLORER_NAME, explorer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy()))
                    .append(System.lineSeparator());

            Collection<String> exhibits = explorer.getSuitcase().getExhibits();
            String exhibitsString = "None";
            if (!exhibits.isEmpty()) {
                exhibitsString = String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, exhibits);
            }
            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, exhibitsString));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

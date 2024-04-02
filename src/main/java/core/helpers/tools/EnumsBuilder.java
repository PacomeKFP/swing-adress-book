package core.helpers.tools;

import core.helpers.enums.ChampRechercheEnum;
import core.helpers.enums.CycleEnum;
import core.helpers.enums.StatutAgentEnum;
import core.helpers.enums.StatutEnseignantEnum;

import java.util.Arrays;

public class EnumsBuilder {


    public static CycleEnum cycleEnumFromString(String value) {
        return Arrays.stream(CycleEnum.values())
                .filter(cycleEnum -> cycleEnum.name().equals(value))
                .limit(1)
                .toList()
                .getFirst();
    }
    
    public static ChampRechercheEnum champRechercheEnumFromString(String value) {
        return Arrays.stream(ChampRechercheEnum.values())
                .filter(champRechercheEnum -> champRechercheEnum.name().equals(value))
                .limit(1)
                .toList()
                .getFirst();
    }
    public static StatutAgentEnum statutAgentEnumFromString(String value) {
        return Arrays.stream(StatutAgentEnum.values())
                .filter(statutAgentEnum -> statutAgentEnum.name().equals(value))
                .limit(1)
                .toList()
                .getFirst();
    }

    public static StatutEnseignantEnum statutEnseignantEnumFromString(String value) {
        return Arrays.stream(StatutEnseignantEnum.values())
                .filter(statutEnseignantEnum -> statutEnseignantEnum.name().equals(value))
                .limit(1)
                .toList()
                .getFirst();
    }
}

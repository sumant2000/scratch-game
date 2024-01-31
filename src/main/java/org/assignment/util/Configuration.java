package org.assignment.util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.assignment.model.Symbol;
import org.assignment.model.WinCombination;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private Map<String, Symbol> symbols;
    private Map<String, WinCombination> winCombinations;
    // other fields like columns, rows, etc.

    public Configuration() throws IOException {
        Gson gson = new Gson();
        // Assuming the config.json is in the src/main/resources directory
        try (FileReader reader = new FileReader("src/main/resources/config.json")) {
            // Parse the entire JSON into a suitable Java object
            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            Map<String, Object> config = gson.fromJson(reader, type);

            this.symbols = extractSymbols(config);
            this.winCombinations = extractWinCombinations(config);
        }
    }

    private Map<String, Symbol> extractSymbols(Map<String, Object> config) {
        Map<String, Symbol> symbolsMap = new HashMap<>();
        Gson gson = new Gson();

        Map<String, Object> symbolsJson = (Map<String, Object>) config.get("symbols");
        if (symbolsJson != null) {
            for (Map.Entry<String, Object> entry : symbolsJson.entrySet()) {
                String symbolName = entry.getKey();
                Symbol symbol = gson.fromJson(gson.toJson(entry.getValue()), Symbol.class);
                symbolsMap.put(symbolName, symbol);
            }
        }

        return symbolsMap;
    }


    private Map<String, WinCombination> extractWinCombinations(Map<String, Object> config) {
        Map<String, WinCombination> winCombinationsMap = new HashMap<>();
        Gson gson = new Gson();

        Map<String, Object> winCombinationsJson = (Map<String, Object>) config.get("win_combinations");
        if (winCombinationsJson != null) {
            for (Map.Entry<String, Object> entry : winCombinationsJson.entrySet()) {
                String combinationName = entry.getKey();
                WinCombination winCombination = gson.fromJson(gson.toJson(entry.getValue()), WinCombination.class);
                winCombinationsMap.put(combinationName, winCombination);
            }
        }

        return winCombinationsMap;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(Map<String, Symbol> symbols) {
        this.symbols = symbols;
    }

    public Map<String, WinCombination> getWinCombinations() {
        return winCombinations;
    }

    public void setWinCombinations(Map<String, WinCombination> winCombinations) {
        this.winCombinations = winCombinations;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeFinder {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();

        // Create a map to store the ingredient to index mapping
        Map<String, Integer> ingredientIndexMap = new HashMap<>();
        for (int i = 0; i < supplies.length; i++) {
            ingredientIndexMap.put(supplies[i], i);
        }

        // Create a graph to represent the dependencies between ingredients
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph by adding edges based on the ingredient dependencies
        for (int i = 0; i < ingredients.size(); i++) {
            List<String> recipeIngredients = ingredients.get(i);
            int recipeIndex = supplies.length + i;
            for (String ingredient : recipeIngredients) {
                if (!ingredientIndexMap.containsKey(ingredient)) {
                    ingredientIndexMap.put(ingredient, supplies.length + graph.size());
                    graph.add(new ArrayList<>());
                }
                int ingredientIndex = ingredientIndexMap.get(ingredient);
                graph.get(ingredientIndex - supplies.length).add(recipeIndex);
            }
        }

        // Find all possible recipes using DFS
        List<String> currentRecipe = new ArrayList<>();
        boolean[] visited = new boolean[recipes.length];
        for (int i = 0; i < recipes.length; i++) {
            if (!visited[i]) {
                dfs(graph, i, currentRecipe, visited, result, recipes);
            }
        }

        return result;
    }

    private void dfs(List<List<Integer>> graph, int recipeIndex, List<String> currentRecipe,
                     boolean[] visited, List<String> result, String[] recipes) {
        visited[recipeIndex] = true;
        currentRecipe.add(recipes[recipeIndex]);

        if (graph.size() > recipeIndex && graph.get(recipeIndex).isEmpty()) {
            result.add(String.join(" ", currentRecipe));
        } else {
            for (int nextRecipe : graph.get(recipeIndex)) {
                dfs(graph, nextRecipe, currentRecipe, visited, result, recipes);
            }
        }

        currentRecipe.remove(currentRecipe.size() - 1);
    }
}

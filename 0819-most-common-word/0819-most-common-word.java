class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(List.of(banned));

        Map<String, Integer> counts = new HashMap<>();

        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String word : words) {
            if (!bannedSet.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }


		return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();

    }
}
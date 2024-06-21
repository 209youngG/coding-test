class Solution {
    public String[] reorderLogFiles(String[] logs) {
     ArrayList<String> stringLogs = new ArrayList<>();
		ArrayList<String> intLogs = new ArrayList<>();

		for (String log : logs) {
			addIfMatchStringOrInt(log, stringLogs, intLogs);
		}

		stringLogs.sort((o1, o2) -> comparedStringAndLogId(o1, o2));
		stringLogs.addAll(intLogs);
		return stringLogs.toArray(String[]::new);
	}

	private void addIfMatchStringOrInt(String log, ArrayList<String> stringLogs, ArrayList<String> intLogs) {
		if (log.split(" ")[1].chars().allMatch(Character::isDigit)) {
			intLogs.add(log);
		} else {
			stringLogs.add(log);
		}
	}

	private int comparedStringAndLogId(String o1, String o2) {
		String[] split1 = o1.split(" ", 2);
		String[] split2 = o2.split(" ", 2);
		int compared = split1[1].compareTo(split2[1]);
		if (compared == 0) {
			return split1[0].compareTo(split2[0]);
		}
		return compared;
	}
}
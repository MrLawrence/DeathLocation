package mrlawrence.bukkit.deathlocation.formatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MsgReplacer {
	public String replace(String string, Map<String, String> replacements) {
		Map<String, String> oldSubstrings = new HashMap<String, String>();
		List<String> newSubstrings = new ArrayList<String>();

		Integer i = 1;
		for (Entry<String, String> entry : replacements.entrySet()) {
			oldSubstrings.put(entry.getKey(), "%" + i + "$s");
			newSubstrings.add(entry.getValue());
			i++;
		}

		String prepared = string;
		for (Entry<String, String> entry : oldSubstrings.entrySet()) {
			prepared = prepared.replace(entry.getKey(), entry.getValue());
		}

		return String.format(prepared, newSubstrings.toArray());
	}
}

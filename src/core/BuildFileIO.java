package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EnumMap;
import java.util.Map;

public class BuildFileIO {

	private BuildFileIO() {

	}

	public static void exportBuildFile(BuildState state, File file) throws IOException {
		try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
			out.println("# Fallout 4 Planner Build");
			out.println("# " + file.getName());
			out.println("Survival=" + state.survival);

			out.println();
			out.println("[SPECIAL]");
			for (Attribute special : state.specialLevels) {
				out.println(special.getStat().name() + "=" + special.getLevelString());
			}

			out.println();
			out.println("[PERKS]");
			for (Map.Entry<Perk, Integer> perk : state.perkLevels.entrySet()) {
				if (perk.getValue() > 0) {
					out.println(perk.getKey().name() + "=" + perk.getValue());
				}
			}

			out.println();
			out.println("[BOBBLEHEADS]");
			for (Map.Entry<SPECIAL, Boolean> bobblehead : state.bobbleheads.entrySet()) {
				out.println(bobblehead.getKey().name() + "=" + bobblehead.getValue());
			}
			
			out.println();
			out.println("[TECH]");
			out.println("remaining=" + state.remaining);
			out.println("pointsUsed=" + state.pointsUsed);
			out.println("specialBook=" + state.specialBook);
		}
	}

	public static BuildState importBuildFile(File file) throws NumberFormatException, IOException {
		BuildState state = new BuildState();
		state.specialLevels = new Attribute[7];
		state.perkLevels = new EnumMap<Perk, Integer>(Perk.class);
		state.bobbleheads = new EnumMap<SPECIAL, Boolean>(SPECIAL.class);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String section = "";
			String line = br.readLine();
			if (!line.equals("# Fallout 4 Planner Build")) {
				return null;
			}

			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.isEmpty() || line.startsWith("#")) {
					continue;
				}
				if (line.startsWith("[")) {
					section = line.substring(1, line.length() - 1);
					continue;
				}
				String[] parts = line.split("=", 2);
				if (parts.length < 2) {
					continue;
				}
				String key = parts[0].trim();
				String value = parts[1].trim();

				switch (section) {
				case "":
					if (key.equalsIgnoreCase("Survival")) {
						state.survival = Boolean.parseBoolean(value);
					}
					break;
				case "SPECIAL":
					SPECIAL spe = SPECIAL.valueOf(key);
					int[] lev = parseAttributeString(value);
					if (lev != null) {
						state.specialLevels[spe.ordinal()] = new Attribute(spe, lev[0], lev[1]);
					}
					break;
				case "PERKS":
					state.perkLevels.put(Perk.valueOf(key), Integer.parseInt(value));
					break;
				case "BOBBLEHEADS":
					state.bobbleheads.put(SPECIAL.valueOf(key), Boolean.parseBoolean(value));
					break;
				case "TECH":
					switch (key) {
					case "remaining":
						state.remaining = Integer.parseInt(value);
						break;
					case "pointsUsed":
						state.pointsUsed = Integer.parseInt(value);
						break;
					case "specialBook":
						state.specialBook = Boolean.parseBoolean(value);
						break;
					}
					break;
				}
			}
		}
		return state;
	}

	public static int[] parseAttributeString(String input) {
		try {
			String[] parts = input.split("[()]");
			if (parts.length != 2) {
				return null;
			}
			return new int[] { Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) };
		} catch (Exception e) {
			return null;
		}
	}

}

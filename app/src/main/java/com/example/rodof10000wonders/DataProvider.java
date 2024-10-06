package com.example.rodof10000wonders;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class DataProvider {
    private static String[] effects;
    private static String[] normalRodEffects; // For the second file
    private static Random random = new Random();

    // Load effects from the effects.txt file
    public static void loadEffects(Context context) {
        effects = loadFile(context, "effects.txt");
    }

    // Load normal rod effects from the normal_rod.txt file
    public static void loadNormalRodEffects(Context context) {
        normalRodEffects = loadFile(context, "normal_rod.txt");
    }

    // Helper method to read from a file
    private static String[] loadFile(Context context, String filename) {
        String[] lines = new String[10000];
        try {
            InputStream is = context.getAssets().open(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            // Read each line and populate the array
            for (int i = 0; i < lines.length; i++) {
                lines[i] = reader.readLine();  // Read line by line
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // Method to get a random effect from the first array
    public static String getRandomEffect() {
        if (effects != null) {
            return effects[random.nextInt(effects.length)];
        } else {
            return "Effects not loaded.";
        }
    }

    public static String getNormalRodEffect() {
        int roll = random.nextInt(100) + 1; // Roll a d100 (1 to 100)

        if (roll >= 1 && roll <= 5) {
            return "Target affected by slow for 10 rounds (Will DC 15 negates).";
        } else if (roll >= 6 && roll <= 10) {
            return "Faerie fire surrounds the target.";
        } else if (roll >= 11 && roll <= 15) {
            return "Deludes the wielder for 1 round into believing the rod functions as indicated by a second die roll (no save).";
        } else if (roll >= 16 && roll <= 20) {
            return "Gust of wind, but at windstorm force (Fortitude DC 14 negates).";
        } else if (roll >= 21 && roll <= 25) {
            return "Wielder learns the target’s surface thoughts (as with detect thoughts) for 1d4 rounds (no save).";
        } else if (roll >= 26 && roll <= 30) {
            return "Stinking cloud appears at 30-foot range (Fortitude DC 15 negates).";
        } else if (roll >= 31 && roll <= 33) {
            return "Heavy rain falls for 1 round in 60-foot radius centered on the rod wielder.";
        } else if (roll >= 34 && roll <= 36) {
            return "Summons an animal—a rhino (01—25 on d%), elephant (26—50), or mouse (51—100).";
        } else if (roll >= 37 && roll <= 46) {
            return "Lightning bolt (70 foot long, 5 foot wide), 6d6 points of damage (Reflex DC 15 half).";
        } else if (roll >= 47 && roll <= 49) {
            return "A stream of 600 large butterflies pours forth and flutters around for 2 rounds, blinding everyone within 25 foot (Reflex DC 14 negates).";
        } else if (roll >= 50 && roll <= 53) {
            return "Target is affected by enlarge person if within 60 feet of rod (Fortitude DC 13 negates).";
        } else if (roll >= 54 && roll <= 58) {
            return "Darkness, 30-foot-diameter hemisphere, centered 30 feet away from rod.";
        } else if (roll >= 59 && roll <= 62) {
            return "Grass grows in 160-square-foot area before the rod, or grass existing there grows to 10 times its normal size.";
        } else if (roll >= 63 && roll <= 65) {
            return "Any nonliving object of up to 1,000 pounds of mass and up to 30 cubic feet in size turns ethereal.";
        } else if (roll >= 66 && roll <= 69) {
            return "Reduce wielder two size categories (no save) for 1 day.";
        } else if (roll >= 70 && roll <= 79) {
            return "Fireball at target or 100 feet straight ahead, 6d6 points of damage (Reflex DC 15 half).";
        } else if (roll >= 80 && roll <= 84) {
            return "Invisibility covers the rod’s wielder.";
        } else if (roll >= 85 && roll <= 87) {
            return "Leaves grow from the target if within 60 feet of the rod. These last 24 hours.";
        } else if (roll >= 88 && roll <= 90) {
            return "10—40 gems, value 1 gp each, shoot forth in a 30-foot-long stream. Each gem deals 1 point of damage to any creature in its path: roll 5d4 for the number of hits and divide them among the available targets.";
        } else if (roll >= 91 && roll <= 95) {
            return "Shimmering colors dance and play over a 40-foot-by-30-foot area in front of rod. Creatures therein are blinded for 1d6 rounds (Fortitude DC 15 negates).";
        } else if (roll >= 96 && roll <= 97) {
            return "Wielder (50% chance) or the target (50% chance) turns permanently blue, green, or purple (no save).";
        } else {
            return "Flesh to stone (or stone to flesh if the target is stone already) if the target is within 60 feet (Fortitude DC 18 negates).";
        }
    }
}

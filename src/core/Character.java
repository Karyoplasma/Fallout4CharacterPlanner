package core;

import java.util.Collections;
import java.util.HashMap;

public class Character{
	public Attribute[] special = new Attribute[7];
	public Perk[] perks = new Perk[70];
	public int remaining;
	public int pointsUsed;
	public HashMap<String, Integer> perkLevel = new HashMap<String, Integer>();
	
	public Character(){
		this.remaining = 22;
		this.perkLevel.put("Base", 1);
		this.pointsUsed = 0;
		this.special[0] = new Attribute(Stat.Strength, 1);
		this.special[1] = new Attribute(Stat.Perception, 1);
		this.special[2] = new Attribute(Stat.Endurance, 1);
		this.special[3] = new Attribute(Stat.Charisma, 1);
		this.special[4] = new Attribute(Stat.Intelligence, 1);
		this.special[5] = new Attribute(Stat.Agility, 1);
		this.special[6] = new Attribute(Stat.Luck, 1);
		this.perks[0] = new Perk(PerkList.IronFist, 0);
		this.perks[1] = new Perk(PerkList.BigLeagues, 0);
		this.perks[2] = new Perk(PerkList.Armorer, 0);
		this.perks[3] = new Perk(PerkList.Blacksmith, 0);
		this.perks[4] = new Perk(PerkList.HeavyGunner, 0);
		this.perks[5] = new Perk(PerkList.StrongBack, 0);
		this.perks[6] = new Perk(PerkList.SteadyAim, 0);
		this.perks[7] = new Perk(PerkList.Basher, 0);
		this.perks[8] = new Perk(PerkList.Rooted, 0);
		this.perks[9] = new Perk(PerkList.PainTrain, 0);
		this.perks[10] = new Perk(PerkList.Pickpocket, 0);
		this.perks[11] = new Perk(PerkList.Rifleman, 0);
		this.perks[12] = new Perk(PerkList.Awareness, 0);
		this.perks[13] = new Perk(PerkList.Locksmith, 0);
		this.perks[14] = new Perk(PerkList.DemolitionExpert, 0);
		this.perks[15] = new Perk(PerkList.NightPerson, 0);
		this.perks[16] = new Perk(PerkList.Refractor, 0);
		this.perks[17] = new Perk(PerkList.Sniper, 0);
		this.perks[18] = new Perk(PerkList.Penetrator, 0);
		this.perks[19] = new Perk(PerkList.ConcentratedFire, 0);
		this.perks[20] = new Perk(PerkList.Toughness, 0);
		this.perks[21] = new Perk(PerkList.LeadBelly, 0);
		this.perks[22] = new Perk(PerkList.Lifegiver, 0);
		this.perks[23] = new Perk(PerkList.ChemResistant, 0);
		this.perks[24] = new Perk(PerkList.Aquaboy, 0);
		this.perks[25] = new Perk(PerkList.RadResistant, 0);
		this.perks[26] = new Perk(PerkList.AdamantiumSkeleton, 0);
		this.perks[27] = new Perk(PerkList.Cannibal, 0);
		this.perks[28] = new Perk(PerkList.Ghoulish, 0);
		this.perks[29] = new Perk(PerkList.SolarPowered, 0);
		this.perks[30] = new Perk(PerkList.CapCollector, 0);
		this.perks[31] = new Perk(PerkList.LadyKiller, 0);
		this.perks[32] = new Perk(PerkList.LoneWanderer, 0);
		this.perks[33] = new Perk(PerkList.AttackDog, 0);
		this.perks[34] = new Perk(PerkList.AnimalFriend, 0);
		this.perks[35] = new Perk(PerkList.LocalLeader, 0);
		this.perks[36] = new Perk(PerkList.PartyBoy, 0);
		this.perks[37] = new Perk(PerkList.Inspirational, 0);
		this.perks[38] = new Perk(PerkList.WastelandWhisperer, 0);
		this.perks[39] = new Perk(PerkList.Intimidation, 0);
		this.perks[40] = new Perk(PerkList.Vans, 0);
		this.perks[41] = new Perk(PerkList.Medic, 0);
		this.perks[42] = new Perk(PerkList.GunNut, 0);
		this.perks[43] = new Perk(PerkList.Hacker, 0);
		this.perks[44] = new Perk(PerkList.Scrapper, 0);
		this.perks[45] = new Perk(PerkList.Science, 0);
		this.perks[46] = new Perk(PerkList.Chemist, 0);
		this.perks[47] = new Perk(PerkList.RoboticsExpert, 0);
		this.perks[48] = new Perk(PerkList.NuclearPhysicist, 0);
		this.perks[49] = new Perk(PerkList.NerdRage, 0);
		this.perks[50] = new Perk(PerkList.Gunslinger, 0);
		this.perks[51] = new Perk(PerkList.Commando, 0);
		this.perks[52] = new Perk(PerkList.Sneak, 0);
		this.perks[53] = new Perk(PerkList.MisterSandman, 0);
		this.perks[54] = new Perk(PerkList.ActionBoy, 0);
		this.perks[55] = new Perk(PerkList.MovingTarget, 0);
		this.perks[56] = new Perk(PerkList.Ninja, 0);
		this.perks[57] = new Perk(PerkList.QuickHands, 0);
		this.perks[58] = new Perk(PerkList.Blitz, 0);
		this.perks[59] = new Perk(PerkList.GunFu, 0);
		this.perks[60] = new Perk(PerkList.FortuneFinder, 0);
		this.perks[61] = new Perk(PerkList.Scrounger, 0);
		this.perks[62] = new Perk(PerkList.BloodyMess, 0);
		this.perks[63] = new Perk(PerkList.MysteriousStranger, 0);
		this.perks[64] = new Perk(PerkList.IdiotSavant, 0);
		this.perks[65] = new Perk(PerkList.BetterCriticals, 0);
		this.perks[66] = new Perk(PerkList.CriticalBanker, 0);
		this.perks[67] = new Perk(PerkList.GrimReapersSprint, 0);
		this.perks[68] = new Perk(PerkList.FourLeafClover, 0);
		this.perks[69] = new Perk(PerkList.Ricochet, 0);
	}
	
	public void changeAttribute(int i, boolean levelUp){
		if (levelUp) {
			if (this.special[i].getMaxLevel() > this.special[i].getAttributeLevel()) {
				this.special[i].skillAttribute();
				this.remaining--;
				if (this.remaining < 0){
					this.pointsUsed++;
				}
			}
		}
		else {
			if (this.special[i].getMinLevel() < this.special[i].getAttributeLevel()) {
				this.special[i].unskillAttribute();
				if (this.remaining < 0){
					this.pointsUsed--;
				}
				
				this.remaining++;
			}		 
		}
	}
	
	public void skillPerk(int perk){
		int statLvlIndex = (perk / 10) % 10;
		int i = this.perks[perk].levelPerk(this.special[statLvlIndex].getAttributeLevel());
		if (i == -1){
			return;
		} else {
			this.pointsUsed++;
			String key = this.perks[perk].perk.getName() + this.perks[perk].level;
			this.perkLevel.put(key, i);
		}
	}
	
	public void unskillPerk(int perk){
		int i = this.perks[perk].unlevelPerk();
		if (i == -1){
			return;
		} else {
			this.pointsUsed--;
			String key = this.perks[perk].perk.getName() + (this.perks[perk].level + 1);
			this.perkLevel.remove(key);
		}
	}
	
	public void setBobblehead(int i, boolean active){
		if (active){
			this.special[i].addBobblehead();
		} else {
			this.special[i].removeBobblehead();
		}
	}
	
	public void setSpecialBook(boolean active){
		if (active){
			this.remaining++;
		} else {
			this.remaining--;
		}
	}
	
	public String getCarryWeight(boolean survival){
		int carryWeight;
		int perkModifier = 0;
		if (this.perks[5].level == 1){
			perkModifier += 25;
		}
		if (this.perks[5].level >= 2){
			perkModifier += 50;
		}
		if (this.perks[32].level == 1){
			perkModifier += 50;
		}
		if (this.perks[32].level >= 2){
			perkModifier += 100;
		}
		if (survival) {
			carryWeight = 75 + perkModifier + (10 *(this.special[0].getAttributeLevel()));
		} else {
			carryWeight = 200 + perkModifier + (10 *(this.special[0].getAttributeLevel()));
		}
		return String.valueOf(carryWeight);
	}
	
	public String getHitPoints(){
		int perkModifier = 0;
		if (this.perks[22].level == 1){
			perkModifier += 20;
		}
		if (this.perks[22].level == 2){
			perkModifier += 40;
		}
		if (this.perks[22].level == 3){
			perkModifier += 60;
		}
		int level = Math.max(this.getPerkLevel(), this.pointsUsed + 1);
		double hitPoints = Math.floor(80 + perkModifier + (this.special[2].getAttributeLevel() * 5) + (level - 1) * ((this.special[2].getAttributeLevel()/2) + 2.5));
		return String.format("%.0f", hitPoints);
	}
	
	public String getActionPoints(){
		int perkModifier = 0;
		if (this.perks[32].level == 4){
			perkModifier += 25;
		}
		int actionPoints = 60 + perkModifier + this.special[5].getAttributeLevel() * 10;
		return String.valueOf(actionPoints);
	}
	
	public int getPerkLevel(){
		return Collections.max(this.perkLevel.values());
    }
	
	public String printRemaining(){
		if (this.remaining < 0){
			return "0";
		} else {
			return String.valueOf(this.remaining);
		}
	}
	
	public String getLevelNeeded(){
		int level = Math.max(this.getPerkLevel(), this.pointsUsed + 1);
		return String.valueOf(level);
		
	}
}

package core;

public class Perk {
	public int level;
	public PerkList perk;
	
	public Perk(PerkList perk, int level){
		this.perk = perk;
		this.level = level;
	}
	
	public int levelPerk(int statLevel){
		if (this.perk.getStatReq() > statLevel){
			return -1;
		}
		if (this.perk.getRanks() < this.level + 1){
			return -1;
		}
		this.level++;
		return this.perk.getLevelReq(level);
	}
	
	public int unlevelPerk(){
		if (this.level == 0){
			return -1;
		}
		this.level--;
		return this.perk.getLevelReq(level);
	}
}

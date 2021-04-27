package sugoroku;

public class Player {
	private String name;
	private int currentBlock=0;
	private boolean nextTurn = true;
	
	public Player(String name_) {
		this.setName(name_);
	}

	//�T�C�R�����]���������̏o�ڂ��o�����\�b�h
	public void throwDice(Dice dice) {
		int d = dice.diceRoll();
		System.out.println("�΂͓�����ꂽ�B");
		System.out.println("�T�C�R���̖ڂ�" + d + "!");
		this.setCurrentBlock(this.getCurrentBlock()+d);
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentBlock() {
		return this.currentBlock;
	}
	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

	public boolean isNextTurn() {
		return nextTurn;
	}

	public void setNextTurn(boolean nextTurn) {
		this.nextTurn = nextTurn;
	}

}

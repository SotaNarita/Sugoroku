package sugoroku;

import java.util.ArrayList;

public class Game {
	private int playerCount = 0;
	private Board board_;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private Dice dice_;
	private int topBlock=0;
	private int turn=0;
	
	public void start() {
		//�J�n���ɕ\�����镶��
		System.out.println("\n�o�Z���J�n���܂��B");
		System.out.println("�Q���v���C���[��");
		for (int i=0; i<playerList.size(); i++) {
			String str = playerList.get(i).getName();
			System.out.print(str + "   ");
		}
		System.out.print("�������ł��B\n\n");
		
		System.out.println(board_.blockNum.size()-1 + "�}�X�̃X�e�[�W");
		System.out.println("���Ⴀ�A�n�߂�");
		
		//��������o�Z�J�n
		while(this.getTopBlock()<board_.blockNum.size()) {
			
			for (int i=0; i<this.playerList.size(); i++) {//�Q���v���C���[�̐l�������[�v����
				Player current = playerList.get(i);
				int loc = current.getCurrentBlock();
				turn++;
				
				System.out.println(turn + "�^�[����");
				System.out.println(current.getName() + "�̔�");
				System.out.println("���ݒn��" + loc + "�}�X��!");
				
				if (current.isNextTurn() == true) {//�P��x�݂���Ȃ��l
					current.throwDice(dice_);
					loc = current.getCurrentBlock();
					if (this.getTopBlock()<loc) {
						this.setTopBlock(loc);
					}
					
					if (this.getTopBlock()>=(board_.blockNum.size()-1)) {//�o�ڂ̌��ʁA�}�X���𒴂���/�҂�����ɂȂ�����S�[��
						System.out.println(current.getName()+ "�̓S�[���ɂ��ǂ蒅����");
						break;
					}
					
					int c = Integer.parseInt(board_.blockNum.get(loc));
					int s = Integer.parseInt(board_.event.get(c));
					
					System.out.println("���ݒn��" + loc + "�}�X��!");
					System.out.println(board_.eventLog.get(c));	

						if (s>= 10) {//�P��x��
							System.out.println("1��x��\n");
							current.setNextTurn(false);
							
						} else {//�ǉ��̃}�X�ړ�
							if(s>0) {
								System.out.println("+" + s + "�}�X\n");
								current.setCurrentBlock(current.getCurrentBlock()+s);
							} else if (s<0) {
								System.out.println(s + "�}�X\n");
								current.setCurrentBlock(current.getCurrentBlock()+s);
							} else {
								System.out.println("\n");
							}
						}
				} else {//�P��x�݂̎��̃A�i�E���X
					System.out.println(current.getName() + "�͂P��x�ݒ�\n");
					current.setNextTurn(true);
				}
			}
			if (this.getTopBlock()>=board_.blockNum.size()-1) {
				System.out.println("����ƏI������c");
				break;
			}
		}
	}
	
	public void setBoard(Board board) {
		this.setBoard_(board);
	}
	
	public void addPlayer(Player player) {
		playerList.add(player);
		this.setPlayerCount(playerCount+1);
		System.out.println("�v���C���[" + playerCount + " " + player.getName() + " �G���g���[���܂����B");
	}
	
	public void setDice(Dice dice) {
		this.setDice_(dice);
	}

	public int getPlayerCount() {
		return playerCount;
	}
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
}


	public Board getBoard_() {
		return board_;
	}

	public void setBoard_(Board board_) {
		this.board_ = board_;
	}

	public Dice getDice_() {
		return dice_;
	}
	public void setDice_(Dice dice_) {
		this.dice_ = dice_;
	}

	public int getTopBlock() {
		return this.topBlock;
	}
	public void setTopBlock(int topBlock) {
		this.topBlock=topBlock;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

}

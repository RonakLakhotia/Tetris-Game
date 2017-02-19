

public class PlayerSkeleton {

	//implement this function to have a working system
	public int pickMove(State s, int[][] legalMoves, StateAnalyser analyser) {
		int maxScore = 0;
		int maxIndex = 0;
		
		for(int i=0; i<legalMoves.length; i++){
			int rowsCleared = analyser.genNextStateFromMove(s,legalMoves[i]);
			int score = analyser.calculateHeuristic();
			score += rowsCleared;
			
			if(score > maxScore){
				maxScore = score;
				maxIndex = i;
			}

		}
		
		return maxIndex;
	}
	
	public static void main(String[] args) {
		State s = new State();
		StateAnalyser analyser = new StateAnalyser();
		new TFrame(s);
		PlayerSkeleton p = new PlayerSkeleton();
		while(!s.hasLost()) {
			s.makeMove(p.pickMove(s,s.legalMoves(),analyser));
			s.draw();
			s.drawNext(0,0);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("You have completed "+s.getRowsCleared()+" rows.");
	}
	
}

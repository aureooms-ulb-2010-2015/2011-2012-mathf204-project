import java.util.Random;

class Snake {
	private Positions _positions = new Positions();
	private int _movements = 0;
	private Movement _forbiddenMovement = new Movement();
	
	public Snake(){
		this.moveTo(0,0);
		this._movements = 0;
	}
	
	public boolean success(int n){
		while (this._movements<n){
			//System.out.println(this._positions);
			//System.out.println(this._movements);
			//System.out.println(this._forbiddenMovement);
			if(!(this.randomMove())){
				return false;
			}
		}
		return true;
	}
	
	public void moveTo(int x,int y){
		Coordinates position = new Coordinates(x,y);
		this._movements++;
		this._positions.addPosition(position);
	}	
	public boolean move(Movement movement){
		Coordinates position = this._positions.actualPosition().moveWith(movement);
		if (position.isNotIn(this._positions)){
			this._movements++;
			this._positions.addPosition(position);
			return true;
		}
		return false;
	}
	
	public boolean randomMove(){
		Movements availableMovements = this._positions.actualPosition().availableMovements(this._forbiddenMovement);
		//System.out.println("available : "+availableMovements);
		Random random = new Random();
		Movement movement = availableMovements.get(random.nextInt(availableMovements.size()));	
		this._forbiddenMovement = movement.reverseAmplitude();	
		return this.move(movement);
	}
	

}
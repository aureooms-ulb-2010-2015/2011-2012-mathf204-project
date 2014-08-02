import java.util.ArrayList;


class Coordinates{
	private int _x;
	private int _y;
	public Coordinates(int x,int y){
		this._x = x;
		this._y = y;		
	}
	
	public int x(){
		return this._x;
	}	
	public int y(){
		return this._y;
	}
	
	public Coordinates moveWith(Movement movement){
		
		if(movement.x()){
			if(movement.positive()){
				return new Coordinates(this.x()+1,this.y());
			}
			if(movement.negative()){
				return new Coordinates(this.x()-1,this.y());				
			}
		}
		
		if(movement.positive()){
			return new Coordinates(this.x(),this.y()+1);
		}
		
		return new Coordinates(this.x(),this.y()-1);
	}
	
	public String toString(){
		String stream = "("+this.x()+","+this.y()+")";
		return stream;
	}
	
	public Movements availableMovements(Movement forbiddenMovement){
		Movements movements = new Movements();
		if (forbiddenMovement.notSet()){
			Movement m0 = new Movement().setX().setPositive();
			Movement m1 = new Movement().setY().setPositive();
			Movement m2 = new Movement().setX().setNegative();
			Movement m3 = new Movement().setY().setNegative();
			movements.add(m0).add(m1).add(m2).add(m3);
		}
		else{
			Movement m0 = new Movement();
			Movement m1 = new Movement();
			Movement m2 = new Movement();
			if(forbiddenMovement.x()){
				m0.setY().setPositive();
				m1.setY().setNegative();
				m2.setX();
			}
			else if(forbiddenMovement.y()){
				m0.setX().setPositive();
				m1.setX().setNegative();
				m2.setY();
			}
			
			if(forbiddenMovement.positive()){
				m2.setNegative();
			}
			
			else if(forbiddenMovement.negative()){
				m2.setPositive();
			}

			movements.add(m0).add(m1).add(m2);
			
		}
		//System.out.println("available : "+movements);
		return movements;
		
	}

	public boolean isNotIn(Positions positions) {
		int i = 0;
		while (i<positions.size()){
			//System.out.println("("+this.x()+" == "+positions.get(i).x()+") && ("+this.y()+" == "+positions.get(i).y()+")");
			if ((this.x() == positions.get(i).x()) && (this.y() == positions.get(i).y())){
				return false;
			}
			i++;
		}
		return true;
	}
}

class Positions{
	private ArrayList<Coordinates> _positions = new ArrayList<Coordinates>();
	
	public Positions(){
		
	}
	public void addPosition(Coordinates position){
		this._positions.add(position);
	}
	public Coordinates actualPosition(){
		return this._positions.get(this._positions.size()-1);
	}
	public Coordinates previousPosition(){
		return this._positions.get(this._positions.size()-2);
	}
	public Coordinates get(int index){
		return this._positions.get(index);
	}
	
	public int size(){
		return this._positions.size();
	}
	
	public String toString(){
		String stream = "[";
		if (this.size()>0){
			
			stream+=this.get(0).toString();
			
			int i = 1;
			while(i<this.size()){
				stream+=","+this.get(i).toString();
				i++;
			}
		}
		stream+="]";
		return stream;
	}
	
}

import java.util.ArrayList;

class Movements{
	private ArrayList<Movement> _movements = new ArrayList<Movement>();
	private int _size = 0;
	
	public Movements(){
		
	}
	
	public Movements add(Movement movement){
		this._movements.add(movement);
		this._size++;
		return this;
	}
	
	public int size(){
		return this._size;
	}
	
	public Movement get(int index){
		return this._movements.get(index);
	}
	
	public String toString(){
		return this._movements.toString();
	}
}


class Movement{
	private static int _X = 0;
	private static int _Y = 1;
	private static int _POSITIVE = 0;
	private static int _NEGATIVE = 1;
	private int _coordinate = -1;
	private int _direction = -1;
	
	public Movement(){
		
	}
	
	public Movement setX(){
		this._coordinate = Movement._X;
		return this;
	}
	public Movement setY(){
		this._coordinate = Movement._Y;
		return this;
	}
	public Movement setPositive(){
		this._direction = Movement._POSITIVE;
		return this;
	}
	public Movement setNegative(){
		this._direction = Movement._NEGATIVE;
		return this;
	}
	public boolean x(){
		return this._coordinate == Movement._X;
	}
	public boolean y(){
		return this._coordinate == Movement._Y;
	}
	public boolean positive(){
		return this._direction == Movement._POSITIVE;
	}
	public boolean negative(){
		return this._direction == Movement._NEGATIVE;
	}
	public Movement reverseAmplitude(){
		this._direction = (this._direction == Movement._NEGATIVE)?Movement._POSITIVE:Movement._NEGATIVE;
		return this;
	}
	public boolean notSet(){
		return !((this.x() || this.y()) && (this.positive() || this.negative()));
	}
	
	public String toString(){
		String stream = "("+this._coordinate+","+this._direction+")";
		return stream;
	}
}
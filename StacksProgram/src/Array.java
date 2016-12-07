/*Name: Taha Rangwala
 * Date: December 5, 2016
 * Purpose: The purpose of this class is to allow is to use the methods from the StackADT in order
 * to manage elements in an array
 */

//Array class header
public class Array <T extends Integer> implements StackADT{

	//Declaring private instance variables
	private Integer stackArray [];//This is the array being managed
	private int Count;//Count of the array
	
	//Constructor method to initialize private instance variables
	public Array(){
		Count = -1;
		stackArray = new Integer [10];
	}
	
	/*Purpose: This method uses the custom size the user specifies of the array
	 * @param Size This is the custom size the user wants
	 */
	public Array(int Size){
		Count = -1;
		stackArray = new Integer [Size];
	}

	/*Purpose: This method adds elements to the array
	 * @param element This is the element that is added to the array
	 */
	public void push(Object element) {
		Count++;
		if(isEmpty())
			throw new IllegalArgumentException("The Array Is Empty");
		stackArray[Count] = (Integer) element;
		checkSize();
	}
	
	//This checks the size of the array making sure that there is enough space in it
	//when there isn't enough space, it doubles the size of the array
	private void checkSize(){
		if(Count == stackArray.length){
			Integer tempArray [] = new Integer[stackArray.length * 2];
			for(int i = 0; i <= Count; Count++)
				tempArray[i] = stackArray[i];
			stackArray = tempArray;
		}
	}

	/*Purpose: This method takes off the last element of the array and returns the element
	 * @return This is the element that is being returned
	 */
	public Object pop() {
		if(isEmpty())
			throw new IllegalArgumentException("The Array Is Empty");
		Integer Temp = stackArray[Count];
		Count--;
		return Temp;
	}

	/*Purpose: This method returns the last element in the array
	 * @return This is the element that is being returned
	 */
	public Object peek() {
		return stackArray[Count];
	}

	/*Purpose: This checks if the array is empty
	 * @return This returns a boolean value denoting if the array is empty
	 */
	public boolean isEmpty() {
		return Count < 0;
	}

	/*Purpose: This gets the current amount of elements in the array
	 * @return This returns an integer value of the elements in the array
	 */
	public int size() {
		if(isEmpty())
			throw new IllegalArgumentException("The Array Is Empty");
		return Count + 1;
	}
	
	/*Purpose: This gets all of the information in the array
	 * @return This returns a string value of all of the information
	 */
	public String toString(){
		String Output = "";
		while(Count >= 0){
			Output += pop();
		}
		return Output;
	}
	
}

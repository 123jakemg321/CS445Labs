import java.util.Arrays;

/**
 *	ArrayQueue is a list data structure that implements the FIFO functionality in constant time.  In order to have constant runtime for enqueue
 *	and dequeue, a circular array will be backing the queue, instead of a regular array.
 */

public class ArrayQueueLab<E>
{
	private E[] data;
	private int size, front;

	@SuppressWarnings("unchecked")	
	public ArrayQueueLab()
	{
		data = (E[]) new Object[2];
		size = 0;
		front = 0;
	}
	
	public String toString()
	{
		String ret = "";
		for(int i = 0; i < size; i++)
		{
			if(i != size - 1)
			{
				ret += data[(i + front) % data.length] + ", ";
			}
			else
			{
				ret += data[(i + front) % data.length];
			}
		}
		
		return ret;
	}
	
	/**
	*	The enqueue method should add the newEntry to the back of the queue.  The back of the queue is not necessarily the end of the array,
	*	but instead determined using the front and size variables of the arrayQueue.  If the queue is full, make sure to resize the array.
	*   Note that the back index could be earlier in the data array than the front index due to the circular array.
	*
	*	@param newEntry the object to be added to the back of the queue
	*	@return True if added successfully, false otherwise
	*/
	public boolean enqueue(E newEntry)
	{
			return false;
	}
	
	/**
	*	The resize method should double the size of the data array, and "shift" all data so that the front of the queue is now stored at index 0
	*	of the array and the rest of the data follows sequentially.
	*/
	@SuppressWarnings("unchecked")
	private void resize()
	{

	}
	
	/**
	*	The dequeue method removes the front of the queue, i.e. the object stored at the front index of the data array.  The front index is then
	*	shifted forward appropriately.  Note that dequeue can be removing an object from the middle of the data array if that is where the front
	*	of the queue is at.  Due to the use of a circular array, no items need be shifted for dequeue giving dequeue a runtime of O(1)
	*/
	public E dequeue()
	{
		if(size != 0)
		{
			E ret = data[front];
			data[front] = null;
			size--;
			front = (front + 1) % data.length;        
			return ret;
		}
		else
			return null;
	}
	
	public E peek(E entry)
	{
		if(size != 0)
			return data[front];
		else
			return null;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public E[] getData()
	{
		return Arrays.copyOf(data, data.length);
	}
	
	public static void main(String[] args)
	{
		ArrayQueueLab<String> testQueue = new ArrayQueueLab<String>();
		testQueue.enqueue("First!");
		testQueue.enqueue("Second!");
		System.out.println("Initial List: " + testQueue);
		testQueue.enqueue("Third!");
		testQueue.enqueue("Fourth!");
		testQueue.enqueue("Fifth!");
		System.out.println("Resized list: " + testQueue);
		System.out.println(testQueue.dequeue() + " has been dequeued.");
		System.out.println("Remaining list: " + testQueue);
		testQueue.enqueue("Sixth!");
		testQueue.enqueue("Seventh!");
		testQueue.enqueue("Eighth!");
		testQueue.enqueue("Ninth!");
		System.out.println("New list with additions: " + testQueue);
		System.out.println("Current underlying data array: " + Arrays.toString(testQueue.getData()));
		System.out.println(testQueue.dequeue() + " has been dequeued.");
		System.out.println("New list with removal: " + testQueue);
		System.out.println("Current underlying data array: " + Arrays.toString(testQueue.getData()));
		testQueue.enqueue("Tenth!");
		testQueue.enqueue("Eleventh!");
		System.out.println("Newly resized list: " + testQueue);
		System.out.println("Final underlying data array: " + Arrays.toString(testQueue.getData()));
	}
}
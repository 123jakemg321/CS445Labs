import java.util.Arrays;

public class ArrayQueue<E>
{
	private E[] data;
	private int size, front;

	@SuppressWarnings("unchecked")	
	public ArrayQueue()
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
			if(i == size - 1)
			{
				ret += data[(i + front) % data.length];
			}
			else
			{
				ret += data[(i + front) % data.length] + ", ";
			}
		}
		
		return ret;
	}
	
	public boolean enqueue(E entry)
	{
		if(size == data.length)
			resize();
		data[(front + size) % data.length] = entry;
		size += 1;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private void resize()
	{
		E[] newData = (E[]) new Object[data.length * 2];
		for(int i = 0; i < size; i++)
		{
			newData[i] = data[(i + front) % data.length];
		}
		front = 0;
		data = newData;
	}
	
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
		ArrayQueue<String> testQueue = new ArrayQueue<String>();
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
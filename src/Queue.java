
public class Queue    // Queue was created for cargo to go in order.
{
	 // QUEUE CLASS // 
		private int rear,front;
		private String[] elements;
		
		Queue (int capacity)
		{
			elements = new String [capacity];
			rear=-1;
			front=0;
		}
		
		void enqueue(Cargo data){
			if(isFull())
			{
				System.out.println("Queue overflow");
			}
			else{
				rear++;
				// The queue contains some information about the location of the cargo.
				elements[rear]=data.location+","+data.state;
			}
		}
		
		Object dequeue()
		{
			if(isEmpty())
			{
				System.out.println("Queue is empty");
				return null;
			}
			else{
				Object retData = elements[front];
				elements[front]=null;
				front++;
				return retData;
			}
		}
		Object peek()
		{
			if(isEmpty())
			{
				System.out.println("Queue is empty");
				return null;
			}
			else{
				return elements[front];
			}
		}
		boolean isEmpty()
		{
			return rear<front;
		}
		
		boolean isFull()
		{
			return (rear + 1 == elements.length);
		}
		int size()
		{
			return rear - front + 1 ;
		}
	}



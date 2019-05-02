package amazon_practice;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public class ProducerConsumerReentrantLock {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> buffer = new ArrayList<String>();
		ReentrantLock bufferLock = new ReentrantLock();
		(new Thread(new NewConsume(buffer,bufferLock))).start();
		(new Thread(new NewConsume(buffer,bufferLock))).start();
		(new Thread(new NewProduce(buffer,bufferLock))).start();	
	}
}

class NewProduce implements Runnable{
	List<String> buffer;
	ReentrantLock bufferLock;
	public NewProduce(List<String> buffer, ReentrantLock buffeLock){
		this.buffer = buffer;
		this.bufferLock = buffeLock;
	}
	public void run(){
		Random random = new Random();
		String[] nums = new String[]{"1","2","3","4"};
		for (String num: nums){
			bufferLock.lock();
			try{
				buffer.add(num);
			}finally{
				bufferLock.unlock();
			}
			try{
				Thread.sleep(random.nextInt(1000));
			}catch(InterruptedException e){
				
			}
		}
		bufferLock.lock();
		buffer.add("EOF");
		bufferLock.unlock();
	}
}

class NewConsume implements Runnable{
	private static final String EOF = "EOF";
	List<String> buffer;
	ReentrantLock bufferLock;
	public NewConsume(List<String> buffer, ReentrantLock bufferLock){
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}
	public void run(){
		int counter = 0;
		while(true){
			if (bufferLock.tryLock()){
				try{
					if (buffer.isEmpty()){
						continue;
					}
					System.out.println("Conter :" + counter);
					counter = 0;
					if (buffer.get(0).equals(EOF)){
						System.out.println("Consumed everything");
						break;
					}else{
						System.out.println("Removed : " + buffer.remove(0));
					}
				}finally{
					bufferLock.unlock();
				}
			}else{
				counter++;
			}
			
		}
	}
}
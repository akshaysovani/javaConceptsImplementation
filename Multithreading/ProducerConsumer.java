package amazon_practice;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
public class ProducerConsumer2 {
	//public static final String EOF = "EOF";
	public static void main(String[] args) {
		List<String> buffer = new ArrayList<String>();
		(new Thread(new Consumer(buffer))).start();
		(new Thread(new Consumer(buffer))).start();
		(new Thread(new Producer(buffer))).start();
	}
}

class Producer implements Runnable{
	List<String> buffer;
	public Producer(List<String> buffer){
		this.buffer = buffer;
	}
	public void run(){
		Random random = new Random();
		String[] nums = new String[]{"1","2","3","4"};
		for (String num: nums){
			synchronized(buffer){
				buffer.add(num);
			}
			try{
				Thread.sleep(random.nextInt(1000));
			}catch(InterruptedException e){
				
			}
		}
		synchronized(buffer){
			buffer.add("EOF");
		}
	}
}

class Consumer implements Runnable{
	private static final String EOF = "EOF";
	List<String> buffer;
	public Consumer(List<String> buffer){
		this.buffer = buffer;
	}
	public void run(){
		while(true){
			synchronized(buffer){
				if (buffer.isEmpty()){
					continue;
				}
				if (buffer.get(0).equals(EOF)){
					System.out.println("Consumed everything");
					break;
				}else{
					System.out.println("Removed : " + buffer.remove(0));
				}
			}
		}
	}
}
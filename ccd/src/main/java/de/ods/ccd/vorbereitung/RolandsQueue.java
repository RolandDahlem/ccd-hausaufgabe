package de.ods.ccd.vorbereitung;

public class RolandsQueue <T extends Object> {

	private static class Element<T extends Object>{
		
		private T value;
		private Element<T> next;

		public Element(T value) {
			this.value = value;
			this.next = null;
		}

		public boolean hasNext() {
			return next != null;
		}

		public Element<T> getNext() {
			return next;
		}

		public T getValue() {
			return value;
		}

		public void setNext(Element<T> element) {
			next = element;
		}
	}
	
	private Element<T> firstElement = null;
	
	public void enque(T value) {
		
		Element<T> element = new Element<T>(value);
		
		if(isEmpty()){
			firstElement = element;
		} else {
			firstElement.setNext(element);
		}
	}

	private boolean isEmpty() {
		return firstElement == null;
	}

	public int count() {
		if(firstElement == null){
			return 0;
		} else {
			int counter = 1;
			Element<T> aktuellesElement = firstElement;
			while(aktuellesElement.hasNext()){
				counter++;
				aktuellesElement = aktuellesElement.getNext();
			}
			return counter;
		}

	}

	public T dequeue() {
		
		Element<T> secondElement = firstElement.getNext();
		T result = firstElement.getValue();
		firstElement = secondElement;
		return result;
	}

	public T peek() {
		return firstElement.getValue();
	}

	public boolean tryDequeue() {
		if(isEmpty()){
			return false;
		} else {
			dequeue();
			return true;
		}
	}

}

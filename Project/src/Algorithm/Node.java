package Algorithm;

import java.util.ArrayList;

public class Node {


	String id;
	String title;
	String author;
	String tag;
	ArrayList<String> paragraphs;
	String paragraph;
	Node next;
	Node pre;
	int degree;
	Node head =null;
	Node (String id ,String title,String author, String tag, ArrayList<String> paragraph, int degree) {
		super();
		this.id=id;
		this.title=title;
		this.author=author;
		this.tag=tag;
		this.paragraphs=paragraphs;
		this.degree = degree;
		this.next = null;
		this.degree = degree;
		next = null;
	}
	Node(String title,String author) {
		super();
		this.title = title;
		this.author = author;
	}
	public int getdegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public  void setAuthor(String author) {
		this.author = author;
	}
	
	public String  getAuthor() {
		return author;
	}
	public  void  setTitle(String title) {
		this.title =  title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public ArrayList<String> getParagraphs() {
		return paragraphs;
	}
	public void setParagraph(ArrayList<String> paragraphs) {
		this.paragraphs = paragraphs;
	}
	public String getParagraph() {
		return paragraph = paragraphs.get(0).replaceAll(" ","");
	}
	
	@Override
	public String toString() {
		
		return "node"; 
	}
	

}

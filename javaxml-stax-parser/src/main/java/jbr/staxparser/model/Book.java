package jbr.staxparser.model;

public class Book {
	private String _id;
	private String _category;
	private String _name;
	private String _author;
	private String _isbn;
	private String _price;
	private String _publisher;

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		this._category = category;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		this._author = author;
	}

	public String getIsbn() {
		return _isbn;
	}

	public void setIsbn(String isbn) {
		this._isbn = isbn;
	}

	public String getPrice() {
		return _price;
	}

	public void setPrice(String price) {
		this._price = price;
	}

	public String getPublisher() {
		return _publisher;
	}

	public void setPublisher(String publisher) {
		this._publisher = publisher;
	}
}

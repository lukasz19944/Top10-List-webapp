package web.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import web.dao.ListVoteDao;

@Entity
@Table(name="list")
public class OrderedList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="publish_date")
	private LocalDate publishDate;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private User author;
	
	@OneToMany(mappedBy="list", targetEntity=Item.class,
			fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Item> items = new ArrayList<>();

	public OrderedList() {
	
	}

	public OrderedList(String name, String description, LocalDate publishDate) {
		this.name = name;
		this.description = description;
		this.publishDate = publishDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderedList [id=" + id + ", name=" + name + ", description=" + description + ", publishDate="
				+ publishDate + ", author=" + author + ", items=" + items + "]";
	}
	
	public long calculateRating() {
		ListVoteDao listVoteDao = new ListVoteDao();
		
		long rating = listVoteDao.getVoteCount(this.getId(), "up") - listVoteDao.getVoteCount(this.getId(), "down");
		
		return rating;
	}
	
	public String userVote(int userId) {
		ListVoteDao listVoteDao = new ListVoteDao();
		
		String vote = listVoteDao.getByUserAndList(userId, this.getId()).getVote();
		
		return vote;
	}
	
}

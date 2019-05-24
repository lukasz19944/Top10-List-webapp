package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import web.dao.ListVoteDao;

@Entity
@Table(name="list_vote")
public class ListVote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="vote")
	private String vote;
	
	@ManyToOne
	@JoinColumn(name="list_id")
	private OrderedList list;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public ListVote() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public OrderedList getList() {
		return list;
	}

	public void setList(OrderedList list) {
		this.list = list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

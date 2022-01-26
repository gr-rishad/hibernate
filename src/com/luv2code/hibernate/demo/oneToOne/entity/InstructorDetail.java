package com.luv2code.hibernate.demo.oneToOne.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	// annotated the class as an Entity and map to db table
	// define the fields
	// annotated the fields with db column names
	// create Constructors
	// generate getter/setter methods
	// generate topString() method
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	@Column(name = "hobby") 
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH,
			CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	private Instructor instructor;
	
	public InstructorDetail() {}
	
	

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	

	public Instructor getInstructor() {
		return instructor;
	}



	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}



	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
	
	
	

}

package zee.cms.entity;

import javax.persistence.*;

@Entity
@Table(name="teacher_detail")
public class TeacherDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String channel;

	@Column(name="hobby")
	private String hobby;

	
	// For Bi-directional flow
//	@OneToOne(mappedBy="teacherDetailId", cascade= {CascadeType.DETACH, CascadeType.MERGE, 
//			CascadeType.PERSIST, CascadeType.REFRESH})
//	private Teacher teacher;
	//--------------------------
	
	//=====================================================================================

	public TeacherDetail() { }
	public TeacherDetail(String channel, String hobby) {
		this.channel = channel;
		this.hobby = hobby;
	}
	//=====================================================================================

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getChannel() { return channel; }
	public void setChannel(String channel) { this.channel = channel; }
	public String getHobby() { return hobby; }
	public void setHobby(String hobby) { this.hobby = hobby; }
//	public Teacher getTeacher() { return teacher; }
//	public void setTeacher(Teacher teacher) { this.teacher = teacher; }
	//=====================================================================================
 
	@Override
	public String toString() {
		return "TeacherDetail [id=" + id + ", channel=" + channel + ", hobby=" + hobby + "]";
	}
	
}

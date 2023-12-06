package ef.model;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "id_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private File file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Event() {
    }

    public Event(User user, File file) {
        this.user = user;
        this.file = file;
    }

    public Event(Integer id, User user, File file) {
        this.id = id;
        this.user = user;
        this.file = file;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", user ID=" + user.getId() +
                ", username=" + user.getName() +
                ", filename=" + file.getName() +
                ", path=" + file.getFilePath() +
                '}';
    }
}
